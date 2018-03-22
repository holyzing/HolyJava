package com.holy.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.holy.domain.User;
import com.holy.domain.UserCustom;

@Controller
@RequestMapping("/user")
public class UserController {
	// 同时指定GET请求方式和POST请求方式均可
	@RequestMapping(value = "/hello.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String hello() {
		return "index";
	}
	// 请求 toAdd.do 返回物理视图
	@RequestMapping("toAdd")
	public String toAdd() {

		return "add";
	}
	// 接收int类型参数 ，name="id"
	@RequestMapping("recieveInt")
	public String recieveInt(Integer id) {
		System.out.println(id);
		return "success";

	}
	// 接收字符类型参数 name="username"
	@RequestMapping("recieveStr")
	public String recieveStr(String username) {

		System.out.println(username);
		return "success";
	}
	// 接收数组类型参数 name=ids 参数要求name一致且类型为简单类型
	@RequestMapping("recieveArray")
	public String recieveArray(Integer[] ids) {
		System.out.println(ids);
		return "success";
	}
	// 接收参数封装User对象 name="user的属性"
	@RequestMapping("recieveUser")
	public String recieveUser(User user) {
		System.out.println(user);
		return "success";
	}
	// 接收包装类型参数 name=user.age
	@RequestMapping("recieveUserCustom")
	public String recieveUserCustom(UserCustom userCustom) {
		System.out.println(userCustom);
		return "success";
	}
	// 接收集合类型参数 name=list[0].age,name=list[0].date
	@RequestMapping("recieveList")
	public String recieveList(UserCustom userCustom) {
		System.out.println(userCustom);
		return "success";
	}
	// 接收map类型参数  name=map['date'] ,name=map['age']
	@RequestMapping("recieveMap")
	public String recieveMap(UserCustom userCustom) {
		System.out.println(userCustom);
		return "success";
	}
	//修改回显 通过jstl标签遍历集合即可 items="${userList }" 
	@RequestMapping("list")
	public String list(Model model) {
		// model 相当于application域对象
		List<User> userList = new ArrayList<User>();
		User user1 = new User();
		user1.setId(1);
		user1.setAge(1);
		user1.setName("张山峰");
		user1.setAddress("武当山");
		user1.setDate(new Date());

		User user2 = new User();
		user2.setId(2);
		user2.setAge(2);
		user2.setName("张山峰222");
		user2.setAddress("武当山222");
		user2.setDate(new Date());

		User user3 = new User();
		user3.setId(3);
		user3.setAge(3);
		user3.setName("张山峰333");
		user3.setAddress("武当山333");
		user3.setDate(new Date());

		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		model.addAttribute("userList", userList);
		return "list";
	}
	//参数回显 value="${user.username }"   1.do
	@RequestMapping("updateByID/{id}")
	public String updateByID(@PathVariable Integer id, Model model) {
		User user1 = new User();
		user1.setId(id);
		user1.setAge(1);
		user1.setName("张山峰");
		user1.setAddress("武当山");
		user1.setDate(new Date());
		model.addAttribute("user", user1);
		return "edit";
	}
	// 返回的物理视图指定为转发方式
	@RequestMapping("forward")
	public String forward() {
		return "forward:/items/list.do";
	}
	// 返回的物理视图指定为重定向方式
	@RequestMapping("redirect")
	public String redirect() {
		return "redirect:/items/list.do";
	}
	
	@RequestMapping("testCustomParamter")
	public String customParamter(@RequestParam(defaultValue="wcy",value="ldy",required=true)String para) {
		return "redirect:list.do";
	}
	/**SpringMVC对参数注入：为每一个参数的引用类型 创建一个对应类型的对象去引用，这个对象是局部对象！
	 *Springmvc默认支持以下类型的直接注入：
			HttpSession，HttpRequstServlet，Model等等。 
	 *	   -----------------------------------------------------
	 * url模板映射 restful软件架构设计模式：请求更安全，更简洁，便于搜索收录
	 *  Web.xml拦截方式：servlet可以拦截目录,拦截rest下的 url-pattern=/rest/*
	 *  通过这个拦截可以实现无扩展名的请求映射，
	 *  即真正的 无扩展名的，无参数拼接的 restful风格的get请求
	 * 	请求:rest/user/findUserById/${user.id}.do
	 *  映射： @RequestMapping("updateByID/{id}")//{}:匹配接受页面Url路径参数
	 *  	  @PathVariable Integer id          //{}里面参数注入后面参数里面
	 *  
	 *  -----------------------------------------------------
	 *  转发: 转发到类内方法 forward:list.do 或者 /user/list.do
	 *       转发到类外方法 /items/show.do
	 *重定向： 重定向到本类 redirect:list.do 或者 /user/list.do
	 *       重定向到类外：redirect：/items/show.do      
	 */
}