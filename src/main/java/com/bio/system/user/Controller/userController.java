package com.bio.system.user.Controller;
import com.bio.system.user.service.userService;
import com.bio.system.user.dto.signupDto;
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
        return new ResponseEntity<String>("success",HttpStatus.OK);
    }

}
