package com.thinkingcao.springbootvalidatecode.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-01-03 15:48
 */

@Data
@Component
@ConfigurationProperties(prefix = "validatecode.info")
public class ValidateCodeProperties {
    /**
     * 验证码的宽
     */
    // @Value("${validatecode.info.codeWidth}")
    private  int codeWidth;

    /**
     * 验证码的高
     */
    // @Value("${validatecode.info.codeHeight}")
    private  int codeHeight;

    /**
     * 验证码的干扰线数量
     */
    // @Value("${validatecode.info.codeLineSize}")
    private  int codeLineSize;

    /**
     * 验证码词典
     */
    // @Value("${validatecode.info.codeRandomString}")
    private  String codeRandomString;

}
