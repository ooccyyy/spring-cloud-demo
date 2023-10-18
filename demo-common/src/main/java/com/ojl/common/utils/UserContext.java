package com.ojl.common.utils;

/**
 * @author oujunlong
 * @version 1.0
 * @description TODO
 * @date 2023/10/18 20:04
 */
public class UserContext {
    private static final ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    /**
     * 保存当前登录用户信息到ThreadLocal
     * @param userId 用户id
     */
    public static void setUser(Long userId) {
        threadLocal.set(userId);
    }

    /**
     * 获取当前登录用户信息
     * @return 用户id
     */
    public static Long getUser() {
        return threadLocal.get();
    }

    /**
     * 移除当前登录用户信息
     */
    public static void removeUser(){
        threadLocal.remove();
    }
}
