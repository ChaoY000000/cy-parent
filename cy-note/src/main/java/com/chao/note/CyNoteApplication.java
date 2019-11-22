package com.chao.note;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * Created by 15313 on 2019/11/12.
 */
@SpringBootApplication
@RestController
public class CyNoteApplication {
    public static void main(String[] args) {
        SpringApplication.run(CyNoteApplication.class, args);
    }


    @RequestMapping("/hello")
    public String hello(String decryptedData) {
        String encodedText = "";
        String decode ="";
        try {
            final BASE64Encoder encoder = new BASE64Encoder();
            byte[] textByte = decryptedData.getBytes("UTF-8");
            //编码
            encodedText = encoder.encode(textByte);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return encodedText;
    }


}
