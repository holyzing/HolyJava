package com.holy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 得通过一个拦截器 转发到这里 ，请求WEB-INF下的 .jsp 
 * @author hadoop
 *
 */
public class JumpController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		StringBuffer requestURL = request.getRequestURL();
		String substring = requestURL.substring(//
				requestURL.lastIndexOf("/"), requestURL.lastIndexOf("."));
		System.out.println(requestURL+"----"+substring);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("add");
		return mv;
	}
}
