package com.linkcar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author panzheng
 * @description
 * @date 2020/1/7 11:21
 */
@SpringBootApplication
@EnableEurekaClient
@ServletComponentScan
@EnableFeignClients
public class UserWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserWebApplication.class, args);
    }
}
