<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
$(function(){

	 var root= "";

	$(document).on("click",".a",function(){
		 var root= $(this).attr('value');
		
		 $.ajax({
				'type':"GET", 
				'url':"./hrmgr.do",
				'data':{root:root}, 
				'error' : function() {
					alert("에러");
				},
				'async':true, 
				'success': function(){
					window.location.replace("hrmgr.do");
				}
			}); 
	 });
	
	
}); 
</script>
</head>
<body>
	<a class="a" href="javascript:;" value="add">입력</a>
	<a class="a" href="javascript:;" value="edit">수정</a>
	<a class="a" href="javascript:;" value="delete">삭제</a>
		
</body>
</html>