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
public class MemberService implements MemberSaveUseCase {
public class MemberService
        implements
        MemberSaveUseCase,
{
    private final MemberRepository repository;
    private final PasswordEncoder encoder;

    @MemberSignUpAspect
    @Override
    public Member save(Member member) {
        member.password = encoder.encode(member.password);

        return repository.save(member);
    }
}
