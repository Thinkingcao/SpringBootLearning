package com.thinkingcao.springboot.mongotemplate.result;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-01-02 15:58
 */

public class ApiResult {

    /**
     * 未登录
     */
    public static final int NO_LOGIN = 400;

    /**
     * 登录失败
     */
    public static final int LOGIN_FAILED = 401;

    /**
     * TOKEN过期
     */
    public static final int TOKEN_EXPIRED = 402;

    /**
     * 无权限
     */
    public static final int NO_PERMISSION = 403;


    private Boolean success;
    private Integer code;
    private String msg;
    private Object data;

    public ApiResult(Boolean success) {
        this.success = success;
    }

    public ApiResult(Boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public ApiResult(Integer code, Boolean success, String msg) {
        this.code = code;
        this.success = success;
        this.msg = msg;
    }

    public ApiResult(Boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public ApiResult(Boolean success, Integer code, String msg, Object data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    // ... ignore getter and setter methods

    public void put(String key, Object value) {
        if (data == null) {
            data = new HashMap<>();
        }
        ((Map) data).put(key, value);
    }

    public void putAll(Map<String, Object> map) {
        if (data == null) {
            data = new HashMap<>();
        }
        ((Map) data).putAll(map);
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
