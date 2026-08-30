package com.bio.system.log.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;


@Getter
@AllArgsConstructor
public class logReqestDto {
    LocalDateTime logTime;
    String action;
    Long testId;
    Long resultId;
    int userId;

}
