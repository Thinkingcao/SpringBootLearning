package com.thinkingcao.springboot.aop.annotation;

import java.lang.annotation.*;

/**
 * @desc:  对解决接口幂等性、网络延迟、表单重复提交的注解的封装
 * @author: cao_wencao
 * @date: 2019-12-17 22:01
 */
@Documented
@Inherited
@Target(value = {ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NoRepeatSubmit {
    String type();
}
