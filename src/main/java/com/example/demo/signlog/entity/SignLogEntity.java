package com.example.demo.signlog.entity;

import com.example.demo.core.jpa.BaseEntity;
import com.example.demo.signlog.domain.type.SignType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

import static com.example.demo.member.support.MemberConstants.SCHEMA;
import static com.example.demo.signlog.support.SignLogConstants.TB_SIGN_LOG;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
        schema = SCHEMA,
        catalog = SCHEMA,
        name = TB_SIGN_LOG
)
public class SignLogEntity extends BaseEntity {
    public UUID memberId;
    public String username;
    @Enumerated(EnumType.STRING)
    public SignType eventType;
    public Instant signAt;
}
