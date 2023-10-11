package com.example.demo.signlog.domain;

import com.example.demo.signlog.domain.type.SignType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignLog {
    public Long id;
    public UUID memberId;
    public String username;
    public SignType eventType;
    public Instant signAt;
}
