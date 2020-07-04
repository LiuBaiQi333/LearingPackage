<%@page import="com.liu.bean.Users"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'goods.jsp' starting page</title>
    
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
    <!-- 快捷键：alt+/ -->
    <%
      //模拟一个登陆的用户对象
      Users u=new Users(2,"猪八戒","123",12);
      //把该用户对象存入session,其他页面都可以取出
      session.setAttribute("nowuser", u);
     %>
  
    <center>
      <h1>
             欢迎，
      <%
       Users nowu=(Users)session.getAttribute("nowuser");
       %>
       <%=nowu.getUname() %>
               ，来到淘猫购物商城！
      </h1>
      <a href="GoodsSelect">进入商品管理</a>
      <br>
      <a href="GoodsSelectPage">进入商品管理-分页</a>
      <div>
         <div style="width: 200px;float: left;">
            <img src="images/1.jpg" width="188px" height="188px">
            <br>
            <h3 style="color: red">￥88.90</h3>
                               波司登羽绒服
            <br>
            <a href="CarAdd?gid=1&gname=波司登羽绒服&gprice=88.90&gimg=images/1.jpg&gnum=1">加入购物车</a>
         </div>
         
         <div style="width: 200px;float: left;">
            <img src="images/2.jpg" width="188px" height="188px">
            <br>
            <h3 style="color: red">￥299.99</h3>
                               七匹狼皮夹克
            <br>
            <a href="CarAdd?gid=2&gname=七匹狼皮夹克&gprice=299.99&gimg=images/2.jpg&gnum=1">加入购物车</a>
         </div>
         
         <div style="width: 200px;float: left;">
            <img src="images/3.jpg" width="188px" height="188px">
            <br>
            <h3 style="color: red">￥536.00</h3>
                               冲锋衣
            <br>
            <a href="CarAdd?gid=3&gname=冲锋衣&gprice=536.00&gimg=images/3.jpg&gnum=1">加入购物车</a>
         </div>
         
         <div style="width: 200px;float: left;">
            <img src="images/1.jpg" width="188px" height="188px">
            <br>
            <h3 style="color: red">￥469.00</h3>
                               李宁运动服
            <br>
            <a href="CarAdd?gid=4&gname=李宁运动服&gprice=469.00&gimg=images/4.jpg&gnum=1">加入购物车</a>
         </div>
         
         <div style="width: 200px;float: left;">
            <img src="images/5.jpg" width="188px" height="188px">
            <br>
            <h3 style="color: red">￥999.99</h3>
                               毛呢大衣
            <br>
            <a href="CarAdd?gid=5&gname=毛呢大衣&gprice=999.99&gimg=images/5.jpg&gnum=1">加入购物车</a>
         </div>
      </div>
    </center>
  </body>
  </body>
</html>
