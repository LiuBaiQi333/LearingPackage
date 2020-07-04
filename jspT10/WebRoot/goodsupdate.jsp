<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'goodsupdate.jsp' starting page</title>
    
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
    <center>
      <h1>商品修改</h1>
      <form action="GoodsUpdate" method="post" enctype="multipart/form-data">
            商品名称：<input type="text" name="gname" value="<%=request.getParameter("gname")%>">
            <br>
            商品价格：<input type="text" name="gprice" value="<%=request.getParameter("gprice")%>">
            <br>
            库存数量：<input type="text" name="gstock" value="<%=request.getParameter("gstock")%>">
            <br>
             商品图片：<input type="file" name="gimg1" >
            <br>
            <input type="text" value="<%=request.getParameter("gimg")%>">
            <!-- 其他数据就使用隐藏域 -->
            <input type="hidden" name="gid" value="<%=request.getParameter("gid")%>">
            <input type="hidden" name="gimg" value="<%=request.getParameter("gimg")%>">
            <input type="hidden" name="gnum" value="<%=request.getParameter("gnum")%>">
            <input type="submit" value="提交">
      </form>
    </center>
  </body>
</html>
