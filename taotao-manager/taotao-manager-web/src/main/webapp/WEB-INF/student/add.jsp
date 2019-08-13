<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%
 	request.setAttribute("path", request.getContextPath());
%>
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="${path }/save.action" method="post">
			<table align="center" cellpadding="5">
				<tr>
					<td>学生姓名：</td>
					<td><input type="text"  name="sname"> </td>
				</tr>
				<tr>
					<td>性别：</td>
					<td><input type="radio" name="sex" value="0" checked="checked">男 &nbsp;&nbsp;&nbsp;
					<input type="radio" name="sex" value="1">女
					</td>
				</tr>
				<tr>
					<td>出生日期：</td>
					<td><input type="date"  name="birthday"> </td>
				</tr>
				<tr>
					<td>爱好：</td>
					<td><input type="text"  name="hobby"> </td>
				</tr>
				<tr>
					<td>班级：</td>
					<td>
						<select name="gid">
							<c:forEach  items="${gList }" var="grade">
							<option value="${grade.gid}">${grade.gname}</option>
							
							
							</c:forEach>
						</select>
					 </td>
				</tr>
				<tr>
					<td>课程：</td>
					<td>
					<!--varStatus="status"  1:index 位置索引  0开始 2.count 计数 1 开始 -->
						<c:forEach  items="${cList }" var="course" varStatus="status">
							<input type="checkbox" name="courseList[${status.index }].cid" value="${course.cid}">${course.cname}&nbsp;&nbsp;&nbsp;
							</c:forEach>
					
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="添加"></td>
				</tr>
		
		
			</table>
		</form>
		
</body>
</html>