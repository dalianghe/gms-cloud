package com.github.dalianghe.security.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AdminBootstrap {

    public static void main(String[] args){
        SpringApplication.run(AdminBootstrap.class ,args);
    }

}
