package cn.wechat.boot.autoconfigure.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-08-25 16:04
 */
@Data
@Component
@ConfigurationProperties(prefix = "wx.config")
public class WxProperties {

    private String isOpen;
    private String appid;
    private String appsecret;
    private String appkey;
    private String token;

}
