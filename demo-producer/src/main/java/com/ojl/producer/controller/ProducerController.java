package com.ojl.producer.controller;

import com.ojl.common.utils.UserContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author oujunlong
 * @version 1.0
 * @description TODO
 * @date 2023/10/18 15:26
 */
@RestController
@RequestMapping("producer")
public class ProducerController {
    @GetMapping("hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("userId")
    public String getUserId(){
        Long user = UserContext.getUser();
        return user.toString();
    }
}
