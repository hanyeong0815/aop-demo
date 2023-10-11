package com.example.demo.member.usecase;

import com.example.demo.member.domain.rdb.Member;

public interface MemberSaveUseCase {
    Member save(Member member);
}
