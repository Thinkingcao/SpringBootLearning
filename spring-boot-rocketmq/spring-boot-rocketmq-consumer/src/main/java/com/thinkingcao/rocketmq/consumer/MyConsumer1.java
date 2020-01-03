package com.thinkingcao.rocketmq.consumer;

import com.thinkingcao.rocketmq.common.ConsumeConstant;
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
 * @desc:
 * @title: MyConsumer1
 * @author: cao_wencao
 * @date: 2019-06-04 18:02
 * @version: 1.0
 * </pre>
 */
// nameServer指定了链接某台指定的RocketMQ消息队列服务器
// MessageModel.BROADCASTING: 广播消费
// ConsumeMode.ORDERLY: 顺序消费
@Slf4j
@Service
@RocketMQMessageListener(nameServer =ConsumeConstant.NAMESERVER, topic = ConsumeConstant.TOPIC1, consumerGroup = ConsumeConstant.CONSUMERGROUP, messageModel = MessageModel.BROADCASTING)
public class MyConsumer1 implements RocketMQListener<String>, RocketMQPushConsumerLifecycleListener {

    @Override
    public void onMessage(String message) {
        log.info("消费者消费消息开始-----------");
        //TODO: 具体业务处理，编写业务代码，数据库交互
        log.info("消费者开始接收第一个消息received message: {}", message);
    }

    @Override
    public void prepareStart(final DefaultMQPushConsumer consumer) {
        //这里设置的是一个consumer的消费策略
        //CONSUME_FROM_LAST_OFFSET 默认策略，从该队列最尾开始消费，即跳过历史消息
        //CONSUME_FROM_FIRST_OFFSET 从队列最开始开始消费，即历史消息（还储存在broker的）全部消费一遍
        //CONSUME_FROM_TIMESTAMP 从某个时间点开始消费，和setConsumeTimestamp()配合使用，默认是半个小时以前
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        //消费者明确ack机制，确认消息消费成功
        // consumer.registerMessageListener(new MessageListenerConcurrently() {
        //     @Override
        //     public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        //         for (MessageExt messageExt : msgs) {
        //             String messageBody = null;
        //             try {
        //                 messageBody = new String(messageExt.getBody(),"utf-8");
        //                 if (messageExt.getReconsumeTimes() == 3){
        //                     //TODO 可以将对应的数据保存到数据库，以便人工干预
        //                     return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        //                 }
        //             } catch (UnsupportedEncodingException e) {
        //                 e.printStackTrace();
        //             }
        //             System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(
        //                     new Date()) + "消费响应：msgId : " + messageExt.getMsgId() + ",  msgBody : " + messageBody);//输出消息内容
        //
        //         }
        //         //返回消费状态
        //         //CONSUME_SUCCESS 消费成功
        //         //RECONSUME_LATER 消费失败，需要稍后重新消费
        //         return ConsumeConcurrentlyStatus.RECONSUME_LATER;
        //     }
        // });

    }
}