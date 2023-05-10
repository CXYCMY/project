package com.cxy.eduservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Title: EduApplication
 * @Package com.cxy.eduservice
 * @Author: CXY
 * @Copyright CXY
 * @CreateTime: 2023/3/12 17:01
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.cxy"})
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class,args);
    }
}
