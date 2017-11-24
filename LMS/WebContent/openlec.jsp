<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>강좌 개설</title>
</head>
<body>
<h1>강좌 개설</h1>
<form action="openlec.do" method="post">
	<div>
		<label for="lecid">강의코드</label>
		<input type="text" name="lecid" id="lecid" value=${requestScope.nextid } readonly="readonly">
	</div>
	<div>
		<label for="lecname">강의명</label>
		<input type="text" name="lecname" id="lecname"/>
	</div>
	<div>
		<label for="tid">강사코드</label>
		<select name="tid">
			<c:forEach items="${tlist }" var="tIDlist">
				<option value=${tIDlist.tid }>${tIDlist.tid }</option>
			</c:forEach>
		</select>
	</div>	
	<div>
		<label for="tname">강사명</label>
		<select name="tname">
			<c:forEach items="${tlist }" var="tNAMElist">
				<option value="${tNAMElist.tname }">${tNAMElist.tname }</option>
			</c:forEach>
		</select>
	</div>			
	<div>
		<label for="room">강의장</label>
		<select name="rid">
			<c:forEach items="${room }" var="rid">
				<option value=${rid }>${rid }</option>
			</c:forEach>
		</select>
	</div>
	<div>
		<label for="starting">개강</label>
		<input type="month" name="starting" id="starting">
	</div>
	<div>
		<label for="ending">종강</label>
		<input type="month" name="ending" id="ending">
	</div>
	<div>
		<label for="intro">강의소개</label>
		<input type="textarea" name="intro" id="intro"/>
	</div>
	<div>
		<button>전송</button>
	</div>			
</form>
</body>
</html>