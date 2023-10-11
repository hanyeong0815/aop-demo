package com.example.demo.member.domain.type;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum MemberStatusType {
    PENDING(false),
    ACTIVE(true),
    PROTECTED(false),
    SUSPENDED(false),
    SLEPT(false),
    REMOVED(false);

    public final boolean canSignIn;
}
