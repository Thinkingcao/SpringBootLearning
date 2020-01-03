package com.thinkingcao.springbootvalidatecode.controller;

import com.google.common.collect.Maps;
import com.thinkingcao.springbootvalidatecode.config.ValidateCodeProperties;
import com.thinkingcao.springbootvalidatecode.result.ResponseCode;
import com.thinkingcao.springbootvalidatecode.utils.ImgValidateCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @desc: 图片验证码Controller
 * @auth: cao_wencao
 * @date: 2019/12/31 15:24
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class ValidateCodeController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ValidateCodeProperties validateCodeProperties;


    /**
     * @url： http://127.0.0.1:8080/api/getImgCode
     * @desc: 生成图片验证码
     * @auth: cao_wencao
     * @date: 2020/1/3 14:43
     */
    @GetMapping("/getImgCode")
    public ResponseCode getImgCode() {
        //初始化一个map
        Map<String, String> result = Maps.newHashMap();
        try {
            // 获取 4位数验证码
            result = ImgValidateCodeUtil.getImgCodeBaseCode(4);
            log.info("生成图片验证码 : {}", result);
            // 将验证码存入redis 中（有效时长5分钟）
            setImgCodeCache(result);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return ResponseCode.success("生成图片验证码成功", result);
    }


    /**
     * @param imgCodeKey
     * @param imgCode
     * @url: http://127.0.0.1:8080/api/getImgCode
     * @desc: 校验验证码
     * @auth: cao_wencao
     * @date: 2020/1/3 14:43
     */
    @GetMapping("/checkImgCode")
    public ResponseCode checkImgCode(String imgCodeKey, String imgCode) {
        String cacheCode = redisTemplate.opsForValue().get(imgCodeKey);
        if (null == cacheCode) {
            return ResponseCode.error("图片验证码已过期，请重新获取");
        }
        if (cacheCode.equals(imgCode.toLowerCase())) {
            log.debug("cacheCode: {} ,imgCode : {}", cacheCode, imgCode);
            return ResponseCode.success("验证码校验正确", cacheCode);
        }
        return ResponseCode.error("验证码输入错误");
    }


    /**
     * 将验证码存入redis 中
     *
     * @param result
     */
    private void setImgCodeCache(Map<String, String> result) {
        String imgCode = result.get("imgCode");
        UUID randomUUID = UUID.randomUUID();
        String imgCodeKey = randomUUID.toString();
        System.out.println("imgCodeKey:" + imgCodeKey);
        // 图片验证码有效时间 ：5 分钟
        redisTemplate.opsForValue().set(imgCodeKey, imgCode, 5, TimeUnit.MINUTES);
        result.put("imgCodeKey", imgCodeKey);
    }

    @GetMapping("/getParam")
    public ResponseCode getParam() {
        Map<String, String> map = Maps.newHashMap();
        map.put("codeWidth", String.valueOf(validateCodeProperties.getCodeWidth()));
        map.put("codeHeight", String.valueOf(validateCodeProperties.getCodeHeight()));
        map.put("codeLineSize", String.valueOf(validateCodeProperties.getCodeLineSize()));
        map.put("codeRandomString", String.valueOf(validateCodeProperties.getCodeRandomString()));
        return ResponseCode.success(map);
    }
}
