package com.thinkingcao.springboot.aop.aspect;

import com.thinkingcao.springboot.aop.annotation.NoRepeatSubmit;
import com.thinkingcao.springboot.aop.utils.Constant;
import com.thinkingcao.springboot.aop.utils.HttpServletRequestUtil;
import com.thinkingcao.springboot.aop.utils.HttpServletResponseUtil;
import com.thinkingcao.springboot.aop.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @desc: 表单重复提交AOP切面，解析注解@NoRepeatSubmit
 * @author: cao_wencao
 * @date: 2019-12-17 22:09
 */
@Aspect
@Component
@Slf4j
public class RepeatSubmitAop {

    //注入Redis工具类
    @Autowired
    private RedisUtil redisUtil;

    //定义切入点, 拦截controller的所有请求
    private  final String POINTCUT = "execution(public * com.thinkingcao.springboot.aop.controller.*.*(..))";


    //前置通知
    /*@Before(POINTCUT)
    public void before(JoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        NoRepeatSubmit noRepeatSubmit = signature.getMethod().getDeclaredAnnotation(NoRepeatSubmit.class);
        if (null != noRepeatSubmit) {
            //获取type参数的value
            String typeValue = noRepeatSubmit.type();

        }
    }*/

    //环绕通知
    @Around(POINTCUT)
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        //1. 使用AOP环绕通知拦截所有请求(controller)
        //POINTCUT
        //2. 判断方法上是否有@NoRepeatSubmit
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        NoRepeatSubmit noRepeatSubmit = signature.getMethod().getDeclaredAnnotation(NoRepeatSubmit.class);
        //3. 如果方法上有@NoRepeatSubmit
        if (null != noRepeatSubmit) {
            //获取type参数的value
            String typeValue = noRepeatSubmit.type();
            String token = null;
            HttpServletRequest request = HttpServletRequestUtil.getRequest();

            //如果存在header中,从头中获取
            if (typeValue.equals(Constant.EXTAPIHEAD)) {
                token = request.getHeader("token");
            } else {
                ////否则从 请求参数获取
                token = request.getParameter("token");
            }
            if (StringUtils.isEmpty(token)) {
                HttpServletResponseUtil.response("参数错误!");
                return null;
            }
            //如果redis中token不存在，则为重复提交
            String redisToken = (String) redisUtil.get(token);
            if (StringUtils.isEmpty(redisToken)) {
                HttpServletResponseUtil.response("请勿重复提交!");
                return null;
            }
            //redis不为空，则为第一次请求
            redisUtil.del(redisToken);
        }
        //放行
        Object proceed = joinPoint.proceed();
        return proceed;
    }


}
