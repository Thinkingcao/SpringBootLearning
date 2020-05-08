package com.thinkingcao.utils;

import com.thinkingcao.annotation.InsertLog;
import javassist.NotFoundException;

/**
 * @创建者 CSDN_LQR
 * @描述 日志修改工具
 */
public class LogUtils {

    private static LogUtils mInstance;

    private LogUtils() {
    }

    public static LogUtils get() {
        if (mInstance == null) {
            synchronized (LogUtils.class) {
                if (mInstance == null) {
                    mInstance = new LogUtils();
                }
            }
        }
        return mInstance;
    }

    public void setLog(String logStr) throws NotFoundException {
        String className = Thread.currentThread().getStackTrace()[2].getClassName();
        String name = Thread.currentThread().getStackTrace()[0].getClassName();
        String name1 = Thread.currentThread().getStackTrace()[1].getClassName();
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        AnnotationUtils.get().setAnnotatioinFieldValue(className, methodName, InsertLog.class.getName(), "logStr", logStr);
    }
}
