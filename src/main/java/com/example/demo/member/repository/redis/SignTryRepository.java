package com.example.demo.member.repository.redis;

import com.example.demo.member.domain.redis.SignTry;

import java.util.Optional;

public interface SignTryRepository {
    SignTry save(SignTry signTry);
    Optional<SignTry> findById(String username);
    boolean deleteById(String username);
}
