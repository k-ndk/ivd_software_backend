package com.bio.system.log.service;

import com.bio.system.common.findId;
import com.bio.system.log.dto.logReqestDto;
import com.bio.system.log.entity.log;
import com.bio.system.log.repository.logRepository;
import com.bio.system.result.entity.result;
import com.bio.system.test.entity.tests;
import com.bio.system.user.Entity.user;
import org.springframework.stereotype.Service;

@Service
public class logService {

    private final logRepository logRepository;

    private final findId findId;

    public logService(logRepository logRepository,findId findId){
        this.logRepository = logRepository;
        this.findId = findId;
    }

    public void postLog(logReqestDto logReqestDto) {
        tests test = findId.findTestId(logReqestDto.getTestId());
        result result = null;
        if (logReqestDto.getResultId() != null) {
            result = findId.findResultId(logReqestDto.getResultId());
        }
        user user = findId.findUserId(logReqestDto.getUserId());
        log log = new log(logReqestDto.getAction(),logReqestDto.getLogTime(),test,result,user);
        logRepository.save(log);
    }


}
