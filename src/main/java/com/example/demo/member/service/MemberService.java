package com.example.demo.member.service;

import com.example.demo.member.aspect.MemberLogInAspect;
import com.example.demo.member.aspect.MemberSignUpAspect;
import com.example.demo.member.domain.rdb.Member;
import com.example.demo.member.domain.read_model.MemberReadModel.MemberLogInReadModel;
import com.example.demo.member.exception.MemberErrorCode;
import com.example.demo.member.repository.rdb.MemberRepository;
import com.example.demo.member.usecase.MemberLogInUseCase;
import com.example.demo.member.usecase.MemberSaveUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.example.demo.common.support.exception.support.Preconditions.validate;

@Service
@RequiredArgsConstructor
public class MemberService
        implements
        MemberSaveUseCase,
        MemberLogInUseCase
{
    private final MemberRepository repository;
    private final PasswordEncoder encoder;

    @MemberSignUpAspect
    @Override
    public Member save(Member member) {
        member.password = encoder.encode(member.password);

        return repository.save(member);
    }

    @MemberLogInAspect
    @Override
    public MemberLogInReadModel logIn(Member member) {
        Member findMember = repository.findByUsername(member.username)
                .orElseThrow(MemberErrorCode.NO_SUCH_USER::defaultException);

        validate(
                !findMember.status.canSignIn,
                MemberErrorCode.PROTECTED_ACCOUNT
        );

        boolean matchPw = encoder.matches(member.password, findMember.password);
        if (!matchPw) {
            throw MemberErrorCode.INVALID_USERNAME_OR_PASSWORD.defaultException();
        }

        return MemberLogInReadModel.builder()
                .username(findMember.username)
                .name(findMember.name)
                .build();
    }
}
