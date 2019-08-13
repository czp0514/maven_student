<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	request.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table cellpadding="0" cellspacing="0" border="1px">
		<tr align="center">
			<td>学生编号</td>
			<td>学生姓名</td>
			<td>学生性别</td>
			<td>学生爱好</td>
			<td>学生生日</td>
			<td>学生班级</td>
			<td>学生专业</td>
			<td>操作</td>
		</tr>
		<c:if test="${!empty page.pageNum }">
		<c:forEach items="${page.list }" var="s">
			<tr>
				<td>${s.sid }</td>
				<td>${s.sname }</td>
				<td>${s.sex }</td>
				<td>${s.hobby }</td>
				<td>${s.birthday }</td>
				<td>${s.grade.gname }</td>
				<td>${s.course.cname }</td>
				<td></td>
			</tr>
		</c:forEach>
		</c:if>
		
		
		<c:if test="${empty page.pageNum }">
		<c:forEach items="${slist }" var="s">
			<tr>
				<td>${s.sid }</td>
				<td>${s.sname }</td>
				<td>${s.sex }</td>
				<td>${s.hobby }</td>
				<td>${s.birthday }</td>
				<td>${s.grade.gname }</td>
				<td>${s.course.cname }</td>
				<td></td>
			</tr>
		</c:forEach>
		</c:if>
		共${page.pageNum }条,当前第${page.pageIndex }页
		<a href="findByPage.action?pageIndex=1">首页</a>
		<a href="findByPage.action?pageIndex=${page.pageIndex>1?page.pageIndex-1:1 }">上一页</a>
		<c:forEach begin="1" end="${page.pageCount }" var="i">
			<a href="findByPage.action?pageIndex=${i}">${i}</a>
		</c:forEach>
		<a href="findByPage.action?pageIndex=${page.pageIndex<page.pageCount?page.pageIndex+1:page.pageCount}">下一页</a>
		<a href="findByPage.action?pageIndex=${page.pageCount }">尾页</a>
</body>
</html>