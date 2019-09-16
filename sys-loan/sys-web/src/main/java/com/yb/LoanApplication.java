package com.yb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.yb")
public class LoanApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoanApplication.class,args);
    }

}
