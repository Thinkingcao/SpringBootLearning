package com.thinkingcao.rocketmq.message;

import org.apache.rocketmq.common.message.MessageExt;

/**
 * <pre>
 * @desc: 业务处理handle接口，需要实现
 * @auth: cao_wencao
 * @date: 2019/6/11 16:08
 * </pre>
 */
public interface MessageHandler {
   public boolean handle(MessageExt messageExt);
}


