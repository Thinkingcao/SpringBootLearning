package com.thinkingcao.encrypt.Inter;

import com.alibaba.fastjson.JSON;
import com.thinkingcao.encrypt.common.HeadRequest;
import com.thinkingcao.encrypt.constant.Constants;
import com.thinkingcao.encrypt.encrypt.MD5Util;
import com.thinkingcao.encrypt.result.ApiResult;
import com.thinkingcao.encrypt.utils.RedisUtils;
import com.thinkingcao.encrypt.utils.ServletUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @desc:  API请求报文签名sign = timestamp+appId+appKey+nonce+version
 * @author: cao_wencao
 * @date: 2020-05-18 14:54
 */
@Slf4j
@Component
public class SignAuthInterceptor implements HandlerInterceptor {
    private static final String NONCE_KEY = "x-nonce-";

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String appId = request.getHeader("appId");
        if (StringUtils.isBlank(appId)){
            log.debug("appId不能为空...........");
            ServletUtils.renderString(response, JSON.toJSONString(ApiResult.fail("appId不能为空")));
            return false;
        }
        String timestampStr = request.getHeader("timestamp");
        if (StringUtils.isBlank(timestampStr)){
            log.debug("timestamp不能为空...........");
            ServletUtils.renderString(response, JSON.toJSONString(ApiResult.fail("timestamp不能为空")));
            return false;
        }
        String sign = request.getHeader("sign");
        if (StringUtils.isBlank(sign)){
            log.debug("sign不能为空...........");
            ServletUtils.renderString(response, JSON.toJSONString(ApiResult.fail("sign不能为空")));
            return false;
        }
        String nonce = request.getHeader("nonce");
        if (StringUtils.isBlank(nonce)){
            log.debug("nonce不能为空...........");
            ServletUtils.renderString(response, JSON.toJSONString(ApiResult.fail("nonce不能为空")));
            return false;
        }
        String signEcrypt = MD5Util.md5(appId  + Constants.APP_SECRET + timestampStr + nonce + new HeadRequest().getVersion());
        long timestamp = 0;
        try {
            timestamp = Long.parseLong(timestampStr);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        // //1.前端穿过来的时间戳与服务器当前时间戳差值大于180，则当前请求的timestamp无效
        // if (Math.abs(timestamp - System.currentTimeMillis() / 1000) > 180){
        //     log.debug("timestamp无效...........");
        //     ServletUtils.renderString(response, JSON.toJSONString(ApiResult.fail("timestamp无效")));
        //     return false;
        // }
        //2.通过判断redis中的nonce，确认当前请求是否为重复请求，控制API接口幂等性
        boolean nonceExists = redisUtils.hasKey(nonce);
        if (nonceExists){
            log.debug("nonce重复...........");
            ServletUtils.renderString(response, JSON.toJSONString(ApiResult.fail("重复的请求")));
            return false;
        }
        //3.通过后台MD5重新签名校验与前端签名sign值比对，确认当前请求数据是否被篡改
        if (!(sign.equalsIgnoreCase(signEcrypt))){
            log.debug("sign签名校验失败...........");
            ServletUtils.renderString(response, JSON.toJSONString(ApiResult.fail("sign签名校验失败")));
            return false;
        }
        //4.将nonce存进redis
        redisUtils.set(NONCE_KEY+nonce, nonce, 180);
        log.debug("签名校验通过，放行...........");
        //5.放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
