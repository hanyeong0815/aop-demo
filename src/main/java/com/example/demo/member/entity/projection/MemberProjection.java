package com.example.demo.member.entity.projection;

public record MemberProjection() {
    public record MemberLogInProjection(
            String username,
            String name
    ) {}
}
