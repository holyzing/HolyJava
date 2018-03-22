<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>反序列化</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript">
	function sendJsonRequest() {
		var jsonUser=JSON.stringify({"name":"李丹阳","age":"18","date":"1995-08-01","address":"holy`s home"});
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath }/jsonController/toJsonObject.do',
			contentType:'application/json;charset=utf-8'
			/* contentType：指定传递数据的类型 默认为 application/x-www-form-urlencoded */
			data:jsonUser,
			/* dataType：指定返回的数据类型 默认为json格式的数据*/
			success:function(data){
				alert(data);
			}
		})
	}
	function sendPojoRequest() {
		var jsonUser=JSON.stringify({"name":"李丹阳","age":"18","date":"1995-08-01","address":"holy`s home"});
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath }/jsonController/toJsonObject.do',
			/* 不用指定contentType 和 dataType */
			data:'name=ldy&sex=women&age=20',
			success:function(data){
				//返回的是一个json ajax解析为一个js对象
				alert(data.username);  
			}
		})
	}
</script>
</head>
<body>
<input type="button" value="json请求" onclick="sendJsonRequest()">
</body>

</html>