package com.example.demo.member.service;

import com.example.demo.member.domain.Member;
import com.example.demo.member.exception.MemberErrorCode;
import com.example.demo.member.repository.MemberRepository;
import com.example.demo.member.usecase.MemberSaveUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.example.demo.common.support.exception.support.Preconditions.validate;

@Service
@RequiredArgsConstructor
public class MemberService implements MemberSaveUseCase {
    private final MemberRepository repository;
    private final PasswordEncoder encoder;

    @Override
    public Member save(Member member) {
        boolean hasMember = repository.existsMemberByUsername(member.username);
        validate(
                hasMember,
                MemberErrorCode.USERNAME_ALREADY_USED
        );

        member.password = encoder.encode(member.password);

        return repository.save(member);
    }
}
