package com.example.demo.signlog.service;

import com.example.demo.signlog.domain.SignLog;
import com.example.demo.signlog.repository.SignLogRepository;
import com.example.demo.signlog.usecase.SignLogSaveUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignLogService implements SignLogSaveUseCase {
    private final SignLogRepository repository;

    @Override
    public SignLog save(SignLog signLog) {
        return repository.save(signLog);
    }
}
