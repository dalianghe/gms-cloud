package com.github.dalianghe.security.admin.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

@Configuration
@AutoConfigureAfter(MybatisConfig.class)
public class MapperConfig implements EnvironmentAware {

    private RelaxedPropertyResolver propertyResolver;

    private String basePackage;

    @Override
    public void setEnvironment(Environment environment) {
        this.propertyResolver = new RelaxedPropertyResolver(environment, null);
        this.basePackage = propertyResolver.getProperty("mybatis.basepackage");
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(Environment environment){

        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage(basePackage);
        return mapperScannerConfigurer;
    }
}
