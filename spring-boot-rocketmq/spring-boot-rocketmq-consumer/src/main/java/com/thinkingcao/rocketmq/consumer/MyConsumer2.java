package com.thinkingcao.rocketmq.consumer;

import com.thinkingcao.rocketmq.common.ConsumeConstant;
import com.thinkingcao.rocketmq.entity.OrderPaidEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * @desc: 消费者2
 * @title: MyConsumer2
 * @author: cao_wencao
 * @date: 2019-06-04 18:02
 * @version: 1.0
 * </pre>
 */
@Slf4j
@Service
@RocketMQMessageListener(nameServer = ConsumeConstant.NAMESERVER, topic = ConsumeConstant.TOPIC2, consumerGroup = ConsumeConstant.CONSUMERGROUP, messageModel = MessageModel.BROADCASTING)
public class MyConsumer2 implements RocketMQListener<OrderPaidEvent>, RocketMQPushConsumerLifecycleListener {


    @Override
    public void onMessage(OrderPaidEvent orderPaidEvent) {
        log.info("消费者开始接收第二个消息received orderPaidEvent: {}", orderPaidEvent);
        //TODO: 具体业务处理，编写业务代码，数据库交互
        log.info("消费者消费消息结束-----------");
    }

    @Override
    public void prepareStart(final DefaultMQPushConsumer consumer) {
        //设置一个新的订阅组第一次启动从队列的最前位置开始消费,后续再启动接着上次消费的进度开始消费，ConsumeFromWhere具体参数参考README.MD
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
    }


}