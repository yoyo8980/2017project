<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	
</style>
</head>
<body>
<h2>학생관리</h2>
	<h3>수강중인 학생</h3>
	<h4>반선택하세요</h4>
	<div>
		<%-- <lable for="lecid">반선택</lable>
		<select name="lecid">
			<c:forEach items=${lecid } var="lecid">
				<option>${lecname }</option>
			</c:forEach>
		</select> --%>
		<c:forEach items="${list4 }" var="bean">
			<tr>
				<td>${lecid }</td>
				<td>${lecName }</td>
				<td>${room }</td>
			</tr>
		</c:forEach>
	</div>
	<br/>
	<a href="stuadd.do">학생추가</a>
	
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>생일</th>
				<th>전화번호</th>
				<th>학생이메일</th>
				<th>반</th>
			</tr>
		
		<c:forEach items="${list }" var="bean">
			<tr>
				<td>${bean.sId }</td>
				<td>${bean.sName }</td>
				<td>${bean.birth }</td>
				<td>${bean.phone }</td>
				<td>${bean.email }</td>
				<td>${bean.regclass }</td>
			</tr>
		</c:forEach>
		</table>
	
	
</body>
</html>