package com.xiaozi5.webboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.xiaozi5.webboot.interceptors.LoginInter;
import com.xiaozi5.webboot.interceptors.UseTimeInter;


@Configuration
@EnableWebMvc
public class InterceptorsConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new UseTimeInter()).excludePathPatterns("/**/*.html");
		registry.addInterceptor(new LoginInter()).excludePathPatterns("/**/*.html");
		
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
	}

	
	@Bean
	public ViewResolver internalResourceViewResolver() {
		return new InternalResourceViewResolver("/home/", ".html");
	}
	
	
	//fastjson处理json数据
	@Bean 
	public HttpMessageConverter fastJsonMessageConverter() {
		return new FastJsonHttpMessageConverter();
	}
	
	

}
