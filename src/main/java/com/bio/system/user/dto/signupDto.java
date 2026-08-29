package com.bio.system.user.dto;

import lombok.Getter;

import java.time.LocalTime;

@Getter
public class signupDto {

    String username;
    String userIds;
    String userPw;
    LocalTime time;

}
