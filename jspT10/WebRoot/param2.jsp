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
    
    <title>My JSP 'param2.jsp' starting page</title>
    
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
    <!-- http://localhost:8080/jsp04/param1.jsp -->
    <%
       String name=request.getParameter("Name");//获取参数值
     %>
     姓名：<%=name %>-${param.Name }
     <c:if test="${param.Name=='admin' }">
       管理员
     </c:if>
     <br>
    年龄：<%=request.getParameter("Age") %>-${param.Age }
    <c:choose>
      <c:when test="${param.Age<18 }">
                 未成年
      </c:when>
      <c:when test="${param.Age<60 }">
                 成年
      </c:when>
      <c:otherwise>
                 老年
      </c:otherwise>
    </c:choose> 
    <br>
    爱好： 
     <%//获取复选框参数值
       String[] aihao=request.getParameterValues("aihao");
       if(aihao!=null&&aihao.length>0){
         for(int i=0;i<aihao.length;i++){
            out.println(aihao[i]+",");
         }
       }
      %>
      <br>
      <c:forEach items="${paramValues.aihao }" var="ah">
         ${ah };
      </c:forEach>
    
  </body>
</html>
