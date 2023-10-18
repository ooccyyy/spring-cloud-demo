package com.ojl.gateway.filters;

import cn.hutool.core.collection.CollUtil;
import com.ojl.gateway.config.AuthProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author oujunlong
 * @version 1.0
 * @description TODO
 * @date 2023/10/18 20:13
 */
@Component
@RequiredArgsConstructor
public class LoginGlobalFilter implements GlobalFilter {

    private final AntPathMatcher antPathMatcher;
    private final AuthProperties authProperties;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //1.获取请求
        ServerHttpRequest request = exchange.getRequest();
        //2.是否需要获取token
        if(isExcludePath(request)){
            return chain.filter(exchange);
        }
        String token = null;
        List<String> heads = request.getHeaders().get("authorization");
        if(CollUtil.isNotEmpty(heads)){
            token = heads.get(0);
        }
        //3.TODO 解析token

        //4.传到下游微服务
        exchange.mutate()
                .request(builder -> builder.header("user-info","1"))
                .build();
        //5.放行
        return chain.filter(exchange);
    }

    private boolean isExcludePath(ServerHttpRequest request) {
        String path = request.getPath().toString();
        List<String> excludePaths = authProperties.getExcludePaths();
        for (String excludePath : excludePaths) {
            if(antPathMatcher.match(excludePath,path)){
                return true;
            }
        }
        return false;
    }
}
