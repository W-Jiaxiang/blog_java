package com.emptyx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.emptyx.dao")
@SpringBootApplication
public class Boot01StartApplication {

    public static void main(String[] args) {
        SpringApplication.run(Boot01StartApplication.class, args);
    }

}
