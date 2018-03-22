<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试SpringMVC</title>
</head>
<body>
	<%--这种注释方式会编译到文件中 --%>
	<!-- 
		el表达式和Springmvc没关系,el表达式取值必需是servlet四大作用域
		(servletContext>session>request>pageContext)中有的值,这四
		个域都有setAttribute("",object)方法和getAttribute("")方法 
		el表达式 会自动从四大域中按作用范围从小到达寻找搜寻对应名字的值,其内
		部调用的就是pageContext的findAttribute("")方法;如果要想在页面通
		过el表达式得到值就必需先调用域的setAttribute方法把值设置进去,不需要
		什么配置,直接写el表达式就可以，el表达式原本属于是JSTL这么一个库自定义语言，
		后来由于它的方便性，el表达式已经成为jsp2.0/servlet2.4的标准功能
	-->
	${lover}我爱你！
</body>
</html>