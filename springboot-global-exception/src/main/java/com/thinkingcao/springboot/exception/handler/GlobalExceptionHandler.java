package com.thinkingcao.springboot.exception.handler;

import com.thinkingcao.springboot.exception.exception.BusinessException;
import com.thinkingcao.springboot.exception.result.ApiResult;
import com.thinkingcao.springboot.exception.result.ResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.nio.file.AccessDeniedException;

/**
 * @desc: 全局异常处理
 * @author: cao_wencao
 * @date: 2019-12-27 14:59
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ApiResult handlerException(Exception e) {
        //404异常
        if (e instanceof NoHandlerFoundException) {
            log.error("【全局异常拦截】NoHandlerFoundException: 请求方法 {}, 请求路径 {}", ((NoHandlerFoundException) e).getRequestURL(), ((NoHandlerFoundException) e).getHttpMethod());
            return ApiResult.failed(ResponseStatus.REQUEST_NOT_FOUND);
        }
        //业务异常
        else if (e instanceof BusinessException) {
            log.error("【全局异常拦截】BusinessException: 状态码 {}, 异常信息 {}", ((BusinessException) e).getCode(), e.getMessage());
            return new ApiResult(((BusinessException) e).getCode(), e.getMessage(), ((BusinessException) e).getData());
        }
        //权限异常
        else if (e instanceof AccessDeniedException) {
            log.error("【全局异常拦截】AccessDeniedException: 异常信息 {}", e.getMessage());
            return ApiResult.failed(ResponseStatus.FORBIDDEN);
        }
        //未知异常(500)
        log.error("【全局异常拦截】: 异常信息 {} ", e.getMessage());
        return ApiResult.failed(ResponseStatus.INTERNAL_SERVER_ERROR);
    }
}
