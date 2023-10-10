package com.example.demo.member.mapper;

import com.example.demo.member.domain.Member;
import com.example.demo.member.dto.MemberSaveDto.MemberSaveRequestDto;
import com.example.demo.member.dto.MemberSaveDto.MemberSaveResponseDto;
import org.mapstruct.Mapper;

import java.time.Instant;

@Mapper
public interface MemberDtoMapper {
    Member from(MemberSaveRequestDto requestDto, Instant createdAt);
    MemberSaveResponseDto from(Member member);
}
