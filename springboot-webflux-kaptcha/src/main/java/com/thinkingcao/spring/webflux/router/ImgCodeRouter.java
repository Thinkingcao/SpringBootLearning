package com.thinkingcao.spring.webflux.router;


import com.thinkingcao.spring.webflux.handler.ImgCodeHandler;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @desc: 图片验证码路由配置
 * @author: cao_wencao
 * @date: 2020-06-10 17:04
 */
@Configuration
@AllArgsConstructor
public class ImgCodeRouter {
    @Bean
    public RouterFunction<ServerResponse> routeFunction(ImgCodeHandler imgCodeHandler){
        return RouterFunctions
                .route(RequestPredicates.GET("/code")
                        .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), imgCodeHandler::handle);
    }
}
