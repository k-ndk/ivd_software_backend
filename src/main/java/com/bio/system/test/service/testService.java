package com.bio.system.test.service;

import com.bio.system.common.findId;
import com.bio.system.log.dto.logReqestDto;
import com.bio.system.log.service.logService;
import com.bio.system.test.dto.startTestReqestDto;
import com.bio.system.test.entity.tests;
import com.bio.system.test.repository.testRepository;
import com.bio.system.user.Entity.user;
import org.springframework.stereotype.Service;

@Service
public class testService {
    private final testRepository testRepository;
    private final logService logService;
    private final findId findId;

    public testService(testRepository testRepository, logService logService, findId findId){
        this.testRepository = testRepository;
        this.logService = logService;
        this.findId = findId;
    }

    public void testStart(startTestReqestDto startTestReqestDto){
        user user = findId.findUserId(startTestReqestDto.getUserId());

        tests tests = new tests(
                startTestReqestDto.getTestTime(),
                startTestReqestDto.getTestName(),
                startTestReqestDto.getMaxScore(),
                startTestReqestDto.getMinScore(),
                startTestReqestDto.getTestRowHash(),
                user
        );
        testRepository.save(tests);

        logReqestDto logDto = new logReqestDto(
                startTestReqestDto.getTestTime(),
                "검사 시작",
                tests.getTestId(),
                null,
                startTestReqestDto.getUserId()
        );
        logService.postLog(logDto);
    }
}