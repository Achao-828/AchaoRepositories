<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查看页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript">
		function fan(){
			window.history.back();
		}
	</script>
	
  </head>
  
  <body>
    <center>
    	<form action="">
    		<h2>查询店铺</h2>
    		<input type="button" value="返回上一级" onclick="fan()" /><br/>
    		编号：<input type="text" value="${store.sid }" /><br/>
    		店铺名称：<input type="text" value="${store.sname }" /><br/>
    		创建日期：<input type="text" value="<fmt:formatDate value="${store.datestart }"/>" /><br/>
    		销售商品 ：<div id="div1">
    			<c:forEach items="${phones }" var="ph">
    				<input type="checkbox" value="${ph.pid }" <c:if test="${ph.pname.contains('+') }">checked</c:if> />
    				<c:if test="${ph.pname.contains('+') }">${ph.pname.substring(1) }</c:if>
    				<c:if test="${!ph.pname.contains('+') }">${ph.pname }</c:if>
    			</c:forEach>
    		</div>
    	</form>
    </center>
  </body>
</html>
