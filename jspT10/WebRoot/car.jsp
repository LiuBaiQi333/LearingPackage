<%@page import="com.liu.bean.Cars"%>
<%@page import="com.liu.bean.Users"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'car.jsp' starting page</title>
    
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
       <h1>
          <%
       Users nowu=(Users)session.getAttribute("nowuser");
       %>
       <%=nowu.getUname() %>
                       的购物车
       </h1>
       <h2>
         <a href="goods.jsp">继续购物</a>
       </h2>
       
       <table border="1" width="80%" style="text-align: center;">
          <tr>
             <th>商品编号</th>
             <th>商品图片</th>
             <th>商品名称</th>
             <th>购买数量</th>
             <th>商品单价</th>
             <th>商品价格</th>
             <th>操作</th>
          </tr> 
          
          <%
            ArrayList<Cars> list= (ArrayList<Cars>)session.getAttribute("mycars");
            for(int i=0;i<list.size();i++){
               Cars c=list.get(i);
           %>
               <tr>
                  <td>
                     <%=c.getGid() %>
                  </td>
                  <td>
                     <img src="<%=c.getGimg() %>" width="88px" height="88px">
                  </td>
                  <td>
                     <%=c.getGname() %>
                  </td>
                  <td>
                    <input type="text" value="<%=c.getGnum() %>" id="gnum" onchange="change()"> 
                  </td>
                  <td>
                     <%=c.getGprice() %>
                     <input type="hidden" value=" <%=c.getGprice() %>" id="gprice">
                  </td>
                  <td>
                     <p id="totalPrice"><%=c.getGnum()*c.getGprice() %></p>
                  </td>
                  <td>
                  </td>
               </tr>
          <%} %>
       </table>
    </center>
  </body>
</html>


<script>
	function change()
	{
		//获取到gnum的text对象
		var gnum=document.getElementById("gnum").value;
		//获取到单价
		var price=document.getElementById("gprice").value;
		
		
		document.getElementById("totalPrice").innerHTML=gnum*price;
		
		 
		
	}
	
</script>

