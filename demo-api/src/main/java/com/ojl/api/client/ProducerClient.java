package com.ojl.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author oujunlong
 * @version 1.0
 * @description TODO
 * @date 2023/10/18 15:43
 */
@FeignClient("producerr-service")
public interface ProducerClient {
    @GetMapping("producer/hello")
    String hello();

    @GetMapping("producer/userId")
    String getUserId();

}
