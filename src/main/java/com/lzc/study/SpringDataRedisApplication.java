package com.lzc.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lzc.study.mapper")
public class SpringDataRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataRedisApplication.class, args);
    }

}
