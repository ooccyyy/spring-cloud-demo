package com.ojl.gateway;

import com.ojl.gateway.config.AuthProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.AntPathMatcher;

/**
 * @author oujunlong
 * @version 1.0
 * @description TODO
 * @date 2023/10/18 14:47
 */
@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,args);
    }

    @Bean
    public AntPathMatcher AntPathMatcher(){
        return new AntPathMatcher();
    }
}
