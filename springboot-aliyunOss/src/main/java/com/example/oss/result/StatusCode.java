package com.example.oss.result;

/**
 * @desc:  返回状态枚举类
 * @author: cao_wencao
 * @date: 2020-11-06 15:07
 */
public enum StatusCode {
    /**
     * 成功-状态码200
     */
    SUCCESS("success",200),

    /**
     * 失败-状态码500
     */
    ERROR("error",500);

    private String msg;
    private Integer code;

    StatusCode(String msg,Integer code){
        this.msg = msg;
        this.code = code;
    }
    StatusCode(Integer code){
        this.code = code;
    }
    StatusCode(String msg){
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
}