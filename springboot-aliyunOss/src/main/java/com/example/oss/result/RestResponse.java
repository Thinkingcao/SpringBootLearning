package com.example.oss.result;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-11-06 17:04
 */
@Data
@Accessors(chain = true)
@Builder
public class RestResponse implements Serializable {
    public static final int CODE_200 = 200;

    public static final int CODE_500 = 500;
    private static final long serialVersionUID = -1559957698621135646L;


    /**
     * 消息 CODE_200
     */
    private int code = CODE_500;

    /**
     * 信息
     */
    private String message;

    /**
     * 数据
     */
    private Object data;


    /**
     * Instantiates a new Api result.
     */
    public RestResponse() {
        super();
    }


    /**
     * Instantiates a new Api result.
     *
     * @param code    the code
     * @param message the message
     * @param data    the data
     */
    public RestResponse(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * Instantiates a new Api result.
     *
     * @param code    the code
     * @param message the message
     */
    public RestResponse(int code, String message) {
        this(code, message, null);
    }


    /**
     * 错误
     *
     * @param message the message
     * @return api result
     */
    public static RestResponse error(String message) {
        return new RestResponse(CODE_500, message, null);
    }

    /**
     * 错误
     *
     * @param code    the code
     * @param message the message
     * @return api result
     */
    public static RestResponse error(int code, String message) {
        return new RestResponse(code, message);
    }

    /**
     * 成功
     *
     * @param message the message
     * @return api result
     */
    public static RestResponse succee(String message) {
        return new RestResponse(CODE_200, message);
    }

    /**
     * 成功
     *
     * @param data    the data
     * @param message the message
     * @return api result
     */
    public static RestResponse succee(Object data, String message) {
        return new RestResponse(CODE_200, message, data);
    }

    /**
     * 成功
     *
     * @param data the data
     * @return api result
     */
    public RestResponse success(Object data) {

        return new RestResponse(CODE_200, null, data);
    }
}
