package com.thinkingcao.springboot.aop.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @desc: 获取当前请求的HttpServletRequest对象
 * @author: cao_wencao
 * @date: 2019-12-17 23:16
 */
public class HttpServletRequestUtil {
    
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        return request;
    }
}
