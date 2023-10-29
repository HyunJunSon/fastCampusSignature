package com.example.restapi.controller;

import com.example.restapi.model.BookQueryParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j
public class RestApiController {

    @GetMapping(path= "/hello/{message}")
    public int hello(@PathVariable(name = "message") String msg){

        return Integer.parseInt(msg);
    }
    @GetMapping(path= "/hello2")
    public String hello2(){
        var html = "<html><body><h1>hello Spring</h1></body></html>";
        return html;

    }
    @GetMapping(path = "/echo/{message}/age/{age}/is-man/{isMan}")
    public String echo(
            @PathVariable(name = "message") String msg,
            @PathVariable int age,
            @PathVariable boolean isMan
            ){
        System.out.println("msg = " + msg);
        System.out.println("age = " + age);
        System.out.println("isMan = " + isMan);

        return msg.toUpperCase();
    }


    @GetMapping("/book")
    public void queryParam(
            @RequestParam String category,
            @RequestParam String issuedYear,
            @RequestParam(name = "issued-month") String issuedMonth,
            @RequestParam String issuedDay
    ){
        System.out.println("issuedYear = " + issuedYear);
        System.out.println("category = " + category);
        System.out.println("issuedMonth = " + issuedMonth);
        System.out.println("issued_day = " + issuedDay);
    }

    @GetMapping("/book2")
    public void queryParamDTO(
            BookQueryParam bookQueryParam
    ) {
        System.out.println("bookQueryParam = " + bookQueryParam);
    }

    //To do --> parameter 2개를 int 형태로 받아서 두수의 곱셉, 덧셈을 하는 코드 작성

    @GetMapping("/calculator/sum/")
    public int sumParam(
            @RequestParam int element1,
            @RequestParam int element2
    ){
        return element1 + element2;
    }

    @GetMapping("/calculator/multi/")
    public int multiParam(
            @RequestParam int element1,
            @RequestParam int element2
    ){
        return element1 * element2;
    }

 @GetMapping("/calculator/bool/")
    public boolean multiParam(
            @RequestParam boolean element1,
            @RequestParam boolean element2
    ){
        return element1 || element2;
    }


    @DeleteMapping(path = {
            "/user/{userName}/delete",
             "/user/{userName}/del"
    })

    public void delete(
            @PathVariable String userName)
    {
        log.info(userName);
    }

}
