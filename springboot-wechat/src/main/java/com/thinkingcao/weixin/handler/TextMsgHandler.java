package com.thinkingcao.weixin.handler;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutNewsMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @desc: 文本类型消息处理-TEXT
 * @link: XmlMsgType.TEXT
 * @author: cao_wencao
 * @date: 2020-05-20 15:15
 */
@Component
public class TextMsgHandler extends AbstractHandler {

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> map, WxMpService wxMpService, WxSessionManager wxSessionManager) throws WxErrorException {
        //判断传递过来的消息，类型是否为TEXT
        if (wxMessage.getMsgType().equals(WxConsts.XmlMsgType.TEXT)) {
            //TODO: 如果需要做微信消息日志存储，可以在这里进行日志存储到数据库，这里省略不写。
        }
        // 获取微信用户基本信息
        WxMpUser userWxInfo = wxMpService.getUserService().userInfo(wxMessage.getFromUser(), "zh_CN");
        if (null == userWxInfo){
            return null;
        }
        String content = wxMessage.getContent();
        if ("文本".equals(content)){
            //下面两种响应方式都可以
            //return new TextBuilder().build("您的一互动，泛起了我内心的涟漪。",wxMessage,wxMpService);
            return WxMpXmlOutMessage
                    .TEXT()
                    .content("您的一互动，就激起了我内心的无限可能")
                    .fromUser(wxMessage.getToUser())
                    .toUser(wxMessage.getFromUser())
                    .build();
        }
        if ("图片".equals(content)){
            return WxMpXmlOutMessage
                    .IMAGE()
                    .mediaId("1C72rnlYrj7ZqBiRGdKCoS54AXQwSo4iULd9qRhOC-U")
                    .fromUser(wxMessage.getToUser())
                    .toUser(wxMessage.getFromUser())
                    .build();
        }
        if ("图文".equals(content)){
            List<WxMpXmlOutNewsMessage.Item> articles = new ArrayList<>();
            WxMpXmlOutNewsMessage.Item item = new WxMpXmlOutNewsMessage.Item();
            item.setDescription("使用Java语言进行开发微信公众号发送图文消息");
            item.setPicUrl("http://mmbiz.qpic.cn/mmbiz_jpg/DwMlrmia5oVQrbNsb6GJ64xlUtfTXspTcyuV1m6ykgiaGJQYR374WWfGGrgibJOibYc1df7Wyicw4u9f5CV3u7oAzow/0?wx_fmt=jpeg");
            item.setTitle("SpringBoot开发微信公众号");
            item.setUrl("https://blog.csdn.net/thinkingcao/category_9277860.html");

            articles.add(item);
            return WxMpXmlOutMessage
                    .NEWS()
                    .addArticle(item)
                    .articles(articles)
                    .fromUser(wxMessage.getToUser())
                    .toUser(wxMessage.getFromUser())
                    .build();
        }
        return null;
    }
}
