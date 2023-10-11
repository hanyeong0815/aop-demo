package com.example.demo.member.entity;

import jakarta.persistence.Index;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

import java.util.concurrent.TimeUnit;

@Builder
@ToString
@EqualsAndHashCode
@RedisHash("sign_try")
public class SignTryRedis {
    @Id
    public String username;
    @Indexed
    public int tryCount;

    @TimeToLive(unit = TimeUnit.MILLISECONDS)
    public Long ttl;
}
