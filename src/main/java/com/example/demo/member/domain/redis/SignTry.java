package com.example.demo.member.domain.redis;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignTry {
    public String username;
    public int tryCount;
    public Long ttl;
}
