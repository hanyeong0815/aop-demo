package com.example.demo.member.controller;

import com.example.demo.member.domain.Member;
import com.example.demo.member.dto.MemberSaveDto.MemberSaveRequestDto;
import com.example.demo.member.dto.MemberSaveDto.MemberSaveResponseDto;
import com.example.demo.member.mapper.MemberDtoMapper;
import com.example.demo.member.usecase.MemberSaveUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("member")
@RequiredArgsConstructor
public class MemberApi {
    private final MemberSaveUseCase memberSaveUseCase;
    private final MemberDtoMapper mapper;

    @PostMapping("")
    public MemberSaveResponseDto memberSave(@RequestBody MemberSaveRequestDto dto) {
        Member member = mapper.from(dto, Instant.now());
        return mapper.from(
                memberSaveUseCase.save(member)
        );
    }
}
