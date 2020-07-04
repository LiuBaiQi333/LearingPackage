<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Adaptive.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta content="width=device-width, height=device-height, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	
	@media screen and (min-width:640px){
		#first{
		width:100%;
		height:100%;
		background-color: black;
		background-image: url(images/001.jpg);
		background-size: cover;
		}
		span{
　　width: 70px;
　　height: 30px;
　　display: inline-block;
　　text-align-last: justify;
　　-webkit-text-align-last:justify;
　　-moz-text-align-last:justify;
}
		.element{ 
			color:#ff0000;font-size:32px; 
		} //屏幕宽度小于640px时显示红色字体
	}
	@media screen and (max-width:480px){
		#first{
		width:100%;
		height:100%;
		background-color: black;
		background-image: url(images/002.jpg);
		background-size: cover;
		}
		.element{ 
			color:#0000ff;font-size:16px; 
		} //屏幕宽度小于480px时显示蓝色字体	
	}
	</style>
  </head>
  
  <body>
	<div id="first">
		<div class="login">
			<form action="login1" method="post">
			<p>
			<span>Login-number</span>
			<input type="text" name="IDCARD">
			</p>
			<p>
			<span> PASSWORD</span>
			<input type="password" name="PassWord">
			</p>
				<input type="button" value="注册" class="">
				<input type="button" value="登入" class="">
			</form>
		</div>
	</div>
  </body>
</html>
