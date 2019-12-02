package com.chao.note;

import com.chao.practice.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final static Logger logger = LoggerFactory.getLogger(CyNoteApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(CyNoteApplication.class, args);
    }


    @RequestMapping("/hello")
    public String hello(String json) {

        logger.info("info日志记录测试--------------------------");
        logger.error("error日志记录测试--------------------------");
        logger.debug("debug日志记录测试--------------------------");

        String value = Utils.getValue(json);
        System.out.println(value);
        logger.info("value : " + value);
        return value;
    }


}
