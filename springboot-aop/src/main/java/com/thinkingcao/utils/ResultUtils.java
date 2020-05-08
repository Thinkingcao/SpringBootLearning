package com.thinkingcao.utils;


import com.thinkingcao.result.ApiResult;

public class ResultUtils {

    public static ApiResult success() {
        return success(null);
    }

    public static ApiResult success(Object data) {
        ApiResult result = new ApiResult();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(data);
        return result;
    }

    public static ApiResult error() {
        return error("失败");
    }

    public static ApiResult error(String msg) {
        ApiResult result = new ApiResult();
        result.setCode(400);
        result.setMsg(msg);
        return result;
    }


}
