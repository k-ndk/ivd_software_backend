package com.bio.system.test.service;

import com.bio.system.test.dto.startTestReqestDto;
import com.bio.system.test.entity.tests;
import com.bio.system.test.repository.testRepository;
import org.springframework.stereotype.Service;

@Service
public class testService {
    private final testRepository testRepository;

    public testService(testRepository testRepository){
        this.testRepository = testRepository;
    }

    public void testStart(startTestReqestDto startTestReqestDto){
        tests tests = new tests(startTestReqestDto);
        testRepository.save(tests);
    }

}
