package com.example.restapi.controller;


import com.example.restapi.model.BookRequest;
import com.example.restapi.model.User;
import com.example.restapi.model.UserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping("/post")
    public BookRequest post(
        @RequestBody BookRequest bookRequest
    ){
        System.out.println(bookRequest);

        return bookRequest;
    }
     @PostMapping("/post2")
    public void post2(
        @RequestBody BookRequest bookRequest
    ){
        System.out.println(bookRequest);
    }

    
    @PostMapping("/userData")
    public void postUserData(
            @RequestBody UserRequest user
    ){
        System.out.println("user = " + user);
        
    }


    @PostMapping("/user")
    public void User(
            @RequestBody
            User user
    ){
        System.out.println("user = " + user);
    }

}
