<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<%=basePath %>js/jquery-3.3.1.min.js" ></script>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>jquery-easyui-1.6.7/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>jquery-easyui-1.6.7/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>jquery-easyui-1.6.7/demo/demo.css">
	<script type="text/javascript" src="<%=basePath %>jquery-easyui-1.6.7/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>jquery-easyui-1.6.7/jquery.easyui.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div id="ReceiveFeedBackDialog" class="easyui-dialog" closed="true"
		buttons="#dlg-buttons" title="修改密码"
		style="width: 300px; height: 300px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="background: #fff; border: 1px solid #ccc;">
				<form id="editPasswordForm">
					<table>
						<tr>
							<td>新密码：</td>                            
							<td><input required="true"
								data-options="validType:'length[3,6]'" id="txtNewPass"
								type="Password" class="txt01 easyui-validatebox" /></td>   
						</tr>
						<tr>
							<td>确认密码：</td>                            
							<td><input required="true"
								data-options="validType:'length[3,6]'" id="txtRePass"
								type="Password" class="txt01 easyui-validatebox" /></td>   
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<div id="dlg-buttons">
		<a id="btnEp" class="easyui-linkbutton" onclick="formSubmit();">Save</a>
		<a href="#" class="easyui-linkbutton" onclick="closeDialog();">Close</a>
	</div>
</body>
</html>
<script type="text/javascript">
$(function(){
	$('#ReceiveFeedBackDialog').dialog('open');
});
closeDialog=function(){
	$('#ReceiveFeedBackDialog').dialog('close');
};
$("#btnEp").click(function(){
	var v = $("#editPasswordForm").form("validate");
	if(v){
		var v1 = $("#txtNewPass").val();
		var v2 = $("#txtRePass").val();
		if(v1 == v2){
		$.post(
 			"editPassword",
			{"password":v1},
			function(data){
				if(data == '1'){
					//修改成功，关闭修改密码窗口
					$.messager.alert("提示信息","密码修改成功！","success");
					$('#ReceiveFeedBackDialog').dialog('close');
				}else{
					//修改密码失败，弹出提示
					$.messager.alert("提示信息","密码修改失败！","error");
				};
			},
			"json"
 		);
	}else{
		//两次输入不一致，弹出错误提示
		$.messager.alert("提示信息","两次密码输入不一致！","warning");
	}
}
});
</script>