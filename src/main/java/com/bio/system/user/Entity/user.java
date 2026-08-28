package com.bio.system.user.Entity;


import com.bio.system.user.dto.signupDto;
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
    String userIds;
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
}
