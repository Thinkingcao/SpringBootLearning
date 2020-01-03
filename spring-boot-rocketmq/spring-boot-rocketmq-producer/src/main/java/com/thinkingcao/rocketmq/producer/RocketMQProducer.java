package com.thinkingcao.rocketmq.producer;


import com.alibaba.fastjson.JSONObject;
import com.thinkingcao.rocketmq.config.GenerateOrderNoUtil;
import com.thinkingcao.rocketmq.entity.OrderPaidEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <pre>
 * @desc:
 * @title: RocketMQProducer
 * @author: cao_wencao
 * @date: 2019-06-04 17:52
 * @version: 1.0
 * </pre>
 */
@Slf4j
@Component
public class RocketMQProducer implements CommandLineRunner {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Value("${rocketmq.producer.topic1}")
    private String topic1;

    @Value("${rocketmq.producer.topic2}")
    private String topic2;

    @Override
    public void run(String... args) throws Exception {
        // 以同步的方式发送字符串消息给指定的topic
        //SendResult sendResult = rocketMQTemplate.syncSend(topic1, "hello，syncSend");
        // 打印发送结果信息
        //System.out.printf("string-topic syncSend1 sendResult=%s %n", sendResult);

        log.info("-----------生产者开始生产消息-----------");
        String orderId = GenerateOrderNoUtil.genId();
        rocketMQTemplate.convertAndSend(topic1, "Hello, World!");
        log.info("生产者生产第一个消息完成: 主题:{}, 内容:{}",topic1,"Hello, World!"+ orderId);
        OrderPaidEvent order = new OrderPaidEvent("orderId-"+ orderId, 88);
        String jsonStr = JSONObject.toJSONString(order);
        rocketMQTemplate.convertAndSend(topic2, jsonStr);
        log.info("生产者生产第二个消息完成: 主题:{}, 内容:{}",jsonStr);
        log.info("-----------生产者生产消息结束-----------");
    }
}
