package com.chao.note;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 15313 on 2019/11/12.
 */
@SpringBootApplication
@RestController
public class CyNoteApplication {
    public static void main(String[] args) {
        SpringApplication.run(CyNoteApplication.class , args);
    }


    @RequestMapping("/hello")
    public String hello (String json){
        System.out.println("=========="+json);
        return json;
    }


}
