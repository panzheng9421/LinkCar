package com.linkcar.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author panzheng
 * @description 注册中心
 * @date 2019/12/26 11:03
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }

}
