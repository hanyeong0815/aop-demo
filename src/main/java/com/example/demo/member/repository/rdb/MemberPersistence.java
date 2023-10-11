package com.example.demo.member.repository.rdb;

import com.example.demo.member.domain.rdb.Member;
import com.example.demo.member.domain.type.MemberStatusType;
import com.example.demo.member.entity.MemberEntity;
import com.example.demo.member.mapper.MemberEntityMapper;
import com.example.demo.signlog.domain.type.SignType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

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

    @Override
    public Optional<Member> findById(UUID id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Optional<Member> findByUsername(String username) {
        return repository.findByUsername(username).map(mapper::toDomain);
    }

    @Override
    public boolean updateStatus(String username, MemberStatusType signType) {

        return repository.updateStatus(username, signType) > 1;
    }
}
