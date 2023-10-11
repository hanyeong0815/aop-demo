package com.example.demo.signlog.mapper;

import com.example.demo.common.support.mapper.DomainEntityMapper;
import com.example.demo.signlog.domain.SignLog;
import com.example.demo.signlog.entity.SignLogEntity;
import org.mapstruct.Mapper;

@Mapper
public interface SignLogEntityMapper extends DomainEntityMapper<SignLog, SignLogEntity> {
}
