package com.bio.system.common;

import com.bio.system.result.entity.result;
import com.bio.system.result.repository.resultRepository;
import com.bio.system.test.entity.tests;
import com.bio.system.test.repository.testRepository;
import com.bio.system.user.Entity.user;
import com.bio.system.user.Repository.userRepository;
import org.springframework.stereotype.Component;

@Component
public class findId {

    private final resultRepository resultRepository;

    private final userRepository userRepository;

    private final testRepository testRepository;

    public findId(resultRepository resultRepository,
                  userRepository userRepository, testRepository testRepository){

        this.resultRepository  = resultRepository;
        this.userRepository = userRepository;
        this.testRepository = testRepository;
    }

    public user findUserId(int userId){
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 userId입니다: " + userId));
    }

    public result findResultId(Long resultId){
        return resultRepository.findById(resultId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 resultId입니다: " + resultId));
    }

    public tests findTestId(Long testId){
        return testRepository.findById(testId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 testId입니다: " + testId));
    }
}
