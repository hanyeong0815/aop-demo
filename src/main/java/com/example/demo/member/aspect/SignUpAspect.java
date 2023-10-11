package com.example.demo.member.aspect;

import com.example.demo.member.domain.rdb.Member;
import com.example.demo.member.exception.MemberErrorCode;
import com.example.demo.member.repository.rdb.MemberRepository;
import com.example.demo.signlog.domain.SignLog;
import com.example.demo.signlog.domain.type.SignType;
import com.example.demo.signlog.usecase.SignLogSaveUseCase;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import static com.example.demo.common.support.exception.support.Preconditions.validate;

@Aspect
@Component
@RequiredArgsConstructor
public class SignUpAspect {
    private final SignLogSaveUseCase signLogSaveUseCase;
    private final MemberRepository memberRepository;

    @Before(value = "@annotation(MemberSignUpAspect) && args(member)")
    public void hasMember(Member member) {
        boolean hasMember = memberRepository.existsMemberByUsername(member.username);
        validate(
                hasMember,
                MemberErrorCode.USERNAME_ALREADY_USED
        );
    }

    @AfterReturning(value = "@annotation(MemberSignUpAspect)", returning = "member")
    public SignLog SignUpSignLog(Member member) {
        SignLog signLog = SignLog.builder()
                .memberId(member.id)
                .username(member.username)
                .eventType(SignType.SIGN_UP)
                .signAt(member.createdAt)
                .build();
        return signLogSaveUseCase.save(signLog);
    }
}
