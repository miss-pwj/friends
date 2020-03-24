package com.lcl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.lcl.dao")
@SpringBootApplication
public class FriendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FriendApplication.class, args);
    }

}
