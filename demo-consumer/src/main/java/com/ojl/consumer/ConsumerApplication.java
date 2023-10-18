package com.ojl.consumer;

import com.ojl.api.config.DefaultFeignConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author oujunlong
 * @version 1.0
 * @description TODO
 * @date 2023/10/18 15:52
 */
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.ojl.api"},defaultConfiguration = DefaultFeignConfig.class)
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class,args);
    }
}
