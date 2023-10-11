package com.example.demo.member.usecase;

import com.example.demo.member.domain.rdb.Member;
import com.example.demo.member.domain.read_model.MemberReadModel.MemberLogInReadModel;

public interface MemberLogInUseCase {
    MemberLogInReadModel logIn(Member member);
}
