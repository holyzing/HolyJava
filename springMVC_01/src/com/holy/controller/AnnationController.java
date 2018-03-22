package com.holy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 基于注解的Controller 和 struts 的多方法映射很像
 * @author hadoop
 */
@Controller
public class AnnationController {
//<bean id="annationController class="com.holy.Controllor.AnnationController"">
	/**
	 * 通过url以及<a>发送的所有请求都是get请求，通过表单以及ajax指定post的请求均为post请求
	 * get请求所有的参数信息均在url中且为可见的，但是post请求的参数在header中,相对较安全
	 * @return
	 */
	@RequestMapping(value="hello",method= {RequestMethod.POST,RequestMethod.GET})
	public String welcome() {
		//直接返回物理视图到视图解析器
		return "hello";
	}
}
