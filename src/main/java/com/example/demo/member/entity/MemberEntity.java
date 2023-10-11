package com.example.demo.member.entity;

import com.example.demo.core.jpa.UuidBaseEntity;
import com.example.demo.member.domain.type.MemberStatusType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.Instant;

import static com.example.demo.member.support.MemberConstants.SCHEMA;
import static com.example.demo.member.support.MemberConstants.TB_MEMBER;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
        schema = SCHEMA,
        catalog = SCHEMA,
        name = TB_MEMBER
)
public class MemberEntity extends UuidBaseEntity {
    public String username;
    public String password;
    public String name;
    @Enumerated(EnumType.STRING)
    public MemberStatusType status;
    public Instant createdAt;
}
