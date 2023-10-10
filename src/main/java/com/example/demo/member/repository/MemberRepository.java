package com.example.demo.member.repository;

import com.example.demo.member.domain.Member;

public interface MemberRepository {
    Member save(Member member);
    boolean existsMemberByUsername(String username);
}
