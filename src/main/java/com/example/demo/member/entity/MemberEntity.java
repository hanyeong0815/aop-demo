package com.example.demo.member.entity;

import com.example.demo.core.jpa.UuidBaseEntity;
import jakarta.persistence.Entity;
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
    public Instant createdAt;
}
