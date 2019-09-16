package com.example.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.example.springboot")//scanBasePackages ="com.example.springboot"
@MapperScan("com.example.springboot.mappers")
//@EnableTransactionManagement
public class demoApplication {

    public static void main(String[] args) {
        SpringApplication.run(demoApplication.class, args);
    }

}
