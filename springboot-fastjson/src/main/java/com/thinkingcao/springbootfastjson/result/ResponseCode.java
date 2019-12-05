package com.thinkingcao.springbootfastjson.result;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;

/**
 * @desc: 接口响应工具类
 * @auth: cao_wencao
 * @date: 2019/11/21 18:00
 */
@Data
@AllArgsConstructor
public class ResponseCode extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    public static final String CODE_TAG = "code";

    public static final String MSG_TAG = "msg";

    public static final String DATA_TAG = "data";

    /**
     * 状态类型
     */
    public enum Type
    {
        /** 成功 */
        SUCCESS(200),
        /** 警告 */
        WARN(400),
        /** 错误 */
        ERROR(500);
        private final int value;

        Type(int value)
        {
            this.value = value;
        }

        public int value()
        {
            return this.value;
        }
    }

    /** 状态类型 */
    private Type type;

    /** 状态码 */
    private int code;

    /** 返回内容 */
    private String msg;

    /** 数据对象 */
    private Object data;


    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param type 状态类型
     * @param msg 返回内容
     */
    public ResponseCode(Type type, String msg)
    {
        super.put(CODE_TAG, type.value);
        super.put(MSG_TAG, msg);
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param type 状态类型
     * @param msg 返回内容
     * @param data 数据对象
     */
    public ResponseCode(Type type, String msg, Object data)
    {
        super.put(CODE_TAG, type.value);
        super.put(MSG_TAG, msg);
        if (data !=null)
        {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static ResponseCode success()
    {
        return ResponseCode.success("操作成功");
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static ResponseCode success(Object data)
    {
        return ResponseCode.success("操作成功", data);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static ResponseCode success(String msg)
    {
        return ResponseCode.success(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static ResponseCode success(String msg, Object data) {
        return new ResponseCode(Type.SUCCESS, msg, data);
    }

    /**
     * 返回警告消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static ResponseCode warn(String msg)
    {
        return ResponseCode.warn(msg, null);
    }

    /**
     * 返回警告消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static ResponseCode warn(String msg, Object data) {
        return new ResponseCode(Type.WARN, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @return
     */
    public static ResponseCode error() {
        return ResponseCode.error("操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static ResponseCode error(String msg) {
        return ResponseCode.error(msg, null);
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static ResponseCode error(String msg, Object data) {
        return new ResponseCode(Type.ERROR, msg, data);
    }

}