package com.thinkingcao.springboot.miniapp.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaSubscribeMessage;
import com.thinkingcao.springboot.miniapp.config.WxMiniConfiguration;
import com.thinkingcao.springboot.miniapp.result.ApiResult;
import com.thinkingcao.springboot.miniapp.utils.DateUtils;
import com.thinkingcao.springboot.miniapp.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @desc: 微信小程序订阅消息推送接口
 * @author: cao_wencao
 * @date: 2020-08-06 14:22
 */
@Slf4j
@RestController
@RequestMapping("/api/msg")
public class WxMsgPushController {

    public static final String POINT_COUNT = "10";

    /**
     * 微信小程序推送订阅消息
     *
     * @param openid
     * @return
     */
    @GetMapping("/push")
    public ApiResult push(String accountCode, String appId, String openid) {
        if (StringUtils.isAnyBlank(accountCode, appId, openid)) {
            return ApiResult.error("参数缺失");
        }
        WxMaSubscribeMessage subscribeMessage = new WxMaSubscribeMessage();
        //发送给哪个用户
        subscribeMessage.setToUser(openid);
        //模板消息id
        subscribeMessage.setTemplateId("5zl1Qn_U10o1sGWRU06HqytTiZ8zi0QCJYA0D_l7_tA");
        //跳转小程序页面路径
        subscribeMessage.setPage("pages/index/index");
        //进入小程序查看”的语言类型
        subscribeMessage.setLang("zh_CN");

        //=====================================创建一个参数集合======================
        ArrayList<WxMaSubscribeMessage.Data> wxMaSubscribeData = new ArrayList<>();

        // 第三个内容：绿账卡号
        WxMaSubscribeMessage.Data data1 = new WxMaSubscribeMessage.Data();
        data1.setName("character_string7");
        data1.setValue(accountCode);
        wxMaSubscribeData.add(data1);

        //第一个内容： 变更分值
        WxMaSubscribeMessage.Data data2 = new WxMaSubscribeMessage.Data();
        data2.setName("thing4");
        data2.setValue(POINT_COUNT);
        //每个参数 存放到大集合中
        wxMaSubscribeData.add(data2);

        // 第二个内容：变更时间
        WxMaSubscribeMessage.Data data3 = new WxMaSubscribeMessage.Data();
        data3.setName("time1");
        data3.setValue(DateUtils.getTime());
        wxMaSubscribeData.add(data3);

        // 第二个内容：备注
        WxMaSubscribeMessage.Data data4 = new WxMaSubscribeMessage.Data();
        data4.setName("thing3");
        data4.setValue("扫描绿账卡号，账户积分增加变动");
        wxMaSubscribeData.add(data4);

        //把集合给大的data
        subscribeMessage.setData(wxMaSubscribeData);

        try {
            //获取微信小程序配置：
            //final WxMaService wxService = WxMaConfiguration.getMaService(appId);
            //进行推送
            final WxMaService wxService = WxMiniConfiguration.getMaService(appId);
            wxService.getMsgService().sendSubscribeMsg(subscribeMessage);
            log.info("【微信小程序推送订阅消息成功：】" + JsonUtils.toJson(subscribeMessage));
            return ApiResult.succee("推送成功");
        } catch (Exception e) {
            log.error("【微信小程序推送订阅消息失败：】" + JsonUtils.toJson(subscribeMessage));
            e.printStackTrace();
        }
        return ApiResult.error("推送失败");
    }

}
