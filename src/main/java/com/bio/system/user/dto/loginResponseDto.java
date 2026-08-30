package com.bio.system.user.dto;

import lombok.Getter;

@Getter
public class loginResponseDto {
    int userId;
    String message;

    public loginResponseDto(int userId, String message) {
        this.userId = userId;
        this.message = message;
    }
}
