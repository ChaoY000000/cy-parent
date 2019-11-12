package com.chao.practice.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 15313 on 2019/11/12.
 */

@RestController
@RequestMapping("/pracetice")
public class HelloController {

    @RequestMapping("/hello")
    public String hello(String params){
        System.out.println("=========="+params);
        return params;
    }
}
