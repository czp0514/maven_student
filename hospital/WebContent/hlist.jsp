<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	request.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function getPage(page){
	window.location.href="${path}/hospital?method=getHospitalList&page="+page;
}
</script>
</head>
<body>
	<table align="center" cellpadding="5">
		<tr>
			<td colspan="6">
				<form action="" method="post" id="myForm">
					<input type="text" name="keyWord" value="">
					<input type="hidden" id="page" name="page" value="1"> 
					<input type="submit" value="查询">
					<a href="${path }/hospital?method=toAdd">添加</a>
				</form>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>编号</td>
			<td>医院名称</td>
			<td>院长</td>
			<td>成立时间</td>
			<td>医院等级</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${hlist }" var="hospital">
			<tr>
				<td>
					<input type="checkbox" name="id" value="${hospital.id }">
				</td>
				<td>${hospital.id }</td>
				<td>${hospital.hospital_name }</td>
				<td>${hospital.name }</td>
				<td><fmt:formatDate value="${hospital.datea }"/></td>
				<td>${hospital.type.tname }</td>
				<td>
					<a href="${path }/hospital?method=toUpdate&id=${hospital.id }">修改</a>&nbsp;&nbsp;&nbsp;
					<a href="${path }/hospital?method=delete&id=${hospital.id }">删除</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6">
			总记录数：${pageUtil.totalRows }当前页/总页数：${pageUtil.currentPage }/${pageUtil.totalPage }
			<a href="#" onclick="getPage(1)">首页</a>
			<a href="#" onclick="getPage(${pageUtil.prevPage })">上一页</a>
			<c:if test="${pageUtil.totalPage > 1 }">
				<a href="#" onclick="getPage(${pageUtil.nextPage })">下一页</a>
				<a href="#" onclick="getPage(${pageUtil.totalPage })">尾页</a>
			</c:if>
			</td>
		</tr>
</table>
</body>
</html>