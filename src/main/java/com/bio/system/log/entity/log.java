package com.bio.system.log.entity;

import com.bio.system.log.dto.logshowReqestDto;
import com.bio.system.result.entity.result;
import com.bio.system.test.entity.tests;
import com.bio.system.user.Entity.user;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long logId;
    Timestamp logTime;
    String action;
    @OneToOne
    tests testId;

    @OneToOne
    result resultId;

    @OneToOne
    user userId;

    public log(String action, Timestamp logTime, tests testId, result resultId, user userId){
        this.action = action;
        this.logTime = logTime;
        this.testId = testId;
        this.resultId = resultId;
        this.userId = userId;

    }

    public log(){}

}
