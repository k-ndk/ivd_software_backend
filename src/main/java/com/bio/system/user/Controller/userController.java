package com.bio.system.user.Controller;
import com.bio.system.user.service.userService;
import com.bio.system.user.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class userController {

    private final userService userService;

    public userController(userService userService) {
        this.userService = userService;
    }


    @PostMapping("/user/signup")
    public ResponseEntity<String> post(@RequestBody signupDto reqestDto) {
        userService.signup(reqestDto);
        return new ResponseEntity<String>("success", HttpStatus.valueOf(201));
    }

    @PostMapping("/user/login")
    public ResponseEntity<loginResponseDto> post(@RequestBody loginReqestDto loginReqestDto){
        int userId = userService.login(loginReqestDto);
        loginResponseDto response = new loginResponseDto(userId, "로그인 성공");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



}
