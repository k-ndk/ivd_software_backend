package com.bio.system.result.controller;

import com.bio.system.result.dto.resultDto;
import com.bio.system.result.service.resultService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class resultController {

    private final resultService resultService;

    public resultController(resultService resultService){
        this.resultService = resultService;
    }

    @PostMapping("/result")
    public ResponseEntity<String> post(@RequestBody resultDto resultDto){
        resultService.result(resultDto);
        return new ResponseEntity<>("succes", HttpStatus.valueOf(201));
    }


}
