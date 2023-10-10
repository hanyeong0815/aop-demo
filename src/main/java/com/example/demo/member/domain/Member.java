package com.example.demo.member.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    public String id;
    public String username;
    public String password;
    public String name;
    public Instant createdAt;
}
