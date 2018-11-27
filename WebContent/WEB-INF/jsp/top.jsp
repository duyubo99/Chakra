<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="wFont" style="border-bottom: 5px solid black">
<h2> 登录用户：${sessionScope.loginUser}
<a id="editPass" class="easyui-linkbutton" iconCls="icon-edit"
		style="float: right;">修改密码</a>
	<a class="easyui-linkbutton" iconCls="icon-back" href="<%=basePath %>outLogin"
		style="float: right;">退出</a>
</h2>
</div>
<div id="ReceiveFeedBackDialog" class="easyui-dialog" closed="true" buttons="#dlg-buttons" title="修改密码" style="width:300px;height:300px;"> 
<div class="easyui-layout" fit="true">
            <div region="center" border="false" style="background: #fff; border: 1px solid #ccc;">
                <form id="editPasswordForm">
                    <table>
                        <tr>
                            <td>新密码：</td>
                            <td><input required="true" data-options="validType:'length[3,6]'" id="txtNewPass" type="Password" class="txt01 easyui-validatebox" /></td>
                        </tr>
                        <tr>
                            <td>确认密码：</td>
                            <td><input required="true" data-options="validType:'length[3,6]'" id="txtRePass" type="Password" class="txt01 easyui-validatebox" /></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
</div> 
<div id="dlg-buttons">
        <a id="btnEp" class="easyui-linkbutton" onclick="formSubmit();">Save</a> <a href="#"
            class="easyui-linkbutton" onclick="closeDialog();">Close</a>
</div>
    
<script type="text/javascript">
$("#editPass").click(function(){
	$('#ReceiveFeedBackDialog').dialog('open');
})
closeDialog=function(){
	$('#ReceiveFeedBackDialog').dialog('close');
}

$("#btnEp").click(function(){
	            var v = $("#editPasswordForm").form("validate");
	            if(v){
	                var v1 = $("#txtNewPass").val();
	                var v2 = $("#txtRePass").val();
	                if(v1 == v2){
	                    $.post(
	                        "<%=basePath %>editPassword",
	                        {"password":v1},
	                        function(data){
	                            if(data == '1'){
	                                //修改成功，关闭修改密码窗口
									$.messager.alert("提示信息","密码修改成功！","success");
	                                $('#ReceiveFeedBackDialog').dialog('close');
	                            }else{
	                                //修改密码失败，弹出提示
	                                $.messager.alert("提示信息","密码修改失败！","error");
	                            }
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
