package com.thinkingcao.encrypt.fiter;


import com.alibaba.fastjson.JSON;
import com.thinkingcao.encrypt.common.HeadRequest;
import com.thinkingcao.encrypt.constant.Constants;
import com.thinkingcao.encrypt.encrypt.MD5Util;
import com.thinkingcao.encrypt.result.ApiResult;
import com.thinkingcao.encrypt.utils.ServletUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
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
        String appId = servletRequest.getParameter("appId");
        if (StringUtils.isBlank(appId)){
            log.debug("appId不能为空");
            ServletUtils.renderResultString(servletResponse,JSON.toJSONString(ApiResult.error("")));
        }
        String timestamp = servletRequest.getParameter("timestamp");
        if (StringUtils.isBlank(timestamp)){
            log.debug("timestamp不能为空");
            ServletUtils.renderResultString(servletResponse,JSON.toJSONString(ApiResult.error("")));
        }
        String sign = servletRequest.getParameter("sign");
        if (StringUtils.isBlank(sign)){
            log.debug("sign不能为空");
            ServletUtils.renderResultString(servletResponse,JSON.toJSONString(ApiResult.error("")));
        }
        String nonce = servletRequest.getParameter("nonce");
        if (StringUtils.isBlank(nonce)){
            log.debug("nonce不能为空");
            ServletUtils.renderResultString(servletResponse,JSON.toJSONString(ApiResult.error("")));
        }
        String signEcrypt = MD5Util.md5(appId  + Constants.APP_SECRET + timestamp + nonce + new HeadRequest().getVersion());
        if (sign.equalsIgnoreCase(signEcrypt)){
            filterChain.doFilter(servletRequest, servletResponse);
        }
        ServletUtils.renderResultString(servletResponse,JSON.toJSONString(ApiResult.error("签名校验失败")));
    }


    @Override
    public void destroy() {
        log.info("-------- 过滤器SignAuthFilter Destroy-------- ");
    }
}
