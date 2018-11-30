<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<% 
		String name = "java脚本";
		pageContext.setAttribute("age", 28);
		Object obj = pageContext.findAttribute("age");
		pageContext.getOut().write("通过jspWriter写出去的数据,是写死的是无法解构的!");
		
	%>
	<%=name %> 通过jsp表达式取值<br/>
	${request.name}<br/>${age} ${obj}
	通过默认开启的EL表达式取值.
	通过servlet的转发,访问web-inf下的资源,通过重定向是不能访问的.
</body>
</html>