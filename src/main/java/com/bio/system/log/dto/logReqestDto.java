package com.bio.system.log.dto;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class logReqestDto {
    Timestamp logTime;
    String action;
    Long testId;
    Long resultId;
    int userId;
}
