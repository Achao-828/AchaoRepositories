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
    
    <title>新增页面</title>
    
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
		function cha(){
			$.ajax({
				url : "${pageContext.request.contextPath }/add1",
				dataType : "json",
				type : "post",
				success : function(obj){
					for(var i=0; i<obj.length; i++){
						$("#div1").append("<input type='checkbox' name='ids' value='"+obj[i].pid+"' />"+obj[i].pname);
					}
				}
			})
		}
		function fan(){
			window.history.back();
		}
	</script>
	
  </head>
  
  <body onload="cha()">
    <center>
    	<form action="${pageContext.request.contextPath }/add">
    		<h2>新增页面</h2>
    		编号：<input type="text" name="sid" /><br/>
    		店铺名称：<input type="text" name="sname" /><br/>
    		创建日期：<input type="date" name="datestart" /><br/>
    		销售商品 ：<div id="div1">
    			
    		</div>
    		<input type="submit" value="确认新增" />&nbsp;<input type="button" value="关闭" onclick="fan()" />
    	</form>
    </center>
  </body>
</html>
