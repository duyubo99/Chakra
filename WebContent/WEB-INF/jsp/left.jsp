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
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/style.css">
<script type="text/javascript" src="<%=basePath %>jquery-easyui-1.6.7/jquery.min.js"></script>
    
<div class="lefttop"><span></span>操作菜单</div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="<%=basePath %>images/leftico01.png" /></span>Echart操作
    </div>
    	<ul class="menuson">
        <li class="active"><cite></cite><a href="index.html" target="rightFrame">在线转换</a><i></i></li>
        <li><cite></cite><a href="<%=basePath %>main/toList" target="rightFrame">数据列表</a><i></i></li>
        <li><cite></cite><a href="<%=basePath %>main/echartDemo" target="rightFrame">js示例代码</a><i></i></li>
        </ul>    
    </dd>
        
    
    <dd>
    <div class="title">
    <span><img src="<%=basePath %>images/leftico02.png" /></span>用户管理
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="<%=basePath %>toEditPassPage" target="rightFrame">修改密码</a><i></i></li>
<!--         <li><cite></cite><a href="#">发布信息</a><i></i></li> -->
<!--         <li><cite></cite><a href="#">档案列表显示</a><i></i></li> -->
        </ul>     
    </dd> 
    
    
<!--     <dd><div class="title"><span><img src="images/leftico03.png" /></span>编辑器</div> -->
<!--     <ul class="menuson"> -->
<!--         <li><cite></cite><a href="#">自定义</a><i></i></li> -->
<!--         <li><cite></cite><a href="#">常用资料</a><i></i></li> -->
<!--         <li><cite></cite><a href="#">信息列表</a><i></i></li> -->
<!--         <li><cite></cite><a href="#">其他</a><i></i></li> -->
<!--     </ul>     -->
<!--     </dd>   -->
    
    
<!--     <dd><div class="title"><span><img src="images/leftico04.png" /></span>日期管理</div> -->
<!--     <ul class="menuson"> -->
<!--         <li><cite></cite><a href="#">自定义</a><i></i></li> -->
<!--         <li><cite></cite><a href="#">常用资料</a><i></i></li> -->
<!--         <li><cite></cite><a href="#">信息列表</a><i></i></li> -->
<!--         <li><cite></cite><a href="#">其他</a><i></i></li> -->
<!--     </ul> -->
    
<!--     </dd>    -->
    
    </dl> 
    
<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
});
</script>
