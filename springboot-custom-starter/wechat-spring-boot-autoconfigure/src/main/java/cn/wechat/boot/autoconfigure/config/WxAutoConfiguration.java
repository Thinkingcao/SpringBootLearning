package cn.wechat.boot.autoconfigure.config;

import cn.wechat.boot.autoconfigure.properties.WxProperties;
import cn.wechat.boot.autoconfigure.service.WxDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 	//prefix为配置文件中的前缀,
 * 	//name为配置的名字
 * 	//havingValue是与配置的值对比值,当两个值相同返回true,配置类生效.
 * @desc:  微信自动配置类
 * @author: cao_wencao
 * @date: 2020-08-25 16:13
 */
@Configuration //表明这是一个配置类
//当存在配置文件中以wx.config为前缀的属性，属性名称为is-open，然后它的值为enabled时才会实例化一个类。matchIfMissing 表示缺少这个属性时是否加载，如果为true，没有该property属性也会正常加载，如果为false，没有该property属性则报错，默认值是false。
@ConditionalOnProperty(prefix = "wx.config", name = "is-open", havingValue = "enabled",matchIfMissing = false)
@ConditionalOnClass(WxDemoService.class)//当前项目下classpath下存在WxDemoService类时配置类生效(类加载器中存在指明的类)
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
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
