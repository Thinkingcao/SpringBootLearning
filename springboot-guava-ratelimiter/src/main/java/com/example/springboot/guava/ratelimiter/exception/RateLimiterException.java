package com.example.springboot.guava.ratelimiter.exception;

/**
 * @desc:  业务异常
 * @author: cao_wencao
 * @date: 2022-05-18 21:35
 */
public class RateLimiterException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    protected final String message;

    public RateLimiterException(String message) {
        this.message = message;
    }

    public RateLimiterException(String message, Throwable e) {
        super(message, e);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
