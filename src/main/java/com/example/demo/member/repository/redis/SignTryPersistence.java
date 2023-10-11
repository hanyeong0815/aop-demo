package com.example.demo.member.repository.redis;

import com.example.demo.member.domain.redis.SignTry;
import com.example.demo.member.entity.SignTryRedis;
import com.example.demo.member.mapper.SignTryRedisMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SignTryPersistence implements SignTryRepository {
    private final SignTryRedisRepository repository;
    private final SignTryRedisMapper mapper;

    @Override
    public SignTry save(SignTry signTry) {
        SignTryRedis signTryRedis = mapper.toEntity(signTry);
        return mapper.toDomain(
                repository.save(signTryRedis)
        );
    }

    @Override
    public Optional<SignTry> findById(String username) {
        return repository.findById(username).map(mapper::toDomain);
    }

    @Override
    public boolean deleteById(String username) {
        repository.deleteById(username);
        return true;
    }
}
