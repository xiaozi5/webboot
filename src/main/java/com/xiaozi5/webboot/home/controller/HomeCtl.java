package com.xiaozi5.webboot.home.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.xiaozi5.webboot.home.service.HomeService;

@RestController
@RequestMapping("/home/")
public class HomeCtl {
	
	@Autowired
	private HomeService homeService;
	
	@RequestMapping("/personinfo/{userid}")
	public JSONObject personInfo(@PathVariable String userid) {
		
		return null;
	}

}
