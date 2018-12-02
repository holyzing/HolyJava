package com.holy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * web3.0֧��servlet��ע��. ������ͨ��ע������������.
 * java8�Ժ�javax�е�web��ض����Ƴ�,ͨ��tomcat����
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
		System.out.println("����ͨ��ע��ӳ���servlet!");
		req.setAttribute("name", "���");
		req.getRequestDispatcher("/WEB-INF/ReHelloJsp.jsp").forward(req, resp);
	}
}
