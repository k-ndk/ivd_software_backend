package com.bio.system.log.entity;

import com.bio.system.log.dto.logshowReqestDto;
import com.bio.system.result.entity.result;
import com.bio.system.test.entity.tests;
import com.bio.system.user.Entity.user;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long logId;
    LocalDateTime logTime;
    String action;
    @ManyToOne
    @JoinColumn(name = "test_id_test_id")
    tests testId;

    @ManyToOne
    @JoinColumn(name = "result_id", nullable = true)
    result resultId;

    @ManyToOne
    @JoinColumn(name = "user_id_user_id")
    user userId;

    public log(String action, LocalDateTime logTime, tests testId, result resultId, user userId){
        this.action = action;
        this.logTime = logTime;
        this.testId = testId;
        this.resultId = resultId;
        this.userId = userId;

    }

    public log(){}

}
