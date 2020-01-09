package com.thinkingcao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * <pre>
 * @desc: 启动类，为了方便测试，同时生产者也会开始生产消息
 * @auth: cao_wencao
 * @date: 2019/6/11 16:08
 * </pre>
 */
@SpringBootApplication
@Slf4j
public class RocketmqApplication {

    public static void main(String[] args) throws Exception{
        ApplicationContext context = SpringApplication.run(RocketmqApplication.class,args);

        // DefaultMQProducer producer = context.getBean(DefaultMQProducer.class);
        // for(int i = 0; i < 2; i ++) {
        //     String body = "see you again 好的" + i;
        //     //注意，第一个参数是topic，第二个tag，要和配置文件保持一致，第三个是body，也就是我们要发的消息，字节类型。
        //     Message message = new Message("topic2019", "music","周杰伦", body.getBytes());
        //     SendResult result = producer.send(message);
        //     log.info("\n【发送消息】：{}:" ,result);
        //     Thread.sleep(1000);
        // }
        // //关闭资源
        // //producer.shutdown();
        // //System.out.println("producer shutdown!");
    }

}
