package com.starrycode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.starrycode.mapper")
public class StarryCodeBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarryCodeBackendApplication.class, args);
    }

}
