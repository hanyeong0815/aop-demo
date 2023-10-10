package com.example.demo.member.repository;

import com.example.demo.member.domain.Member;
import com.example.demo.member.entity.MemberEntity;
import com.example.demo.member.mapper.MemberEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberPersistence implements MemberRepository {
    private final MemberEntityMapper mapper;
    private final MemberJpaRepository repository;


    @Override
    public Member save(Member member) {
        MemberEntity memberEntity = mapper.toEntity(member);

        return mapper.toDomain(
                repository.save(memberEntity)
        );
    }

    @Override
    public boolean existsMemberByUsername(String username) {
        return repository.existsByUsername(username);
    }
}
