package com.example.demo.member.mapper;

import com.example.demo.common.support.mapper.DomainEntityMapper;
import com.example.demo.member.domain.Member;
import com.example.demo.member.entity.MemberEntity;
import org.mapstruct.Mapper;

@Mapper
public interface MemberEntityMapper extends DomainEntityMapper<Member, MemberEntity> {
}
