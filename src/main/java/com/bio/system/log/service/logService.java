package com.bio.system.log.service;

import com.bio.system.log.dto.logReqestDto;
import com.bio.system.log.dto.logshowReqestDto;
import com.bio.system.log.entity.log;
import com.bio.system.log.repository.logRepository;
import com.bio.system.result.entity.result;
import com.bio.system.result.repository.resultRepository;
import com.bio.system.result.service.resultService;
import com.bio.system.test.entity.tests;
import com.bio.system.user.Entity.user;
import com.bio.system.user.Repository.userRepository;
import org.springframework.stereotype.Service;

@Service
public class logService {

    private final logRepository logRepository;

    private final resultRepository resultRepository;

    private final userRepository userRepository;

    private final resultService resultService;

    public logService(logRepository logRepository, resultRepository resultRepository,
                      userRepository userRepository, resultService resultService){
        this.logRepository = logRepository;
        this.resultRepository  = resultRepository;
        this.userRepository = userRepository;
        this.resultService = resultService;
    }

    public void postLog(logReqestDto logReqestDto) {
        tests test = resultService.findTestId(logReqestDto.getTestId());
        result result = findResultId(logReqestDto.getResultId());
        user user = findUserId(logReqestDto.getUserId());
        log log = new log(logReqestDto.getAction(),logReqestDto.getLogTime(),test,result,user);

    }

    public user findUserId(int userId){
        user user = userRepository.findById(userId).get();
        return user;
    }

    public result findResultId(Long resultId){
        result result = resultRepository.findById(resultId).get();
        return  result;
    }


}
