package com.bio.system.test.entity;

import com.bio.system.result.entity.result;
import com.bio.system.test.dto.startTestReqestDto;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
public class tests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long testId;
    LocalDateTime testTime;
    String testName;
    Double maxScore;
    Double minScore;
    String testRowHash; //  테스트전 보내는 해쉬
    String testsaveHash; // 테스트후 저장되는 파일 해쉬

    public tests(startTestReqestDto startTestReqestDto){
        this.testTime = startTestReqestDto.getTestTime();
        this.maxScore = startTestReqestDto.getMaxScore();
        this.minScore = startTestReqestDto.getMinScore();
        this.testRowHash = startTestReqestDto.getTestRowHash();
        this.testName = startTestReqestDto.getTestName();

    }


    public tests(){

    }

}
