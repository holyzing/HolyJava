package com.holy.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.holy.domain.User;

/**
 * MVc通过 命令模式 实现对请求参数的封装
 * 
 * @author hadoop
 * 
 *         通过命令模式实现参数封装的实现过程比较复杂
 *
 */
public class CommandController extends AbstractCommandController {

	public CommandController() {
		this.setCommandClass(User.class);
	}

	@Override
	protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		User user = (User) command;
		System.out.println(user);
		// 回显
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.setViewName("index");
		return mv;
	}

	/**
	 * 相当于servlet 的init()方法 ，在参数绑定前，自定义类型绑定
	 */
	@Override
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		String date = request.getParameter("date");
		if (date.contains("/")) {// '/'为系统的默认实现
			binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy/MM/dd"), true));
		} else if (date.contains("-")) {
			binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		}
	}
}
