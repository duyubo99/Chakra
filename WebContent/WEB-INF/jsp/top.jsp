<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<head>
<meta http-equiv="Content-Type" content="text/jsp; charset=utf-8" /> 
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/style.css">
<script type="text/javascript" src="<%=basePath %>jquery-easyui-1.6.7/jquery.min.js"></script>
</head>
<body style="background: url(<%=basePath %>images/topbg.gif) repeat-x;">
	<div class="topleft">
		<a href="../main" target="_parent"><img src="<%=basePath %>images/logo.png"
			title="系统首页" /></a>
	</div>
	<!--     <ul class="nav"> -->
	<!--     <li><a href="default.html" target="rightFrame" class="selected"><img src="images/icon01.png" title="工作台" /><h2>工作台</h2></a></li> -->
	<!--     <li><a href="imgtable.html" target="rightFrame"><img src="images/icon02.png" title="模型管理" /><h2>模型管理</h2></a></li> -->
	<!--     <li><a href="imglist.html"  target="rightFrame"><img src="images/icon03.png" title="模块设计" /><h2>模块设计</h2></a></li> -->
	<!--     <li><a href="tools.html"  target="rightFrame"><img src="images/icon04.png" title="常用工具" /><h2>常用工具</h2></a></li> -->
	<!--     <li><a href="computer.html" target="rightFrame"><img src="images/icon05.png" title="文件管理" /><h2>文件管理</h2></a></li> -->
	<!--     <li><a href="tab.html"  target="rightFrame"><img src="images/icon06.png" title="系统设置" /><h2>系统设置</h2></a></li> -->
	<!--     </ul> -->
	<div class="topright">
		<ul>
<!-- 			<li><a id="editPass" class="easyui-linkbutton" -->
<!-- 				iconCls="icon-edit" style="float: right;">修改密码</a></li> -->
			<li><a class="easyui-linkbutton" iconCls="icon-back"
				href="<%=basePath%>outLogin" style="float: right;" target="_parent">退出</a></li>
		</ul>
		<div class="user">
			<span>登录用户：${sessionScope.loginUser}</span>
		</div>
	</div>
	
</body>
