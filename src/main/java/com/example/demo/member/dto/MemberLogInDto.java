package com.example.demo.member.dto;

import lombok.Builder;

public record MemberLogInDto() {
    @Builder
    public record MemberLogInRequestDto(
            String username,
            String password
    ) {}
}
