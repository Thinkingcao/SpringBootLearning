package com.thinkingcao.springboot.exception.exception;

import com.thinkingcao.springboot.exception.result.ResponseStatus;
import lombok.Getter;

/**
 *<p>
 * 自定义业务异常类
 * </p>
 * @desc: 通用全局异常
 * @author: cao_wencao
 * @date: 2019-12-27 14:56
 */
@Getter
public class BusinessException extends Exception {
    /**
     * 异常码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回内容
     */
    private Object data;

    public BusinessException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BusinessException(Integer code, String msg, Object data) {
        super(msg);
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BusinessException(ResponseStatus status) {
        super(status.getMsg());
        this.code = status.getCode();
        this.msg = status.getMsg();
    }

    public BusinessException(ResponseStatus status, Object data) {
        super(status.getMsg());
        this.code = status.getCode();
        this.msg = status.getMsg();
        this.data = data;
    }
}