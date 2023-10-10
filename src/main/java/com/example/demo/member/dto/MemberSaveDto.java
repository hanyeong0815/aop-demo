package com.example.demo.member.dto;

import java.time.Instant;

public record MemberSaveDto() {
    public record MemberSaveRequestDto(
            String username,
            String password,
            String name
    ) {}

    public record MemberSaveResponseDto(
            String username,
            String name,
            Instant createdAt
    ) {}
}
