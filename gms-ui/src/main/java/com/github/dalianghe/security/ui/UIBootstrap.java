package com.github.dalianghe.security.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UIBootstrap {

    public static void main(String[] args){
        SpringApplication.run(UIBootstrap.class , args);
    }

}
