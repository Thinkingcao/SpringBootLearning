package com.thinkingcao.aspect;

import com.thinkingcao.annotation.InsertLog;
import com.thinkingcao.utils.AnnotationUtils;
import javassist.NotFoundException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

@Component
@Aspect
public class LogAspect {

    private Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* com.thinkingcao.controller..*(..))")
    private void pointcut() {
    }

    @After(value = "pointcut()")
    public void After(JoinPoint joinPoint) throws NotFoundException, ClassNotFoundException {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        //Object[] args = joinPoint.getArgs();
        //Class<?> targetClass = Class.forName(className);
        //Method[] methods = targetClass.getMethods();
        //for (Method method : methods) {
        //    if (method.getName().equalsIgnoreCase(methodName)) {
        //        Class<?>[] clazzs = method.getParameterTypes();
        //        if (clazzs.length == args.length) {
        //            InsertLog logAnnotation = method.getAnnotation(InsertLog.class);
        //            if (logAnnotation != null) {
        //                String logStr = logAnnotation.logStr();
        //                logger.error("获取日志：" + logStr);
        //                // 数据库记录操作...
        //                break;
        //            }
        //        }
        //    }
        //}
        String logStr = AnnotationUtils.get().getAnnotatioinFieldValue(className, methodName, InsertLog.class.getName(), "logStr");
        if (!StringUtils.isEmpty(logStr)) {
            logger.debug("获取日志：" + logStr);
            // 数据库记录日志操作...
        }
    }
}
