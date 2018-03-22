 package com.holy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.holy.domain.User;

/**
 * MVC pojo的序列化和反序列化在依赖（MVC已经在:mvc:annotation-driven中封装）
 * 	 jackson-core-asl-1.9.11.jar 和 jackson-mapper-asl-1.9.11.jar
	 的前提下，通过对请求参数的解析实现
		requestBody responseBody
	 如果不配置mvc:annotation-driven，则在requestMappingHandlerAdapter中注册 
 * 阿里巴巴的fastJson
 * Spring4支持RestController
 * @author hadoop 
 *
 */
@RequestMapping("/jsonController")
@Controller
public class jsonController {
	@RequestMapping(value="toJsonObject",method=RequestMethod.POST)
	public @ResponseBody User toJsonObject(@RequestBody User user) {
		System.out.println(user);
		//pojo的序列化  
		return user;
	}
	@RequestMapping("/jsonRequest.do") 
	//TODO 为什么不用加 .do 以及 /        解释：最终匹配
	//根据注解 以及返回类型 进行视图解析方式的判断？？？？
	public String jumpTo() {
		return "jsonRequest";
	}
	/*
	 * 在实际开发中，一般是参数注入 然后返回json  ?key1=value&key2=value
	 */
}
