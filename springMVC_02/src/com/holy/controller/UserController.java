package com.holy.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.holy.entity.User;
import com.holy.service.OrderService;
import com.holy.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	/**
	 * Resource 注解在jdk1.6以上支持
	 */
	@Resource 
	UserService userService;
	//TODO 是怎么选择实现类的，实现类中有同名方法，spring又是如何创建的?
	@Autowired   
	private OrderService orderService;
	
	@RequestMapping("list")
	public String findAll(Model model){
		model.addAttribute("userList", userService.findAll());
		return "userList";
	}
	
	@RequestMapping("/editBefor")
	public String editUserBefor(int id,Model model) {
		User user = userService.getUser(id);
		model.addAttribute("user", user);
		return "editUser";
	}
}
