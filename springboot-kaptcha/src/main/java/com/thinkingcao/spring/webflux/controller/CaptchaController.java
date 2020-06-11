package com.thinkingcao.spring.webflux.controller;

import com.google.code.kaptcha.Producer;
import com.thinkingcao.spring.webflux.constant.Constants;
import com.thinkingcao.spring.webflux.result.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.Base64Utils;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @desc:  验证码 , 如果不使用spring-webflux获取验证码，则可以使用CaptchaController接口，二者是等价的，二选一
 * @author: cao_wencao
 * @date: 2020-06-10 17:58
 */
@RestController
@RequestMapping("/code")
@Slf4j
public class CaptchaController
{
    @Autowired
    private Producer producer;
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 生成验证码
     * @param response
     * @return
     * @throws IOException
     */
    @GetMapping("/captchaImage")
    public ApiResult captchaImage(HttpServletResponse response) throws IOException
    {
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
        // 将随机数randomStr放进header，前端校验验证码时需要传入
        response.setHeader("randomstr", randomStr);
        try {
            ImageIO.write(image, "jpg", os);
            log.info(" result : "+ os.toByteArray());
            return ApiResult.success("data:image/png;base64," + Base64Utils.encodeToString(os.toByteArray()),"获取图片验证码成功");
        } catch (IOException e) {
            log.error("ImageIO write err", e);
            return ApiResult.error("获取图片验证码失败");
        }
    }

    /**
     * 校验验证码
     * @param captcha
     * @param randomStr
     * @return
     */
    @GetMapping("/checkImgCaptcha")
    public ApiResult checkImgCaptcha(String captcha ,String randomStr){
        if (StringUtils.isBlank(captcha)){
            throw new RuntimeException("验证码不能为空");
        }
        if (StringUtils.isBlank(randomStr)){
            throw new RuntimeException("验证码不合法");
        }
        String key = Constants.DEFAULT_CODE_KEY + randomStr;
        String redisCode = redisTemplate.opsForValue().get(key);
        redisTemplate.delete(key);
        if (!captcha.equalsIgnoreCase(redisCode)) {
            return ApiResult.error(500, "生成图片验证码错误");
        }
        return ApiResult.success("生成图片验证码成功");
    }

}