<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>삭제페이지</h1>
	<div>
		<form action="hrmgrdelete.do" method="get">
			<p>ID:<input type="text" name="hrid"/></p>
			<p>NAME:<input type="text" name="hrname"/></p>
			<p>TEAM<input type="text" name="hrteam"/></p>
			<input type="submit" value="입력" >
			<input type="submit" value="취소">
		</form>
	</div>
</body>
</html>