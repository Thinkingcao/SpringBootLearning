package com.thinkingcao.encrypt.fiter;


import com.thinkingcao.encrypt.common.HeadRequest;
import com.thinkingcao.encrypt.constant.Constants;
import com.thinkingcao.encrypt.encrypt.MD5Util;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @desc: 基于MD5请求报文签名验签
 * @author: cao_wencao
 * @date: 2020-05-09 17:53
 */
@Slf4j
@WebFilter(filterName = "signAuthFilter", urlPatterns = "/*")
public class SignAuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("--------  过滤器SignAuthFilter Init -------- ");
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String appId = request.getHeader("appId");
        String timestamp = request.getHeader("timestamp");
        String sign = request.getHeader("sign");
        String nonce = request.getHeader("nonce");
        String signEcrypt = MD5Util.md5(appId  + Constants.APP_SECRET + timestamp + nonce + new HeadRequest().getVersion());
        if (sign.equalsIgnoreCase(signEcrypt)){
            log.debug("签名校验通过，放行...........");
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }


    @Override
    public void destroy() {
        log.info("-------- 过滤器SignAuthFilter Destroy-------- ");
    }
}
