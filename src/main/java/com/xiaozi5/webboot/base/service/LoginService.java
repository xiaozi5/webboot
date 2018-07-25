package com.xiaozi5.webboot.base.service;

import com.xiaozi5.webboot.model.User;

public interface LoginService {

	/**
	 * 登录
	 * @param user
	 */
	Boolean login(User user);

}
