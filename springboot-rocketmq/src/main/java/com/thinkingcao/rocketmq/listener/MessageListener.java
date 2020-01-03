package com.thinkingcao.rocketmq.listener;

import com.thinkingcao.rocketmq.message.MessageHandler;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <pre>
 * @desc: 消息监听器，实现RocketMQ的MessageListenerConcurrently接口
 * @auth: cao_wencao
 * @date: 2019/6/11 16:09
 * </pre>
 */
public class MessageListener implements MessageListenerConcurrently {

    @Autowired
    private MessageHandler messageHandler;

    public void setMessageHandler(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        for (MessageExt messageExt : list) {
            MessageExt ext = messageExt;
            boolean result = messageHandler.handle(ext); //自定义监听器处理消息
            if (!result) {
                return ConsumeConcurrentlyStatus.RECONSUME_LATER; //消费失败，一段时间后重试
            }
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS; //消费成功
    }
}


