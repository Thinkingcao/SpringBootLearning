package com.thinkingcao.springboot.exception.result;

import lombok.Data;

import java.io.Serializable;

/**
 * @desc: ApiResult接口统一返回数据格式封装
 * @author: cao_wencao
 * @date: 2019-12-27 13:42
 */
@Data
public class ApiResult implements Serializable {

    private static final long serialVersionUID = 1672493411204459264L;

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private Object data;

    /**
     * 默认构造
     */
    public ApiResult() {
        this.code = ResponseStatus.SUCCESS.getCode();
        this.msg = ResponseStatus.SUCCESS.getMsg();
    }

    /**
     * 初始化一个新创建的ApiResult对象
     *
     * @param code 返回码
     * @param msg  返回信息
     * @param data 数据
     */
    public ApiResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    /**
     * 通用构造包含返回信息的 Api <br>
     * 主要用于包含返回信息和数据时的返回
     *
     * @param code 状态码
     * @param msg  信息
     * @return ApiResult
     */
    public static ApiResult of(int code, String msg, Object data) {
        return new ApiResult(code, msg, data);
    }

    /**
     * 通用构造包含返回信息的 Api <br>
     * 主要用于只包含返回信息，不包含数据时的返回
     *
     * @param code 状态码
     * @param msg  信息
     * @return ApiResult
     */
    public static ApiResult ofMessage(int code, String msg) {
        return new ApiResult(code, msg, null);
    }

    /**
     *
     * 通用请求成功，code=200，只返回提示信息msg
     *
     * @param msg 信息
     * @return ApiResult
     */
    public static ApiResult Success(String msg) {
        return new ApiResult(ResponseStatus.SUCCESS.getCode(), msg, null);
    }

    /**
     *
     * 通用请求成功，code=200，不返回数据
     * @return ApiResult
     */
    public static ApiResult Success() {
        return new ApiResult(ResponseStatus.SUCCESS.getCode(), ResponseStatus.SUCCESS.getMsg(), null);
    }

    /**
     *
     * 通用请求成功，code=200，返回数据
     *
     * @param data 操作成功时需要返回的数据
     * @return ApiResult
     */
    public static ApiResult Success(Object data) {
        return new ApiResult(ResponseStatus.SUCCESS.getCode(), ResponseStatus.SUCCESS.getMsg(), data);
    }


    /**
     *
     * 通用请求成功，code=200，返回数据和提示信息msg
     *
     * @param data 操作成功时需要返回的数据
     * @return ApiResult
     */
    public static ApiResult Success(String msg, Object data) {
        return new ApiResult(ResponseStatus.SUCCESS.getCode(), msg, data);
    }


    /**
     *
     * 用于出现异常时的返回,code和msg通过枚举类ResponseStatus传入
     *
     * @param status {@link ResponseStatus}
     * @return ApiResult
     */
    public static ApiResult failed(ResponseStatus status) {
        return new ApiResult(status.getCode(), status.getMsg(), null);
    }

}
