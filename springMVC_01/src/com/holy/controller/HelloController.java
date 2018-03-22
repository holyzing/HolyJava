package com.holy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
/**
 * MVC是对servlet的高度封装
 * @author hadoop
 *
 */
public class HelloController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("--------前拦截器执行完毕-------");
		System.out.println("执行controller");
		System.out.println("--------后拦截器执行开始-------");
		ModelAndView mv = new ModelAndView();
		mv.addObject("lover", "李丹阳");
		/*
		 * 1-没有指定视图解析器的情况下，直接指定跳转的物理视图,所谓设置view就是将请求转发到指定的资源
		 *   当资源不存在时会报错404  /springMVC_01/fgindex.jsp Not Found url地址没变
		 * 2-当配置了视图解析器ViewResolver则必须按照配置连接字符串，形成uri
		 */
		//mv.setViewName("/index.jsp");
		mv.setViewName("index");
		return mv;
	}
	

}
