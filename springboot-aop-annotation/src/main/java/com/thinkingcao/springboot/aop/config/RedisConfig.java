package com.thinkingcao.springboot.aop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * @desc: redis配置类,使用RedisTemplate需要注入Bean到Spring容器，类似Jedis
 * @author: cao_wencao
 * @date: 2019-12-13 12:17
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory, Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder) {
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Object> jsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        jsonRedisSerializer.setObjectMapper(jackson2ObjectMapperBuilder.build());
        StringRedisSerializer stringSerializer = new StringRedisSerializer();
        //=======设置下key和value的序列化方式,避免出现二进制数据显示=========
        //key采用String的序列化方式
        template.setKeySerializer(stringSerializer);
        //hash的key也采用String的序列化方式
        template.setValueSerializer(jsonRedisSerializer);
        //value序列化方式采用jackson
        template.setHashKeySerializer(stringSerializer);
        //hash的value序列化方式采用jackson
        template.setHashValueSerializer(jsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }

}
