<%@ page
 contentType="text/html;charset=GBK"
 import="java.util.*,java.io.*"
%>
<html>
	<head>
		<title></title>
		<link href="../css/06default.css" type="text/css" rel=stylesheet type="text/css"/>
		<link href="../css/default.css" type="text/css" rel=stylesheet type="text/css"/>
		<style type="text/css">
			.a{color:#000000;font-size:14};
		</style>
		<script language="JavaScript">
			String.prototype.Trim = function()
		    {
		         return this.replace(/(^\s*)|(\s*$)/g, "");
		    }
			function checkValue() {
				if(document.modifyPasswordForm.oldPassword.value.Trim()=="") {
					alert("旧密码不能为空,请重新输入!");
					return false;
				} else if(document.modifyPasswordForm.newPassword.value.Trim()=="") {
					alert("新密码不能为空,请重新输入!");
					return false;
				} else if(document.modifyPasswordForm.newPassword1.value.Trim()=="") {
             		 alert("确认密码不能为空,请重新输入!");
             		 return false;
         		}else {
              		return checkPWS();
         		}
			}
			function checkPWS(){
	      	  var newPassword=document.modifyPasswordForm.newPassword.value.Trim();
	      	  var newPassword1=document.modifyPasswordForm.newPassword1.value.Trim();
	          if(newPassword==newPassword1) {
	              return true;
	          } else {
	              alert("您两次输入的密码不相同,请重新输入!");
	              return false;
	          }
	       }
		</script>
	</head>
	<body>
		<form action="UserAccountManager?action=modifyPassword" method="post" name="modifyPasswordForm"
		      onsubmit="return checkValue();"><br><br>
		<center><font color="" size="3">修改我的登录密码</font></center><br><br>
		<center>
		<% 
			String msg=request.getParameter("msg");
			if(msg==null||msg.equals("")) {
			%><font color="red" size="2">下次请使用新密码登录!</font>
			<table width="35%" border="0">
			<tbody>
				<tr>
					<td width="100%">
					<table border="0" width="100%">
					<tbody>	
					<tr align="center">
						<td>我的旧密码:</td>
						<td><input type="password" name="oldPassword" size="20" value="" class="inputtext">
						</td>
					</tr>
					<tr align="center">
						<td>我的新密码:</td>
						<td>
							<input type="password" name="newPassword" size="20" value="" maxlength="12" class="inputtext">
						</td>
					</tr>
					<tr align="center">
						<td>确认密码:</td>
						<td>
							<input type="password" name="newPassword1" size="20" value="" maxlength="12" class="inputtext">
						</td>
					</tr>
					</tbody>
					</table>
					</td>
				</tr><br>
				<tr>
					<td align="center">
					<input type="submit" value="提交">
					<input type="hidden" name="action" value="modifyPasswordSubmit">
					<input type="reset" name="reset" value="重置">
					</td>
				</tr>
			</tbody>
			</table>
			<%
			} else {
			%>
				<%= msg %>
			<%
			}
		%>
		<%=(request.getAttribute("msg")==null)?"":request.getAttribute("msg") %>
			</center>
		</form>
	</body>
</html>