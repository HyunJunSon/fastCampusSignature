package com.example.exceptionstudy.exception;

import com.example.exceptionstudy.controller.RestApiBcontroller;
import com.example.exceptionstudy.controller.RestApiController;
import com.example.exceptionstudy.model.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

//@RestControllerAdvice(basePackages = "com.example.exceptionstudy.controller")
@RestControllerAdvice(basePackageClasses = {RestApiController.class, RestApiBcontroller.class})
@Slf4j
@Order(1)
public class RestApiExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity exception(Exception e) {
        log.error("RestApiExceptionHandler", e);


        return ResponseEntity.status(200).build();
    }

    @ExceptionHandler(value = {IndexOutOfBoundsException.class})
    public ResponseEntity outofbound(IndexOutOfBoundsException e) {
        log.error("IndexoutOfExceptionHandler", e);

        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(value = {NoSuchElementException.class})
    public ResponseEntity<Api> NoSuchElement(NoSuchElementException e) {

        log.error("{}", e);

        var response = Api.builder()
                .resultCode(HttpStatus.NOT_FOUND.value()+"")
                .resultMessage(HttpStatus.NOT_FOUND.getReasonPhrase())
                .build();

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);

    }

}
