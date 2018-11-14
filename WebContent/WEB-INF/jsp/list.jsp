<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>jquery-easyui-1.6.7/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>jquery-easyui-1.6.7/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>jquery-easyui-1.6.7/demo/demo.css">
	<script type="text/javascript" src="<%=basePath %>jquery-easyui-1.6.7/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>jquery-easyui-1.6.7/jquery.easyui.min.js"></script>
<title>Insert title here</title>
</head>
<body>
  	<div id="tb" style="padding:3px">
		<span>接口编号:</span>
		<input id="busNo" style="line-height:26px;border:1px solid #ccc">
		<span>详情描述:</span>
		<input id="descText" style="line-height:26px;border:1px solid #ccc">
		<a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">Search</a>
	</div>
    <table id="dg"></table>
    <a href="#" id="toEchart"></a>
    </div>
    <div>
	<div style="float: right;">
	<a href="<%=basePath %>main/index" class="easyui-linkbutton" iconCls="icon-redo"
	style="float: left;">跳转新增</a>
	</div>
	<h1>示例代码</h1>
	<img style='width:600px; height:500px;float: left;' src='<%=basePath %>images/jsDemo.png'>
</body>

<script>
$(function () {
    loadList();
});
function doSearch(){
		$('#dg').datagrid('load',{
			busNo:$('#busNo').val(),
			descText:$('#descText').val()
		});
	}
var loadList = function () {
    var m_test_name = "接口列表";
    var pageNumber = 1;
    var pageSize = 20;
    init_datagrid();
 
    function init_datagrid() {
        var arr_columns = test_dg_columns();
        $("#dg").datagrid({
             url: '<%=basePath %>main/loadList',
             singleSelect: true,
             remoteSort: true, //定义从服务器对数据进行排序。
             pagination: true, //在DataGrid控件底部显示分页工具栏。
             pageNumber: pageNumber,
             pageSize: pageSize,
     	     pageList: [5,10,15,20],
             method: 'post',
             columns: [arr_columns],
             rownumbers: true,
             loadMsg: '正在加载数据',
             checkbox: true,
             title: '表单 -- ' + m_test_name,
             emptyMsg: '列表为空',
             toolbar:"#tb",
             selectOnCheck: false,
             checkOnSelect: false,
             onDblClickRow :function(rowIndex,rowData){
            	 $("#toEchart").attr('href','<%=basePath %>main/toUpdateText?id='+rowData.jId);
            	 document.getElementById("toEchart").click(); 
             }
        });
    }
 
    function test_dg_columns() {
        var arr = new Array();
        arr.push({"field": "jId", "title": '数据编号',hidden:'true'});
        arr.push({"field": "busNo", "title": '接口编号', "width": '15%', "align": 'center',sortable:true});
        arr.push({"field": "descText", "title": '详情描述', "width": '31%', "align": 'center',sortable:true});
        arr.push({"field": "jsonStr", "title": '文本内容', "width": '40%', "align": 'center',sortable:true,
        	formatter:formatCellTooltip});
        arr.push({"field": "isValid", "title": '图表状态', "width": '15%', "align": 'center',sortable:true,
        	formatter:imgFormatter});
        return arr;
    }
  	//格式化单元格提示信息  
    function formatCellTooltip(value){  
  		return "<a title=" + value + ">" + value + "</a>"; 
    }
    function imgFormatter(value){
    	if(value=="true"){
  			return "<img style='width:30px; height:30px' src='<%=basePath %>images/true2.png'>";
    	}else{
    		return "<img style='width:30px; height:30px' src='<%=basePath %>images/false2.png'>";
    	}
  	};
};
</script> 
</html>