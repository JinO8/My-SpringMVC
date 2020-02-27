package com.jin.demo.sss.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**登陆拦截器
 * @author wangjin
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private Jedis jedis;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        //如果是登陆请求，直接放过
        if ("/".equals(uri)||uri.equals("/index.html")||uri.equals("/resume/login")){
            return true;
        }
        //如果不是登陆请求，判断有没有登陆
        String sessionId = request.getSession().getId();
        //根据sessionId判断有没有登陆（简单判断）
        boolean exists = jedis.exists(sessionId);
        //如果没有登陆，进行拦截，然后重定向到登陆页面
        if (!exists){
            response.sendRedirect(request.getContextPath()+"/");
            System.out.println("用户未登陆，进行拦截sessionId："+sessionId);
            return false;
        }
        System.out.println("用户已登陆，不做拦截sessionId："+sessionId);
        return true;
    }
}
