package com.holy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

/**
 * 接近于servlet开发
 * @author hadoop
 *
 */
public class RequestController implements HttpRequestHandler{

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//回归本源
		request.setAttribute("lover", "李丹阳2");
		//转发
		request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
	}

}
