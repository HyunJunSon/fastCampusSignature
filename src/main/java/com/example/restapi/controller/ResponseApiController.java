package com.example.restapi.controller;

import com.example.restapi.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class ResponseApiController {
    @GetMapping()   // http://localhost8080/api/v1 으로 매핑// 됨
    public User user(){
        var user = new User();
//        user.setUserName("홍길동");
//        user.setUserAge(22);
//        user.setEmail("hong@gmail.com");
        return user;
    }

    @GetMapping("/v2")   // http://localhost8080/api/v1 으로 매핑// 됨
    public String user2(){
        var user = new User();
//        user.setUserName("홍길동");
//        user.setUserAge(22);
//        user.setEmail("hong@gmail.com");

        log.info("user: {}", user);

        return user.toString();
    }

    @GetMapping("/v3")   // http://localhost8080/api/v1 으로 매핑// 됨
    public ResponseEntity<User> user3(){
        var user = new User();
//        user.setUserName("홍길동");
//        user.setUserAge(22);
//        user.setEmail("hong@gmail.com");

        log.info("user: {}", user);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .header("Test","hi","hi2","hi3")
                .body(user);


    }
}
