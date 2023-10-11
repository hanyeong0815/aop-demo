package com.example.demo.member.aspect;

import com.example.demo.common.support.exception.support.Preconditions;
import com.example.demo.member.domain.rdb.Member;
import com.example.demo.member.domain.redis.SignTry;
import com.example.demo.member.domain.type.MemberStatusType;
import com.example.demo.member.exception.MemberErrorCode;
import com.example.demo.member.repository.rdb.MemberRepository;
import com.example.demo.member.repository.redis.SignTryRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import static com.example.demo.common.support.exception.support.Preconditions.validate;

@Component
@Aspect
@RequiredArgsConstructor
public class LogInAspect {
    private final SignTryRepository signTryRepository;
    private final MemberRepository memberRepository;

    @Before(value = "@annotation(MemberLogInAspect) && args(member)")
    public void SignTry(Member member) {
        signTryRepository.save(
                SignTry.builder()
                        .username(member.username)
                        .tryCount(0)
                        .ttl(30_000L)
                        .build()
        );
    }

    @AfterThrowing(value = "@annotation(MemberLogInAspect) && args(member)")
    public void countUpSignTry(Member member) {
        SignTry signTry = signTryRepository.findById(member.username)
                .orElse(
                        SignTry.builder()
                                .username(member.username)
                                .tryCount(0)
                                .ttl(30_000L)
                                .build()
                );
        signTry.tryCount++;
        SignTry savedSignTry = signTryRepository.save(signTry);
        if (savedSignTry.tryCount >= 5) {
            boolean updateMemberStatus = memberRepository.updateStatus(member.username, MemberStatusType.PROTECTED);
            validate(
                    !updateMemberStatus,
                    MemberErrorCode.NO_SUCH_USER
            );
            throw MemberErrorCode.PROTECTED_ACCOUNT.defaultException();
        }
    }

    @AfterReturning(value = "@annotation(MemberLogInAspect)", returning = "member")
    public void deleteSignTry(Member member) {
        signTryRepository.deleteById(member.username);
    }
}
