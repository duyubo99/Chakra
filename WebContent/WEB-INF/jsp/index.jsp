<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/jsp; charset=utf-8" /> 
<title>ECharts转换工具</title>
<!-- https://cdnjs.cloudflare.com/ajax/libs/echarts/4.1.0/echarts-en.min.js -->
<script src="<%=basePath %>js/echarts-en.min.js" ></script>
<script src="<%=basePath %>js/jquery-3.3.1.min.js" ></script>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>jquery-easyui-1.6.7/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>jquery-easyui-1.6.7/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>jquery-easyui-1.6.7/demo/demo.css">
	<script type="text/javascript" src="<%=basePath %>jquery-easyui-1.6.7/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>jquery-easyui-1.6.7/jquery.easyui.min.js"></script>
</head>
<body>
<jsp:include page="top.jsp" flush="true"/>
<div style="margin:20px 0;">
	<a href="<%=basePath %>main/toList" class="easyui-linkbutton" iconCls="icon-undo"
	style="float: left;">跳转列表</a>
	<a id="convertText" class="easyui-linkbutton" iconCls="icon-reload"
	style="float: left;">转换</a>
	<a id="saveText" class="easyui-linkbutton" iconCls="icon-save"
	style="float: left;">保存</a>
	<a id="resetting" class="easyui-linkbutton" iconCls="icon-save"
	style="float: left;margin-right:20px">重置 </a>
	<input id="jsonNo" class="easyui-textbox" style="width:15%;height:25px;float:left;"
	data-options="multiline:true,prompt:'输入接口编号'" >
</div>
	<div id="main_layout" class="easyui-layout">
		<div data-options="region:'south',split:true" title="输入参数" style="height:30%;">
			<input id="parameText" class="easyui-textbox" style="width:70%;height:100%;white-space:pre-wrap;"
			 data-options="multiline:true,prompt:'格式：1,select * from other_test_data where t1!=? and t2!=?,1@2      备注：多行以;分隔'" 
			 value="">
			 <input id="echartDesc" class="easyui-textbox" label="图表描述:" multiline="true" labelPosition="left" value="" style="width:25%;height:100%;">
		</div>
		<div data-options="region:'east',split:true" title="输出文本" style="width:30%">
			<input id="tarEchartText" class="easyui-textbox" style="width:100%;height:100%;white-space:pre-wrap"
			 data-options="multiline:true" value="">
		</div>
		<div data-options="region:'west',split:true" title="输入文本" style="width:30%">
			<input id="srcEchartText" class="easyui-textbox" style="width:100%;height:100%;white-space:pre-wrap"
			 data-options="multiline:true,prompt:'格式：@1_1@，1_1为替换的数据,第一个1代表参数，第二个1代表第几行数据'" value="">
		</div>
		<div data-options="region:'center',title:'图表展示',iconCls:'icon-ok'">
<!-- 			<div id="main" style="width:100%;height:400px;"></div> -->
			<div id="main" style="width:500px;height:400px;"></div>
		</div>
</div>
<input type="hidden" value="${jt.jId }" id="updateidStr">
</body>
<script type="text/javascript">
$(document).ready(function(){
	var height1 = $(window).height()-20;
	$("#main_layout").attr("style","width:100%;height:"+height1+"px");
	$("#main_layout").layout("resize",{
		width:"100%",
		height:height1+"px"
	});
});
$(function(){
	if("${sqlText }"!=''){
		$("#parameText").textbox('setValue',"${sqlText }");
	}
	if("${jt.descText }"!=''){
		$("#echartDesc").textbox('setValue',"${jt.descText }");
	}
	if("${jt.busNo }"!=''){
		$("#jsonNo").textbox('setValue',"${jt.busNo }");
	}
	if("${jt.jsonStr }"!=''){
		$("#srcEchartText").textbox('setValue',"${jt.jsonStr }");
		reloadEchart("<%=basePath %>main/loadechart","load");
	}
});

//基于准备好的dom，初始化echarts实例
var myChart = echarts.init(document.getElementById('main'));
var sign = false;
$("#saveText").click(function(){
	if($("#srcEchartText").val()==""){
		alert("输入文本不能为空！");
		return;
	}
	reloadEchart("<%=basePath %>main/loadechart","load");
	
	if(!sign){
		var msg = "图表未生成或生成错误，是否继续保存？";
        if (confirm(msg)==false){
			return;
		}
	}
	var urlStr = "<%=basePath %>main/saveechart";
	if($("#updateidStr").val()!=''){
		urlStr = urlStr+"?jId="+$("#updateidStr").val();
	}
	reloadEchart(urlStr,"save");
});
$("#convertText").click(function(){
	reloadEchart("<%=basePath %>main/loadechart","load");
});
/**
 * 加载or保存图表
 */
var reloadEchart = function(urlstr,opetypestr){
	myChart.clear();
	//  指定图表的配置项和数据
	var timestamp = Date.parse(new Date());
    $.ajax({
        type : "post",
        async : false,
        url : urlstr,
        data :{timestamp1:timestamp,eparames:$("#parameText").val(),
        	jsonStr:$("#srcEchartText").val(),isValid:sign,descText:$("#echartDesc").val(),
        	busNo:$("#jsonNo").val()},
        cache:false,
        dataType : "text",
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        success : function(result) {
        	if(opetypestr=="save"){
        		alert("保存成功！");
        		reloadEchart("<%=basePath %>main/loadechart","load");
        		return;
    		}
        	$("#tarEchartText").textbox('setValue',result);
        	if(result.substr(result.length-1,1)==";"){
        		result=result.substr(0,result.length-1);
        	}
        	try  {
        		var obj = eval('(' + result + ')');
              	//使用刚指定的配置项和数据显示图表。
              	myChart.clear();
                myChart.setOption(obj,true);
                sign = true;
				
        	}catch(exception) {
        		sign = false;
        		if(opetypestr=="load"){
	        		alert("图表转换失败！");
        		}
        	}
       },
        error : function(errorMsg) {
        	sign = false;
        	if(opetypestr=="load"){
	    		alert("图表转换失败！");
        	}
        	if(opetypestr=="save"){
	    		alert("保存失败！");
        	}
        }
    });
};
$("#resetting").click(function(){
	$("#updateidStr").val("");
	$("#parameText").textbox('setValue',"");
	$("#srcEchartText").textbox('setValue',"");
	$("#tarEchartText").textbox('setValue',"");
	$("#echartDesc").textbox('setValue',"");
	$("#jsonNo").textbox('setValue',"");
	myChart.clear();
});
</script>
</html>

