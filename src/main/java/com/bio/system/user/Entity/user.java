package com.bio.system.user.Entity;


import com.bio.system.user.dto.*;
import jakarta.persistence.*;

import java.time.LocalTime;

import static java.time.LocalTime.now;

@Entity
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    int userId;
    String userName;
    String userIds; //유저 아이디
    String userPw;
    LocalTime time;

    public user(signupDto signupDto){
        this.userName = signupDto.getUsername();
        this.userIds = signupDto.getUserIds();
        this.userPw = signupDto.getUserPw();
        this.time = now();
        }

    public user() {

    }

    public int getUserId() {
        return userId;

    }

    public String getUserPw() {
        return userPw;
    }
}
