package com.example.demo.member.repository.rdb;

import com.example.demo.member.domain.rdb.Member;
import com.example.demo.member.domain.type.MemberStatusType;
import com.example.demo.signlog.domain.type.SignType;

import java.util.Optional;
import java.util.UUID;

public interface MemberRepository {
    Member save(Member member);
    boolean existsMemberByUsername(String username);
    Optional<Member> findById(UUID id);
    Optional<Member> findByUsername(String username);
    boolean updateStatus(String username, MemberStatusType signType);
}
