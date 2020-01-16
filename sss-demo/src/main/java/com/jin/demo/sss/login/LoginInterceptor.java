package com.jin.demo.sss.login;

import com.jin.demo.sss.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**登陆拦截器
 * @author wangjin
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        //如果是登陆请求，直接放过
        if ("/".equals(uri)||uri.equals("/index.html")||uri.equals("/resume/login")){
            return true;
        }
        //如果不是登陆请求，判断有没有登陆
        User user = (User) request.getSession().getAttribute("user");
        //如果没有登陆，进行拦截，然后重定向到登陆页面
        if (null==user){
            response.sendRedirect(request.getContextPath()+"/");
            return false;
        }
        return true;
    }
}
