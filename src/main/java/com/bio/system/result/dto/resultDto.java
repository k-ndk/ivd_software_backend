package com.bio.system.result.dto;

import com.bio.system.test.entity.tests;
import lombok.Getter;

import java.time.LocalTime;

@Getter
public class resultDto {
    LocalTime resultTime;
    Double score;
    Long testId;
}
