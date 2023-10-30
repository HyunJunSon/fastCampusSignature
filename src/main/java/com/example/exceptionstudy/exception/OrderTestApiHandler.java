package com.example.exceptionstudy.exception;

import com.example.exceptionstudy.controller.RestApiBcontroller;
import com.example.exceptionstudy.controller.RestApiController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice(basePackageClasses = {RestApiController.class, RestApiBcontroller.class})
@Slf4j
@Order(-1)
public class OrderTestApiHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity exception(Exception e) {
        log.error("OrderApiExceptionHandler", e);


        return ResponseEntity.status(200).build();
    }



}


