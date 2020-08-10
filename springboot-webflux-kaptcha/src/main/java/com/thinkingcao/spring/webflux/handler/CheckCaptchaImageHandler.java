package com.thinkingcao.spring.webflux.handler;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;

import static com.thinkingcao.spring.webflux.handler.CaptchaImageHandler.DEFAULT_CODE_KEY;

/**
 * @desc:  图片验证码处理类
 * @author: cao_wencao
 * @date: 2020-06-12 10:58
 */
@Slf4j
@Component
@AllArgsConstructor
public class CheckCaptchaImageHandler implements HandlerFunction<ServerResponse> {

    private final StringRedisTemplate redisTemplate;

    @Override
    public Mono<ServerResponse> handle(ServerRequest serverRequest) {
        Optional<String> optionalCode = serverRequest.queryParam("captcha");
        Optional<String> optionalRandomStr = serverRequest.queryParam("randomStr");
        String code = "";
        String randomStr = "";
        if (optionalCode.isPresent()){
            code = optionalCode.get();
        }
        if (optionalRandomStr.isPresent()){
            randomStr = optionalRandomStr.get();
        }
        String key = DEFAULT_CODE_KEY + randomStr;
        String redisCode = redisTemplate.opsForValue().get(key);
        redisTemplate.delete(key);
        if (!code.equals(redisCode))
        {
            log.error("验证失败, 【原code】: {} ,【Redis中ode】: {} " , code, redisCode);
            return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).contentType(MediaType.TEXT_PLAIN).body(BodyInserters.fromValue("验证码验证失败"));

        }
        log.info("验证成功, 【原code】: {} ,【Redis中code】: {} " , code, redisCode);
        return ServerResponse.status(HttpStatus.OK.value()).contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("验证码验证通过"));
    }
}
