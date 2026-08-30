package com.bio.system.log.controller;

import com.bio.system.log.dto.*;
import com.bio.system.log.service.logService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class logController {

    private final logService logService;

    public logController(logService logService){
        this.logService = logService;
    }

    @PostMapping("/log")
    public ResponseEntity<String> post(@RequestBody logReqestDto logReqestDto){
        logService.postLog(logReqestDto);
        return new ResponseEntity<String>("success", HttpStatus.valueOf(201));
    }


}
