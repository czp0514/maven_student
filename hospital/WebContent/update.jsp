<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%request.setAttribute("path", request.getContextPath()); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	//史恺民到此一游
	<form action="${path }/hospital?method=add" method="post" style="text-align: center;">
		<table align="center" cellpadding="5" border="2" width="500px">
			<tr>
				<td colspan="2"><h3>添加医院信息</h3></td>
			</tr>

			<tr>
				<td>医院名称</td>
				<td><input type="text" name="hospital_name"></td>
			</tr>
			<tr>
				<td>院长名称</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>院长电话</td>
				<td><input type="text" name="tel"></td>
			</tr>
			<tr>
				<td>医院成立时期</td>
				<td><input type="date" name="datea"></td>
			</tr>
			<tr>
				<td>医院简介</td>
				<td><input type="text" name="content"></td>
			</tr>
			<tr>
				<td>医院等级</td>
				<td><select name="tid">
						<c:forEach items="${tlist }" var="type">
							<option value="${type.tid }" >${type.tname }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>操作</td>
				<td><input type="submit" value="确认添加"></td>
			</tr>
		</table>
	</form>
		
</body>
</html>