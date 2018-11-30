package com.holy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * web3.0支持servlet的注解. 容器会通过注解解析类的作用.
 * java8以后将javax中的web相关都已移除,通过tomcat引入
 * @author holy
 *
 */

@WebServlet("/helloWebServlet")
public class HelloWebServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("请求到通过注解映射的servlet!");
		req.setAttribute("name", "李丹阳");
		req.getRequestDispatcher("/WEB-INF/ReHelloJsp.jsp").forward(req, resp);
	}
}
