package com.example.demo.member.mapper;

import com.example.demo.member.domain.rdb.Member;
import com.example.demo.member.domain.type.MemberStatusType;
import com.example.demo.member.dto.MemberLogInDto.MemberLogInRequestDto;
import com.example.demo.member.dto.MemberSaveDto.MemberSaveRequestDto;
import com.example.demo.member.dto.MemberSaveDto.MemberSaveResponseDto;
import org.mapstruct.Mapper;

import java.time.Instant;

@Mapper
public interface MemberDtoMapper {
    Member from(MemberSaveRequestDto requestDto, MemberStatusType status, Instant createdAt);
    MemberSaveResponseDto from(Member member);
    Member from(MemberLogInRequestDto dto);
}
