<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'param1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
	 <form action="param2.jsp" method="POST">
	     姓名：<input type="text" name="Name" size="20" maxlength="20"><br>
	     年龄：<input type="text" name="Age" size="20" maxlength="20"><br><br>
		 爱好：<br>
			<input type="checkbox" name="aihao" value="唱歌" checked>     唱歌<br>
			<input type="checkbox" name="aihao" value="打球" >     打球<br>
			<input type="checkbox" name="aihao" value="登山" >     登山<br>
		   
	<input type="submit" value="传送">
    </form>
  </body>
</html>
