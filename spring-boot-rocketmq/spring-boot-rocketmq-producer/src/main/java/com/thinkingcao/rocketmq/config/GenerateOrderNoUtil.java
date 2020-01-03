package com.thinkingcao.rocketmq.config;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 生成订单号 工具类
 * 
 */
public class GenerateOrderNoUtil {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");


    /**
     * 生成订单号
     *
     * @param pre 生成纯数字订单号
     * @return
     */
    public static String genId() {
        Long id = 530L;
        //生成
        String orderNo = sdf.format(new Date()) + (1 + (int) (Math.random() * 10000)) + id;
        return orderNo;
    }



    /**
     * 生成订单号
     *
     * @param pre 订单号前缀
     * @return
     */
    public static String gens(String pre, Long museId) {
        //生成
        String orderNo = pre + sdf.format(new Date()) + (1 + (int) (Math.random() * 10000)) + museId;
        return orderNo;
    }

    /**
     * 生成订单号
     *
     * @param pre 订单号前缀
     * @return
     */
    public static String gen(String pre, Long museId) {
        //生成
        String orderNo = pre + ((int)((Math.random()*9+1)*10000)) + museId + (System.currentTimeMillis() / 1000);
        return orderNo;
    }

    public static void main(String[] args) {
        System.out.println(gens("R",530L));
        System.out.println(gen("R",530L));
        System.out.println(genId());
    }
}
