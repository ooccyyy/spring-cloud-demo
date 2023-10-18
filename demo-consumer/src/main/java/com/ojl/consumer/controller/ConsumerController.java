package com.ojl.consumer.controller;

import com.ojl.api.client.ProducerClient;
import com.ojl.common.utils.UserContext;
import com.ojl.consumer.config.HotRefreshProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author oujunlong
 * @version 1.0
 * @description TODO
 * @date 2023/10/18 15:38
 */
@RestController
@RequestMapping("consumer")
@RequiredArgsConstructor
@Slf4j
public class ConsumerController {
    private final ProducerClient producerClient;
    private final HotRefreshProperties hotRefreshProperties;

    @GetMapping("hello")
    public String hello(){
        String hello = producerClient.hello();
        return hello;
    }

    @GetMapping("userId")
    public String userId(){
        String userId =  producerClient.getUserId();
        return userId;
    }

    @GetMapping("name")
    public String name(){
        String name = hotRefreshProperties.getName();
        log.debug(name);
        return name;
    }
}
