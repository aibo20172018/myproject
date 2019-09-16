package com.zn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

//总结：1.工程命名应该规范 如 springboot-dao，springboot-web    2.启动类扫描必须加上注解定位到包，包名前缀应该一致，因为会扫描当前包和子包
@SpringBootApplication(scanBasePackages = "com.zn")
@EnableScheduling
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
