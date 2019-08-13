<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	request.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	function getPage(page) {
		window.location.href="${path}/getStudentList.action?page="+page;
		//把表单中当前页的值修改为接受到的参数
		$("#page").val(page);
		//把 查询表单提交
		$("#myForm").submit();
	
	}



</script>




</head>
<body>
	<table align="center" cellpadding="5">
			<tr>
				<td colspan="5">
					<form action="${path }/getStudentList.action" method="post" id="myForm">
							姓名：<input type="text" name="sname" value="${student.sname }"> 
							班级:<select name="gid">
								<option value="0">全部班级</option>
									<c:forEach  items="${gList }" var="grade">
										<option value="${grade.gid}">${grade.gname}</option>
									</c:forEach>
								</select>
							<input type="hidden" id="page" name="page" value="1">
							<input type="submit" value="查询">
							<a href="${path }/toAdd.action">添加</a>
					</form>
				</td>
			</tr>
			<tr>
				<td>编号</td>
				<td>姓名</td>
				<td>性别</td>
				<td>班级</td>
				<td>课程</td>
				<td>出生日期</td>
				<td>爱好</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${studentList}" var="stu"> 
				<tr>
					<td>${stu.sid}</td>
					<td>${stu.sname}</td>
					<td>${stu.sex == 0?"男":"女"}</td>
					<td>${stu.grade.gname}</td>
					<td>
						<c:forEach items="${stu.courseList}" var="cou">
							${cou.cname},
						</c:forEach>
					</td>
					<td><fmt:formatDate value="${stu.birthday}"/> </td>
					<td>${stu.hobby}</td>
					<td><a href="${path }/toUpdate.action">修改</a></td>
				</tr>
			
			</c:forEach>
			<tr>
				<td colspan="6">
				总记录数：${pageUtil.totalRecord}
				当前页/总页数：${pageUtil.currentPage}/${pageUtil.totalPage}
				<a href="#"onclick="getPage(1)">首页</a>
					<c:if test="${pageUtil.totalPage>1 }">
					<a href="#"onclick="getPage(${pageUtil.upPage})">上一页</a>
					<a href="#"onclick="getPage(${pageUtil.nextPage})">下一页</a>
					<a href="#"onclick="getPage(${pageUtil.totalPage })">尾页</a>
					</c:if>
				</td>
			</tr>
		
	
	</table>
	
	
	
	</body>
</html>