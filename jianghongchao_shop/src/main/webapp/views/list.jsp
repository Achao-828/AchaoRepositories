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
    
    <title>展示页面</title>
    
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
		function pishan(){
			var str = "";
			$(":checkbox:checked").each(function(){
				str += this.value+",";
			})
			if(str != null && str != ''){
				str = str.substring(0,str.length-1);
				window.location.href = "${pageContext.request.contextPath }/delete?ids="+str;
			}else{
				alert("删除选项不能为空！")
			}
		}
		function zeng(){
			window.location.href = "${pageContext.request.contextPath }/views/add.jsp";
		}
		function xiang(id){
			window.location.href = "${pageContext.request.contextPath }/xiang?id="+id;
		}
		function chanpin(){
			$.ajax({
				url : "${pageContext.request.contextPath }/add1",
				dataType : "json",
				type : "post",
				success : function(obj){
					for(var i=0; i<obj.length; i++){
						$("#divs").append("<input type='checkbox' name='ids' value='"+obj[i].pid+"' />"+obj[i].pname);
					}
				}
			})
		}
	</script>
  </head>
  
  <body onload="chanpin()">
    <center>
    	<form action="${pageContext.request.contextPath }/getstore" method="post" />
    		<div id="divs"><spn>销售产品：</spn></div><br/>
    		商店名称：<input type="text" name="sname" value="${store.sname }" />&nbsp;<input type="submit" value="查询" />&nbsp;
    		<input type="button" value="添加" onclick="zeng()" />&nbsp;
    		<input type="button" value="批量删除" onclick="pishan()" />
    		<table border="1px">
    			<tr>
    				<th>选择</th>
    				<th>编号</th>
    				<th>店铺名称</th>
    				<th>创建日期</th>
    				<th>销售产品</th>
    				<th>操作</th>
    			</tr>
    			<c:forEach items="${pageInfo.list }" var="stores">
    				<tr>
    					<td><input type="checkbox" value="${stores.sid }" /></td>
    					<td>${stores.sid }</td>
    					<td>${stores.sname }</td>
    					<td><fmt:formatDate value="${stores.datestart }"/></td>
    					<td>
    						<c:forEach items="${stores.phones }" var="phone">
    							${phone.pname },
    						</c:forEach>
    					</td>
    					<td><input type="button" value="详情" onclick="xiang(${stores.sid })" /></td>
    				</tr>
    			</c:forEach>
    			<tr>
    				<td colspan="6">
    					<a href="${pageContext.request.contextPath }/getstore?page=${pageInfo.prePage}&rows=${pageInfo.pageSize}&sname=${store.sname}"><</a>
    					<span>第${pageInfo.pageNum }页/共${pageInfo.pages }页</span>
    					<a href="${pageContext.request.contextPath }/getstore?page=${pageInfo.nextPage}&rows=${pageInfo.pageSize}&sname=${store.sname}">></a>
    					<div style="float: right;">
    						<span>显示<span style="color: red;">${pageInfo.startRow }</span>到<span style="color: red;">${pageInfo.endRow }</span>,共<span style="color: red;">${pageInfo.size }</span>条记录</span>
    					</div>
    				</td>
    			</tr>
    		</table>
    	</form>
    </center>
  </body>
</html>
