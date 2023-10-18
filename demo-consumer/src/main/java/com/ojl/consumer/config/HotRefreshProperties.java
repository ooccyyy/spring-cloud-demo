package com.ojl.consumer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author oujunlong
 * @version 1.0
 * @description TODO
 * @date 2023/10/18 21:32
 */
@ConfigurationProperties(prefix = "demo")
@Component
@Data
public class HotRefreshProperties {
    private String name;
}
