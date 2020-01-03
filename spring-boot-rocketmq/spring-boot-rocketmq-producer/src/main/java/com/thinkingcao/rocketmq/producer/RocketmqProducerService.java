package com.thinkingcao.rocketmq.producer;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
 
/**
 * 消息生产者，可与消费者分离
 * @author hqc
 * @Date 2018年12月28日
 *
 */
@Service
public class RocketmqProducerService {
	
   public static final String topic = "temTopic"; //定义主题，可分离放在配置文件里面，一般一个主题发送同类消息，主题格式：`topicName:tags`
	
   // 声明并引用RocketMQTemplate
   @Resource
   private RocketMQTemplate rocketMQTemplate;
   
   /**
    * 同步发送字符串消息
    * @param msg
    * @return
    */
   public boolean sendMsg(String message) {
	   // 以同步的方式发送字符串消息给指定的topic
	   Long startTime = System.currentTimeMillis();
	   /*int size = 10000;
	   message = "[";
	   for(int i=0;i<size;i++) {
		   String mess = "{id:'123456',rate:'"+msg+i+"'},";
				   if(i==(size-1)) {
					   mess = "{id:'123456',rate:'"+msg+i+"'}]";
				   }
		   message+=mess;
	   }*/
	   SendResult sendResult = rocketMQTemplate.syncSend(topic, message);
       // 打印发送结果信息
       System.out.printf("string-topic syncSend1 sendResult=%s %n", sendResult);
       Long endTime = System.currentTimeMillis();
	   System.out.println("单次生产耗时："+(endTime-startTime)/1000);
	   return true;
   }
   
   /**
    * 同步发送实体对象消息
    * 可靠同步发送：同步发送是指消息发送方发出数据后，会在收到接收方发回响应之后才发下一个数据包的通讯方式；
    * 特点：速度快；有结果反馈；数据可靠；
    * 应用场景：应用场景非常广泛，例如重要通知邮件、报名短信通知、营销短信系统等；
    * @param msg
    * @return
    */
   public boolean sendMsgObj() {
	   Map<String,Object> map = new HashMap<String,Object>();
	   map.put("name", "sixmonth");
	   map.put("age", "88");
       Message msg = new Message("openSporting", "tem1", map.toString().getBytes());
	   // 以同步的方式发送字符串消息给指定的topic
	   SendResult sendResult = rocketMQTemplate.syncSend(topic, msg);
	   // 打印发送结果信息
	   System.out.printf("string-topic syncSend1 sendResult=%s %n", sendResult);
	   return true;
   }
   
   /**
    * 异步发送消息
    * 可靠异步发送：发送方发出数据后，不等接收方发回响应，接着发送下个数据包的通讯方式；
    * 特点：速度快；有结果反馈；数据可靠；
    * 应用场景：异步发送一般用于链路耗时较长,对 rt响应时间较为敏感的业务场景,例如用户视频上传后通知启动转码服务,转码完成后通知推送转码结果等；
    * @param msg
    * @return
    */
   public boolean sendMsgAsy() {
	   Map<String,Object> map = new HashMap<String,Object>();
	   map.put("name", "sixmonth");
	   map.put("age", "88");
	   // 以同步的方式发送字符串消息给指定的topic
	   rocketMQTemplate.asyncSend(topic, map,new SendCallback() {
           @Override
           public void onSuccess(final SendResult sendResult) {
               //消息发送成功
               System.out.println("send message success. topic=" + sendResult.getSendStatus());
           }
			@Override
			public void onException(Throwable e) {
				//消息发送失败
				System.out.println("send message failed. execption=" + e.getStackTrace() );
			}
	   });
	   return true;
   }
   
   /**
    * 单向发送
    * 单向发送：只负责发送消息，不等待服务器回应且没有回调函数触发，即只发送请求不等待应答；此方式发送消息的过程耗时非常短，一般在微秒级别；
    * 特点：速度最快，耗时非常短，毫秒级别；无结果反馈；数据不可靠，可能会丢失；
    * 应用场景：适用于某些耗时非常短，但对可靠性要求并不高的场景，例如日志收集；
    * @return
    */
   public boolean sendMsgOneway() {
	   Map<String,Object> map = new HashMap<String,Object>();
	   map.put("name", "sixmonth1");
	   map.put("age", "88");
	   rocketMQTemplate.sendOneWay(topic, map);
	   return true;
   }
   
   
}