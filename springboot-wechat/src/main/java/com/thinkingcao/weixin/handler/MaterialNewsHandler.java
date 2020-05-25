package com.thinkingcao.weixin.handler;

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
 * @desc:
 * @author: cao_wencao
 * @date: 2020-05-21 23:41
 */
@Component
public class MaterialNewsHandler extends AbstractHandler{
    /**
     * 处理微信推送消息.
     *
     * @param wxMessage      微信推送消息
     * @param context        上下文，如果handler或interceptor之间有信息要传递，可以用这个
     * @param wxMpService    服务类
     * @param sessionManager session管理器
     * @return xml格式的消息，如果在异步规则里处理的话，可以返回null
     * @throws WxErrorException 异常
     */
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager sessionManager) throws WxErrorException {

        List<WxMpXmlOutNewsMessage.Item> articles = new ArrayList<>();
        WxMpXmlOutNewsMessage.Item item = new WxMpXmlOutNewsMessage.Item();
        item.setDescription("SpringBoot开发微信公众号");
        item.setPicUrl("www.baidu.com");
        item.setTitle("SpringBoot开发微信公众号");
        item.setUrl("www.baidu.com");

        articles.add(item);

        // 获取微信用户基本信息
        WxMpUser userWxInfo = wxMpService.getUserService().userInfo(wxMessage.getFromUser(), "zh_CN");
        if (null != userWxInfo){
            return WxMpXmlOutMessage
                    .NEWS()
                    .addArticle(item)
                    .articles(articles)
                    .build();
        }
        return null;
    }
}
