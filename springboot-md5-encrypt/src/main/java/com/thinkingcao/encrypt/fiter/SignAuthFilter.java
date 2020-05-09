package com.thinkingcao.encrypt.fiter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @desc:  基于MD5请求报文签名验签
 * @author: cao_wencao
 * @date: 2020-05-09 17:53
 */
@Slf4j
@WebFilter(filterName= "signAuthFilter" ,urlPatterns = "/*")
public class SignAuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
         log.info("--------  过滤器SignAuthFilter Init -------- ");
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //放行
        filterChain.doFilter(servletRequest,servletResponse);
    }


    @Override
    public void destroy() {
        log.info("-------- 过滤器SignAuthFilter Destroy-------- ");
    }
}
