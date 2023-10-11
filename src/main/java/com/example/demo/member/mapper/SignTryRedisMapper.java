package com.example.demo.member.mapper;

import com.example.demo.common.support.mapper.DomainEntityMapper;
import com.example.demo.member.domain.redis.SignTry;
import com.example.demo.member.entity.SignTryRedis;
import org.mapstruct.Mapper;

@Mapper
public interface SignTryRedisMapper extends DomainEntityMapper<SignTry, SignTryRedis> {
}
