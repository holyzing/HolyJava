<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- 
	<c:set var="picPath" value="http://127.0.0.1:8003/ssmImage19"></c:set>
-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询用户列表</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/user/deleteByIds.do"
		method="post">
		查询条件：
		<table width="100%" border=1>
			<tr>
				<td><input type="submit" value="查询" /></td>
				<td><input type="submit" value="批量删除" /></td>
			</tr>
		</table>
		商品列表：
		<table width="100%" border=1>
			<tr>
				<td>ID</td>
				<td>用户名称</td>
				<td>用户生日</td>
				<td>用户性别</td>
				<td>用户地址</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${userList}" var="user">
				<tr>
					<td><input type="checkbox" name="id" value="${user.id }">
					</td>
					<td>${user.username }</td>
		<%--
		td img id='imgSize1ImgSrc' src='${picPath }${user.pic }' height="100" width="100" td
			为什么  <!--  --> 在jsp中无法注释
		--%>
		
					 
					<td><fmt:formatDate value="${user.birthday}"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td>${user.sex }</td>
					<td>${user.address }</td>
					<td><a
						href="${pageContext.request.contextPath }/user/edit.do?id=${user.id}">修改</a>
						<a
						href="${pageContext.request.contextPath }/user/deleteByID.do?id=${user.id}">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>

</html>