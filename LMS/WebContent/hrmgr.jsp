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

	 var furuitSrc= "";

	 $(document).on("click",".a",function(){
		 var furuitSrc= $(".a").attr('value');
			alert(furuitSrc); 
	 });

	$.ajax({
		type:"POST", 
		url:"/LMS/hrmgr.do",

		data:{furuitSrc:furuitSrc}, 
		async:false, 
		success: function(data){						
		}
	}); 
}); 
</script>
</head>
<body>
	<a class="a" href="javascript:;" id="add">add</a>
	<a class="a" href="javascript:;" id="edit">edit</a>
	<a class="a" href="javascript:;" id="delete">delete</a>
		
</body>
</html>