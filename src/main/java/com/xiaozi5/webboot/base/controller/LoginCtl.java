package com.xiaozi5.webboot.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.xiaozi5.webboot.base.service.LoginService;
import com.xiaozi5.webboot.model.User;
import com.xiaozi5.webboot.util.JsonUtils;

@RestController
public class LoginCtl {
	
	@Autowired
	private LoginService loginService;

	
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/login",method= {RequestMethod.POST})
	public JSONObject login(User user) {
		Boolean isLog=loginService.login(user);
		if (isLog) {
			return JsonUtils.getRes(true, "", "");
		}
		return JsonUtils.getRes(false, "", "");
	}
}
