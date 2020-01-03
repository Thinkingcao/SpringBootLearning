package com.thinkingcao.rocketmq.consumer;

import com.thinkingcao.rocketmq.listener.MessageListener;
import com.thinkingcao.rocketmq.message.MessageHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * @desc: 消费者bean配置
 * @auth: cao_wencao
 * @date: 2019/6/11 16:07
 * </pre>
 */
@Component
@Slf4j
public class RocketMQConsumer  {

    @Autowired
    private MessageHandler messageHandler;

    @Value("${rocketmq.consumer.namesrvAddr}")
    private String namesrvAddr;
    @Value("${rocketmq.consumer.groupName}")
    private String groupName;
    @Value("${rocketmq.consumer.topic}")
    private String topic;
    @Value("${rocketmq.consumer.tag}")
    private String tag;
    @Value("${rocketmq.consumer.consumeThreadMin}")
    private int consumeThreadMin;
    @Value("${rocketmq.consumer.consumeThreadMax}")
    private int consumeThreadMax;

    @Bean
    public DefaultMQPushConsumer getRocketMQConsumer(){
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(groupName);
        //指定 NameServer 地址
        consumer.setNamesrvAddr(namesrvAddr);
        //最小消费线程池数量
        consumer.setConsumeThreadMin(consumeThreadMin);
        //最大消费线程池数量
        consumer.setConsumeThreadMax(consumeThreadMax);
        consumer.setVipChannelEnabled(false);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        //广播模式
        consumer.setMessageModel(MessageModel.BROADCASTING);
        //我们自己实现的监听类
        MessageListener messageListen = new MessageListener();
        messageListen.setMessageHandler(messageHandler);
        //注册消息监听器
        consumer.registerMessageListener(messageListen);
        try {
            //订阅指定 Topic 下的所有消息
            consumer.subscribe(topic,"*");
            consumer.start();
            log.info("consume is start ,groupName:{},topic:{}",groupName,topic);
        } catch (MQClientException e) {
            log.error("consume start error");
            e.printStackTrace();
        }
        return consumer;
    }


}

