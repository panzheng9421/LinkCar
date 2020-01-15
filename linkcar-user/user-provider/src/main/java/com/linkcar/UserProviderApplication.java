package com.linkcar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author panzheng
 * @description
 * @date 2019/12/26 15:37
 */
@SpringBootApplication
//@EnableDiscoveryClient
//@EnableFeignClients(basePackages = {ConstantsEJS.FEIGN_CLIENTS_ITEM})
//@EnableFeignClients
public class UserProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserProviderApplication.class, args);
    }

}
