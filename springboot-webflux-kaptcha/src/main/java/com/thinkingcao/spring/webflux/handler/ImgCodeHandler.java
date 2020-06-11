package com.thinkingcao.spring.webflux.handler;

import com.google.code.kaptcha.Producer;
import com.thinkingcao.spring.webflux.constant.Constants;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @desc:  图片验证码生成
 * @author: cao_wencao
 * @date: 2020-06-10 17:12
 */
@Slf4j
@Component
@AllArgsConstructor
public class ImgCodeHandler implements HandlerFunction<ServerResponse> {
    private final Producer producer;

    private final StringRedisTemplate redisTemplate;

    @Override
    public Mono<ServerResponse> handle(ServerRequest serverRequest) {
        // 生成验证码
        String capText = producer.createText();
        String capStr = capText.substring(0, capText.lastIndexOf("@"));
        String code = capText.substring(capText.lastIndexOf("@") + 1);
        BufferedImage image = producer.createImage(capStr);
        // 保存验证码信息
        String randomStr = UUID.randomUUID().toString().replaceAll("-", "");
        redisTemplate.opsForValue().set(Constants.DEFAULT_CODE_KEY + randomStr, code, 60, TimeUnit.SECONDS);
        // 转换流信息写出
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", os);
        } catch (IOException e) {
            log.error("ImageIO write err", e);
            return Mono.error(e);
        }
        return ServerResponse.status(HttpStatus.OK)
                .contentType(MediaType.IMAGE_JPEG)
                .header("randomstr", randomStr)
                .body(BodyInserters.fromResource(new ByteArrayResource(os.toByteArray())));
    }
}
