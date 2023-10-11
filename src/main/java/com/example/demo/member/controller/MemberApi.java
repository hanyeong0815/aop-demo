package com.example.demo.member.controller;

import com.example.demo.member.domain.rdb.Member;
import com.example.demo.member.domain.read_model.MemberReadModel.MemberLogInReadModel;
import com.example.demo.member.dto.MemberLogInDto.MemberLogInRequestDto;
import com.example.demo.member.dto.MemberSaveDto.MemberSaveRequestDto;
import com.example.demo.member.dto.MemberSaveDto.MemberSaveResponseDto;
import com.example.demo.member.mapper.MemberDtoMapper;
import com.example.demo.member.usecase.MemberLogInUseCase;
import com.example.demo.member.usecase.MemberSaveUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("member")
@RequiredArgsConstructor
public class MemberApi {
    private final MemberSaveUseCase memberSaveUseCase;
    private final MemberLogInUseCase memberLogInUseCase;
    private final MemberDtoMapper mapper;

    @PostMapping("")
    public MemberSaveResponseDto memberSave(@RequestBody MemberSaveRequestDto dto) {
        Member member = mapper.from(dto, Instant.now());
        return mapper.from(
                memberSaveUseCase.save(member)
        );
    }

    @GetMapping("login")
    public MemberLogInReadModel login(@RequestBody MemberLogInRequestDto dto) {
        Member member = mapper.from(dto);
        return memberLogInUseCase.logIn(member);
    }
}
