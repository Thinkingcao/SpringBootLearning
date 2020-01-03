package com.thinkingcao.rocketmq.message.impl;

import com.thinkingcao.rocketmq.message.MessageHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

/**
 * <pre>
 * @desc:  消息具体处理
 * @auth: cao_wencao
 * @date: 2019/6/11 16:06
 * </pre>
 */
@Service
@Slf4j
public class MessageHandlerImpl implements MessageHandler {
    @Override
    public boolean handle(MessageExt messageExt) {
        if(null != messageExt){
            try {
                String msgbody  = new String(messageExt.getBody(),"utf-8");
                log.info("监听到消息msgbody : " + msgbody); //输出消息内容
                //TODO: 开始业务代码编写
                return true;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                //如果处理业务代码出错，这里返回false，稍后重试(如果需要再次消费可采取消息重试机制)
                return false; //稍后再试
            }
        }
        return true;
    }
}


