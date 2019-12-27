package com.thinkingcao.springboot.exception.result;

import lombok.Getter;

/**
 * @desc: 响应状态码枚举
 * @author: cao_wencao
 * @date: 2019-12-27 14:47
 */
@Getter
public enum ResponseStatus {
    /**
     * 成功
     */
    SUCCESS(200, "成功"),

    /**
     * 请求错误
     */
    BAD_REQUEST(400, "请求错误"),

    /**
     * 尚未登录
     */
    UNAUTHORIZED(401, "尚未登录"),

    /**
     * 权限不够
     */
    FORBIDDEN(403, "权限不够"),

    /**
     * 请求不存在
     */
    REQUEST_NOT_FOUND(404, "请求不存在"),

    /**
     * 服务器内部错误
     */
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),

    /**
     * 用户名或密码错误
     */
    USERNAME_OR_PASSWORD_ERROR(50000, "用户名或密码错误"),

    /**
     * 用户不存在
     */
    USER_NOT_EXIST(50001, "账号不存在"),

    /**
     * 用户已被禁用
     */
    USER_DISABLE(50002, "账号已被禁用"),

    /**
     * 账号已删除
     */
    USER_DELETED(50003, "账号已删除"),

    /**
     * 验证码错误
     */
    VERIFY_CODE_ERROR(50004, "验证码错误"),

    /**
     * 登录成功
     */
    LOGIN_SUCCESS(50005, "登录成功"),

    /**
     * 退出成功
     */
    LOGOUT_SUCCESS(50006, "退出成功"),

    /**
     * 验证码异常
     */
    CODE_ERROR(50007, "验证码异常"),

    /**
     * 获取验证码的值失败
     */
    CODE_GET_ERROR(50008, "获取验证码的值失败"),

    /**
     * 验证码的值不能为空
     */
    CODE_VALUE_NOT_NULL(50009, "验证码的值不能为空"),

    /**
     * 验证码不存在
     */
    CODE_NOT_FOUND(50010, "验证码不存在"),

    /**
     * 验证码已过期
     */
    CODE_IS_EXPIRED(50011, "验证码已过期"),

    /**
     * 验证码不匹配
     */
    CODE_NOT_MATCH(50012, "验证码不匹配"),

    /**
     * 验证码发送异常
     */
    CODE_SEND_ERROR(50012, "验证码发送异常");

    private Integer code;
    private String msg;

    ResponseStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
