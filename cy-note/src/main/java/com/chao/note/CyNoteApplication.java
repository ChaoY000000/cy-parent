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


    @RequestMapping("/helloERROR")
    public String helloERROR(int i,String hello) {

        logger.info("helloERROR     info日志记录测试--------------------------");
        logger.debug("helloERROR    debug日志记录测试--------------------------");
        try {
            i = 100 / i;
            hello = hello.toString();
        } catch (ArithmeticException e){
            logger.error("helloERROR    0 不能当分母--------------------------");
            e.printStackTrace();
        }catch (NullPointerException e) {
            logger.error("helloERROR    空指针异常--------------------------");
        }catch (Exception e){
            logger.error("helloERROR    异常--------------------------");
        }
        String value = Utils.getValue(i + "  " + hello);
        System.out.println("helloERROR : " + value);
        logger.info("helloERROR value : " + value);
        return value;
    }

}
