<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<lable for="lecid">강의코드</lable>
		<input type="text" name="lecid" id="lecid" value=${requestScope.nextid }>
	</div>
	<div>
		<lable for="lecname">강의명</lable>
		<input type="text" name="lecname" id="lecname"/>
	</div>
	<div>
		<lable for="tid">강사코드</lable>
		<select name="tid">
			<c:forEach items=${teacherid } var="tid">
				<option>${tid }</option>
			</c:forEach>
		</select>
	</div>
	<div>
		<lable for="tname">강사명</lable>
		<select name="tname">
			<c:forEach items=${teachername } var="tname">
				<option>${tname }</option>
			</c:forEach>
		</select>
	</div>			
	<div>
		<lable for="room">강의장</lable>
		<select></select>
	</div>
	<div>
		<lable for="starting">개강</lable>
		<input type="month" name="starting" id="starting">
	</div>
	<div>
		<lable for="ending">종강</lable>
		<input type="month" name="ending" id="ending">
	</div>
	<div>
		<lable for="intro">강의소개</lable>
		<input type="text" name="intro" id="intro"/>
	</div>
	<div>
		<button>전송</button>
	</div>			
</form>
</body>
</html>