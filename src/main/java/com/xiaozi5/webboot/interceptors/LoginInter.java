package com.xiaozi5.webboot.interceptors;

import static org.hamcrest.CoreMatchers.nullValue;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.xiaozi5.webboot.anno.NeedLogin;

public class LoginInter implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//如果是错误页面放过
		if("/error".equals(request.getServletPath())) {
			return true;
		}
		//如果请求controller,根据needlogin注解判断是否要登录
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod=(HandlerMethod) handler;
			if (handlerMethod.hasMethodAnnotation(NeedLogin.class)) {
				HttpSession session = request.getSession();
				Object user = session.getAttribute("user");
				if (user==null) {
					request.getRequestDispatcher("/home/index.html").forward(request, response);
					return false;
				}
			}
		}
		return true;
	}
	
	

}
