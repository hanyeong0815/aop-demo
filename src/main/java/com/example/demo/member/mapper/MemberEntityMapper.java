package com.example.demo.member.mapper;

import com.example.demo.common.support.mapper.DomainEntityMapper;
import com.example.demo.member.domain.rdb.Member;
import com.example.demo.member.domain.read_model.MemberReadModel.MemberLogInReadModel;
import com.example.demo.member.entity.MemberEntity;
import com.example.demo.member.entity.projection.MemberProjection.MemberLogInProjection;
import org.mapstruct.Mapper;

@Mapper
public interface MemberEntityMapper extends DomainEntityMapper<Member, MemberEntity> {
    MemberLogInReadModel from(MemberLogInProjection projection);
}
