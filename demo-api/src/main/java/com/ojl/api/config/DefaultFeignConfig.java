package com.ojl.api.config;

import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author oujunlong
 * @version 1.0
 * @description TODO
 * @date 2023/10/18 15:58
 */
@Component
public class DefaultFeignConfig {
    @Bean
    public Logger.Level level(){
        return Logger.Level.BASIC;
    }
    @Bean
    public RequestInterceptor userInfoRequestInterceptor(){
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                Long userId = 1L;
                requestTemplate.header("user-info",userId.toString());
            }
        };
    }
}
