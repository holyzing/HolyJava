package com.holy.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.holy.domain.User;

@Controller
public class MultiViewController {
	@RequestMapping("SpringWithJDKVersionProblem")
	public String SpringWithJDKVersionProblem() {
		return "index";
	}
	/**
	 * MVC 有一个 规定 当以.json/.xml结尾的请求uri 请求时,都会以 多视图支持 的方式返回请求
	 * 注意 pojo的序列化 和 对多视图的支持 的理解与区分
	 * 	四个HandlerMapping
	 * 		BeanNameUrl
	 *      SimpleUrl
	 *      ControllerClassName
	 *      RequestMapping
	 *  三个HandlerAdapter
	 *  	SimpleController
	 *  	HttpRequest
	 *  	RequestMapping
	 *  三种ViewResolve    当无法确定时就以InternalResourceViewResolver，解析为去除后缀的资源.jsp
	 *  				  比如发送请求 /multiview.do则会报错 404 not found multiview.jsp
		Forwarding to resource [/WEB-INF/jsp/multiview.jsp] in InternalResourceView 'multiview'
	 *  	return ""   : InternalResourceViewResolver 
	 *  	@requestBody: 序列化
	 *      .xml或.json	: ContentNegotiatingViewResolver
		 	  				 	MappingJackson2JsonView
		 	  				 	MarshallingView
	 * @return
	 */
	@RequestMapping("/multiview")
	public User multiView() {  
		/*
		 * json视图 与 mvc：annotation-driven 都依赖Jackson 
		 */
		User user = new User();
		user.setId(1);
		user.setName("李京");
		user.setAge(22);
		user.setDate(new Date());
		user.setAddress("中国河北省");
		return user;
	}
	@RequestMapping("/returnJson")
	public @ResponseBody User returnJson() {
		//序列化时不能为User注解 @XmlRootElement 否则视图最后会选择xml（如果配置了的话）
		User user = new User();
		user.setId(1);
		user.setName("李京");
		user.setAge(22);
		user.setDate(new Date());
		user.setAddress("中国河北省");
		return user;
	}
}