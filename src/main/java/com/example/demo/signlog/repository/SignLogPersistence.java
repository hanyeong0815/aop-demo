package com.example.demo.signlog.repository;

import com.example.demo.signlog.domain.SignLog;
import com.example.demo.signlog.entity.SignLogEntity;
import com.example.demo.signlog.mapper.SignLogEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SignLogPersistence implements SignLogRepository {
    private final SignLogEntityMapper mapper;
    private final SignLogJpaRepository repository;

    @Override
    public SignLog save(SignLog signLog) {
        SignLogEntity signLogEntity = mapper.toEntity(signLog);
        SignLogEntity savedSignLogEntity = repository.save(signLogEntity);
        System.out.println(savedSignLogEntity);
        return mapper.toDomain(savedSignLogEntity);
    }
}
