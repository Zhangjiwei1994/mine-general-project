package com.hongm.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try{
            Object user = request.getSession().getAttribute("user");
            System.out.println(user);
            System.out.println(request.getRequestURI());
            if(user != null){
                System.out.println("不拦截！！");
                return true;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/login");
        return false;
    }
}
