package com.github.dalianghe.security.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient  // 注册eureka客户端
@EnableFeignClients  // 开启Spring Cloud Feign的支持
@EnableZuulProxy  // 开启路由
public class GatwayBootstrap {

    public static void main(String[] args){
        SpringApplication.run(GatwayBootstrap.class , args);
    }

}
