package com.bio.system.test.entity;
import com.bio.system.user.Entity.user;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class tests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    Long testId;
    LocalDateTime testTime;
    String testName;
    Double maxScore;
    Double minScore;
    String testRowHash; //  테스트전 보내는 해쉬
    String testsaveHash; // 테스트후 저장되는 파일 해쉬


    @ManyToOne
    @JoinColumn(name = "user_id")
    user userId;

    public tests(LocalDateTime testTime, String testName, Double maxScore, Double minScore, String testRowHash, user userId){
        this.testTime = testTime;
        this.maxScore = maxScore;
        this.minScore = minScore;
        this.testRowHash = testRowHash;
        this.testName = testName;
        this.userId = userId;

    }

    public Long getTestId() {
        return testId;
    }

    public tests(){

    }

}
