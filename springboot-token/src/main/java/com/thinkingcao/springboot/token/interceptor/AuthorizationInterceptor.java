package com.thinkingcao.springboot.token.interceptor;

import com.thinkingcao.springboot.token.common.IRespConstant;
import com.thinkingcao.springboot.token.result.ResponseCode;
import com.thinkingcao.springboot.token.utils.HttpServletResponseUtil;
import com.thinkingcao.springboot.token.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @desc: 前后端分离，移动端、H5页面API请求鉴权拦截器
 * @author: cao_wencao
 * @date: 2019-12-16 14:53
 */
@Slf4j
public class AuthorizationInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisUtil redisUtil;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果访问的不是控制器,则跳出,继续执行下一个拦截器
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        //请求URL
        String url = request.getServletPath().toString();
        // 访问全路径
        String fullUrl = request.getRequestURL().toString();
        log.info("【请求全路径为： 】", fullUrl);
        //如果是登录则不拦截开始
        if (url.contains("/api/member/login")) {
            return true;
        }
        //获取HTTP HEAD 中的TOKEN、进行鉴权
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            HttpServletResponseUtil.printJSON(response, ResponseCode.fail(IRespConstant.ILoginInStatus.RESCODE_NOLOGIN, IRespConstant.ILoginInStatus.RESCODE_NOLOGIN_MSG));
            //response.getWriter().print("用户未登录，请登录后操作！");
            return false;
        }
        //从redis中取value，如果为空，则登陆过期
        Object loginStatus = redisUtil.get(token);
        if( Objects.isNull(loginStatus)){
            HttpServletResponseUtil.printJSON(response, ResponseCode.fail(IRespConstant.ILoginInStatus.RESCODE_LOGINEXPIRE,IRespConstant.ILoginInStatus.RESCODE_LOGINEXPIRE_MSG));
            //response.getWriter().print("登录过期!");
            return false;
        }
        //value不匹配为在其他设备登录，解决多台设备登录异常
        if (!loginStatus.equals(token)) {
            HttpServletResponseUtil.printJSON(response, ResponseCode.fail(IRespConstant.ILoginInStatus.CODE_LOGINOTHERADDR_ERROR,IRespConstant.ILoginInStatus.MESSAGE_LOGINOTHERADDR_ERROR));
            //response.getWriter().print("当前账号账号已在其他设备登录，请重新登录!");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //do nothing
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //do nothing
    }

}
