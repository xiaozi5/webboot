package com.xiaozi5.webboot.util;

import com.alibaba.fastjson.JSONObject;

public class JsonUtils {
	private JsonUtils() {
	}
	
	public static JSONObject getRes(Boolean success,String message ,Object data) {
		if (!(data instanceof String)) {
			data=JSONObject.toJSON(data);
		}
		JSONObject res = new JSONObject();
		res.put("succes", success==null?"false":success.toString());
		res.put("message", message);
		res.put("data", data);
		return res;
		
	}
	
	
	
	

}
