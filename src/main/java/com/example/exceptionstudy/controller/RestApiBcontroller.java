package com.example.exceptionstudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.NumberFormat;

@RestController
@RequestMapping("/api/b")
@Slf4j
public class RestApiBcontroller {
    @GetMapping("/hello")
    public void hello() {
        throw new NumberFormatException("number format exception");
    }

//    @ExceptionHandler(value = {NumberFormatException.class})
//    public ResponseEntity numberformatException(NumberFormatException e) {
//        log.error("NumberformatException {}", e);
//
//        return ResponseEntity.ok().build();
//    }
}


