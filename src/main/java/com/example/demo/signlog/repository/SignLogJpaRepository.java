package com.example.demo.signlog.repository;

import com.example.demo.signlog.entity.SignLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignLogJpaRepository extends JpaRepository<SignLogEntity, Long> {
}
