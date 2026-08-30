package com.bio.system.user.service;
import com.bio.system.user.Entity.user;
import com.bio.system.user.Repository.userRepository;
import com.bio.system.user.dto.loginReqestDto;
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


    public int login(loginReqestDto loginReqestDto) {
        user user = userRepository.findByUserIds(loginReqestDto.getUserIds())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 아이디입니다"));

        if (!user.getUserPw().equals(loginReqestDto.getUserPw())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다");
        }

        return user.getUserId();
    }
}
