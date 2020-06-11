package com.thinkingcao.spring.webflux.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Consumer;

/**
 * @desc: 图片验证码校验
 * @author: cao_wencao
 * @date: 2020-06-11 20:34
 */
@Component
public class CaptchaImageFilter extends AbstractGatewayFilterFactory<CaptchaImageFilter.Config> {

    @Override
    public GatewayFilter apply(Config config) {
        return null;
    }

    @Override
    public GatewayFilter apply(String routeId, Consumer<Config> consumer) {
        return null;
    }

    @Override
    public GatewayFilter apply(Consumer<Config> consumer) {
        return null;
    }

    @Override
    public GatewayFilter apply(String routeId, Config config) {
        return null;
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public ShortcutType shortcutType() {
        return null;
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return null;
    }

    @Override
    public String shortcutFieldPrefix() {
        return null;
    }

    public static class Config
    {
    }

}


