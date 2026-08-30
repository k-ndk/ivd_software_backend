package com.bio.system.result.service;

import com.bio.system.result.dto.resultDto;
import com.bio.system.result.entity.result;
import com.bio.system.result.repository.resultRepository;
import com.bio.system.test.entity.tests;
import com.bio.system.test.repository.testRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class resultService {

    private final resultRepository resultRepository;

    private final testRepository testRepository;

    public resultService(resultRepository resultRepository, testRepository testRepository){
        this.resultRepository = resultRepository;
        this.testRepository = testRepository;
    }

    public tests findTestId(Long testId){
        tests test = testRepository.findById(testId).get();
        return test;
    }

    public void result(resultDto resultDto){
        tests test = findTestId(resultDto.getTestId());
        result result = new result(resultDto.getResultTime(), resultDto.getScore(), test);
        resultRepository.save(result);
    }





}
