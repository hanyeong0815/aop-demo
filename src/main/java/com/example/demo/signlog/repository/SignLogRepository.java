package com.example.demo.signlog.repository;

import com.example.demo.signlog.domain.SignLog;

public interface SignLogRepository {
    SignLog save(SignLog signLog);
}
