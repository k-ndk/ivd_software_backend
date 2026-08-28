package com.bio.system.user.service;
import com.bio.system.user.Entity.user;
import com.bio.system.user.Repository.userRepository;
import com.bio.system.user.dto.signupDto;
import org.springframework.stereotype.Service;

@Service
public class userService {

    private final userRepository userRepository;

    public userService(userRepository userRepository){
        this.userRepository = userRepository;
    }

    public void signup(signupDto reqestDto){
        user user = new user(reqestDto);
        userRepository.save(user);
    }
}
