package com.bio.system.result.service;

import com.bio.system.common.findId;
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

    private final findId findId;

    public resultService(resultRepository resultRepository, findId findId){
        this.resultRepository = resultRepository;
        this.findId = findId;
    }


    public void result(resultDto resultDto){
        tests test = findId.findTestId(resultDto.getTestId());
        result result = new result(resultDto.getResultTime(), resultDto.getScore(), test);
        resultRepository.save(result);
    }





}
