<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="picPath" value="http://127.0.0.1:8003/ssmImage19"></c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户信息</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.form.js"></script>
<script type="text/javascript">
	function submitImgSize1Upload() {

		var option = {
			type : 'POST',
			url : '${pageContext.request.contextPath }/upload/uploadPic.do',
			// 预期服务器返回的数据格式  如果为json格式，则自动解析为js对象
			dataType : 'text',
			//传递给服务器的数据
			data : {
				fileName : 'imgSize1File'
			},
			success : function(data) {

				//把json格式的字符串转换成json对象
				var jsonObj = $.parseJSON(data);

				//返回服务器图片路径，把图片路径设置给img标签
				$("#imgSize1ImgSrc").attr("src", jsonObj.fullPath);
				//数据库保存相对路径
				$("#imgSize1").val(jsonObj.relativePath);
			}

		};

		$("#itemForm").ajaxSubmit(option);

	}
</script>

</head>
<body>
	<!--
	enctype 属性规定在发送到服务器之前应该如何对表单数据进行编码。
		application/x-www-form-urlencoded 	在发送前编码所有字符（默认）
		multipart/form-data   不对字符编码。在使用包含文件上传控件的表单时，必须使用该值。
	    text/plain 	          空格转换为 "+" 加号，但不对特殊字符编码。 
	    
	类型为Date的参数绑定必须为 yyyy/MM/dd 这种格式，特别是 yyyy-MM-dd是不行的，至少spring4是不行的
	-->
	<form id="itemForm"  enctype="multipart/form-data"
		action="${pageContext.request.contextPath }/items/saveOrUpdate.do" 
		method="post">
		<input type="hidden" name="id" value="${item.id }" /> 修改商品信息：
		<table width="100%" border=1>
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="name" value="${item.name }" /></td>
			</tr>
			<tr>
				<td>商品价格</td>
				<td><input type="text" name="price" value="${item.price }" /></td>
			</tr>
			<tr>
				<td>商品生产日期</td>
				<td><input type="text" name="createtime"
					value='<fmt:formatDate value='${item.createtime}' pattern='yyyy/MM/dd HH:mm:ss'/>' /></td>
			</tr>
			<tr>
				<td>商品图片</td>
				<td>
					<p>
						<label></label> 
						<img id='imgSize1ImgSrc' src='${picPath }${item.pic }' height="100" width="100" />
						<input type='file' id='imgSize1File' name='imgSize1File' class="file" onchange='submitImgSize1Upload()' />
						<span class="pos" id="imgSize1FileSpan">请上传图片的大小不超过3MB</span>
						<input type='hidden' id='imgSize1' name='pic' value='' reg="^.+$" tip="亲！您忘记上传图片了。" />
					</p>
				</td>
			</tr>
			<tr>
				<td>商品简介</td>
				<td><textarea rows="3" cols="30" name="detail">${item.detail }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交" />
				</td>
			</tr>
		</table>

	</form>
</body>

</html>