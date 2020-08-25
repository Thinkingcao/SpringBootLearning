package cn.wechat.boot.autoconfigure.config;

import cn.wechat.boot.autoconfigure.properties.WxProperties;
import cn.wechat.boot.autoconfigure.service.WxDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @desc:  微信自动配置类
 * @author: cao_wencao
 * @date: 2020-08-25 16:13
 */
@Configuration //表明这是一个配置类
@ConditionalOnClass(WxDemoService.class)//当前项目下classpath下存在WxDemoService类时配置类生效
@EnableConfigurationProperties(WxProperties.class)//使我们之前配置的 @ConfigurationProperties生效，让配置的属性成功的进入Bean 中。
public class WxAutoConfiguration {
    @Autowired
    private WxProperties properties;

    @Bean
    public WxDemoService wxDemoService(){
        WxDemoService demoService = new WxDemoService();
        demoService.setWxProperties(properties);
        return demoService;
    }

}
