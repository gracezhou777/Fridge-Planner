package com.fridgy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fridgy.mapper")
public class FridgyApplication {
    public static void main(String[] args) {
        SpringApplication.run(FridgyApplication.class, args);
    }
}
