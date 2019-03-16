<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>与WebSockets不同，服务器发送的事件是单向的; 也就是说，数据消息是从一个方向传递的，从服务器传送到客户端（例如用户的Web浏览器）。当没有必要以消息形式从客户端向服务器发送数据时，这使它们成为一个很好的选择。例如，EventSource处理诸如社交媒体状态更新，
新闻订阅或将数据传递到客户端存储机制（如IndexedDB或Web存储）之类的内容是一种有用的方法
</div>
<div id="msgFromSsePush"></div>
<script type="text/javascript">
	if(typeof(window.EventSource)!=="undefined"){
		var source = new EventSource('push');
		s='';
		/* source.onmessage=function(e){
			s+=e.data+"</br>";
			document.getElementById("msgFromSsePush").innerHTML=s;
		}; */
		source.addEventListener("message",function(e){
			s+=e.data+"</br>";
			document.getElementById("msgFromSsePush").innerHTML=s;
		});
		
		source.addEventListener("open",function(e){
			console.log("连接打开");
		},false);
		
		source.addEventListener("error",function(e){
			if(e.readyState == EventSource.CLOSED){
				console.log("连接关闭");
			}else{
				console.log(e);
			}
		},false);
		
	}else{
		console.log("您的浏览器不支持SSE");
	}
</script>
</body>
</html>