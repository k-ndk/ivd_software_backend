package com.bio.system.test.controller;

import com.bio.system.test.dto.patchTestDto;
import com.bio.system.test.dto.startTestReqestDto;
import com.bio.system.test.service.testService;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    private final testService testService;

    public testController(testService testService){
        this.testService = testService;
    }

    @PostMapping("/start")
    public ResponseEntity<String>post(@RequestBody startTestReqestDto startTestReqestDto){
        testService.testStart(startTestReqestDto);
        return new ResponseEntity<String>("success", HttpStatus.valueOf(201));
    }

    @PatchMapping("/test")
    public ResponseEntity<String> patch(@RequestBody patchTestDto patchTestDto){
        testService.patchTest(patchTestDto);
        return new ResponseEntity<>("검증 완료", HttpStatus.OK);
    }

}
