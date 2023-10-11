package com.example.demo.member.domain.rdb;

import com.example.demo.member.domain.type.MemberStatusType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    public UUID id;
    public String username;
    public String password;
    public String name;
    public MemberStatusType status;
    public Instant createdAt;
}
