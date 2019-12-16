package com.thinkingcao.springboot.token.common;

/**
 * @desc: 接口响应常量
 * @author: cao_wencao
 * @date: 2019-12-16 15:00
 */
public interface IRespConstant {

    /**
     * @desc: 登录相关返回状态码
     * @auth: cao_wencao
     * @date: 2019/12/16 16:31
     */
    public static interface ILoginInStatus {
        public static final int RESCODE_NOLOGIN = 1002;    //未登陆状态
        public static final String RESCODE_NOLOGIN_MSG = "用户未登录"; //未登录msg
        public static final int RESCODE_NOAUTH = 1003;//无操作权限
        public static final String RESCODE_NOAUTH_MGS = "拒绝授权"; //拒绝授权msg
        public static final int RESCODE_LOGINEXPIRE = 1004;//登录过期
        public static final String RESCODE_LOGINEXPIRE_MSG = "登录过期"; //登录过期msg
        public static final int CODE_LOGINOTHERADDR_ERROR = 1014;
        public static final String MESSAGE_LOGINOTHERADDR_ERROR = "该账号已在其他设备登录，请重新登录";
    }

    /**
     * @desc: 业务判断码——如果不定义为接口常量，也可以存放在常用的web字典里
     * @auth: cao_wencao
     * @date: 2019/12/16 16:32
     */
    public static interface IBusinessStatus {

    }


}
