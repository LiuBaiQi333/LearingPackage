<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'text.jsp' starting page</title>
    
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
    <div id="div1">
<p id="p1">这是一个段落。</p>
<p id="p2">这是另一个段落。</p>
<input type="button" onclick="myfun()" value="tianjia">
</div>

  </body>
</html>
<script>
function myfun(){
	var para = document.createElement("p");
	var node = document.createTextNode("这是新文本。");
	para.appendChild(node);
	
	var element = document.getElementById("div1");
	var child = document.getElementById("p1");
	element.insertBefore(para, child);
}

</script>
