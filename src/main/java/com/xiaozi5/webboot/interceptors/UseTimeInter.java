package com.xiaozi5.webboot.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

public class UseTimeInter implements HandlerInterceptor {
	
	private ThreadLocal<Long> threadLocalTime=new ThreadLocal<Long>();
	private Log log= LogFactory.getLog(this.getClass());
	
	
	/**
	 * 记录请求开始时间
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HandlerMethod handlerMethod=(HandlerMethod) handler;
		Long startTime = System.currentTimeMillis();
		threadLocalTime.set(startTime);
		return true;
	}


	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		Long endTime=System.currentTimeMillis();
		Long startTime = threadLocalTime.get();
		threadLocalTime.remove();
		log.info("请求时间:"+(endTime-startTime)+"ms");
		
	}
	
	
	
	

}
