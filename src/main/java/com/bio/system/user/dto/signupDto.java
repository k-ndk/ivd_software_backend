package com.bio.system.user.dto;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class signupDto {

    String username;
    String userIds;
    String userPw;
    Timestamp time;

}
