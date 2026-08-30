package com.bio.system.test.service;

import com.bio.system.common.findId;
import com.bio.system.log.dto.logReqestDto;
import com.bio.system.log.service.logService;
import com.bio.system.test.dto.patchTestDto;
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


    public void patchTest(patchTestDto patchTestDto) {
        user user = findId.findUserId(patchTestDto.getUserId());

        tests test = findId.findTestId(patchTestDto.getTestId());

        if (test.getUserId().getUserId() != user.getUserId()) {
            throw new RuntimeException("해당 사용자의 테스트가 아닙니다.");
        }


        // 2. Hash 검증
        if (!test.getTestRowHash().equals(patchTestDto.getTestsaveHash())) {
            throw new RuntimeException("Hash가 일치하지 않습니다.");
        }

        // 3. 검증 성공 후 저장
        test.updateTestSaveHash(patchTestDto.getTestsaveHash());

        // DB 저장
        testRepository.save(test);


    }
}