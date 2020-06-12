package com.thinkingcao.spring.webflux.router;

import com.thinkingcao.spring.webflux.handler.PeopleHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * people路由配置
 */
@Configuration
public class PeopleRouter {

    @Bean
    public RouterFunction<ServerResponse> routeCity(PeopleHandler peopleHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/hello")
                                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                        peopleHandler::helloPeople);
    }

}