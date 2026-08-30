package com.bio.system.test.dto;

import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class startTestReqestDto {
    int userId;
    LocalDateTime testTime;
    String testName;
    String testRowHash; //  테스트전 보내는 해쉬
    Double maxScore;
    Double minScore;
}
