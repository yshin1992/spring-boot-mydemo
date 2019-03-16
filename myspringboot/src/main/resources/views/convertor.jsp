<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="assets/js/jquery-1.7.2.min.js"></script>
</head>
<body>

<input type="button" onclick="req();" value="请求"/>
<div id="result"></div>

<script type="text/javascript">
function req(){
	$.ajax({
		url:"doConvert",
		data:"1-wws",
		type:"POST",
		contentType:"application/www-ysh",
		success:function(data){
			$("#result").html(data);
		}
		
	});	
}
</script>
</body>
</html>