package com.example.demo.member.repository.rdb;

import com.example.demo.member.domain.type.MemberStatusType;
import com.example.demo.member.entity.MemberEntity;
import com.example.demo.signlog.domain.type.SignType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

public interface MemberJpaRepository extends JpaRepository<MemberEntity, UUID> {
    boolean existsByUsername(String username);

    Optional<MemberEntity> findByUsername(String username);

    @Transactional
    @Modifying
    @Query(
            "update MemberEntity me set me.status = ?2 where me.username = ?1"
    )
    Integer updateStatus(String username, MemberStatusType signType);
}
