package com.ojl.common.interceptor;

import cn.hutool.core.util.StrUtil;
import com.ojl.common.utils.UserContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author oujunlong
 * @version 1.0
 * @description TODO
 * @date 2023/10/18 20:03
 */
@Slf4j
public class UserInfoInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //log.debug("执行到了用户信息拦截器。。。。。。。");
        String userId = request.getHeader("user-info");
        if(StrUtil.isNotBlank(userId)){
            UserContext.setUser(Long.valueOf(userId));
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserContext.removeUser();
    }
}
