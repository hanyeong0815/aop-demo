package com.example.demo.member.domain.read_model;

import lombok.Builder;

public record MemberReadModel() {
    @Builder
    public record MemberLogInReadModel(
            String username,
            String name
    ) {}
}
