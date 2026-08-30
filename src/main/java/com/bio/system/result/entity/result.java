package com.bio.system.result.entity;

import com.bio.system.result.dto.resultDto;
import com.bio.system.test.entity.tests;
import com.bio.system.user.Entity.user;
import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
public class result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id")
    Long resultId;
    LocalTime resultTime;
    Double score;

    @OneToOne
    @JoinColumn(name = "test_id")
    tests testId;

    public result(LocalTime resultTime, Double score, tests testId){
        this.resultTime = resultTime;
        this.score = score;
        this.testId = testId;
    }
    public result(){}
}