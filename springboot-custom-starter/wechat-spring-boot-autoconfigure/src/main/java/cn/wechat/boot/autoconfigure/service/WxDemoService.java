package cn.wechat.boot.autoconfigure.service;

import cn.wechat.boot.autoconfigure.properties.WxProperties;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-08-25 16:17
 */
@Slf4j
@Data
public class WxDemoService {

    private WxProperties wxProperties;

    public String initLoader(String msg) {
        String appId = wxProperties.getAppid();
        String appKey = wxProperties.getAppkey();
        String sercret = wxProperties.getAppsecret();
        String token = wxProperties.getToken();
        log.info("\n【应用ID】: {} \n【应用Key】: {} \n【应用秘钥】: {} \n【应用令牌】: {} ",appId,appKey,sercret,token);
        return msg + ",开始初始化："+ appId + appKey+sercret +token;
    }
}
