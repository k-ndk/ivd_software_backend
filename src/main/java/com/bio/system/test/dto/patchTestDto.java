package com.bio.system.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class patchTestDto {
    Long testId;
    String testsaveHash;
    int userId;
}