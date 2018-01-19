package com.github.dalianghe.security.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableEurekaClient
//@EnableFeignClients
//@EnableZuulProxy
public class GatwayBootstrap {

    public static void main(String[] args){
        SpringApplication.run(GatwayBootstrap.class , args);
    }

}
