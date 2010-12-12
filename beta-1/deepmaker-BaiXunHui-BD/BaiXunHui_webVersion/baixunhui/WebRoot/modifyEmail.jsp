<%@ page
 contentType="text/html;charset=GBK"
 import="java.util.*,java.io.*"
 import="instance.User;"
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
				if(document.modifyEmailForm.newEmail.value.Trim()=="") {
					alert("E-Mail地址不能为空,请重新输入!");
					return false;
				}
				return true;
			}
		</script>
	</head>
	<body>
		<form action="UserAccountManager?action=modifyEmail" method="post" name="modifyEmailForm"
		      onsubmit="return checkValue()"><br><br>
		<center><font color="" size="3">修改我的E-mail地址</font></center><br><br>
		<center>
		<%
       		User curUser =(User)session.getAttribute("curUser");
       %>
		<% 
			String msg=request.getParameter("msg");
			if(msg==null||msg.equals("")) {
		%>
			<table width="50%" border="0">
			<tbody>
				<tr>
					<td>
					<table border="0" width="100%">
					<tbody>
					<tr align="center">
						<td>旧的E-mail地址:</td>
						<td><input type="text" name="oldEmail" size="30" 
						    value="<%= curUser.getEmail() %>" readonly="true" class="text">
						</td>
					</tr>
					<tr align="center">
						<td>新的E-mail地址:</td>
						<td>
							<input type="text" name="newEmail" size="30" value="" class="inputtext">
						</td>
					</tr>
					</tbody>
					</table>
					</td>
				</tr><br>
				<tr>
					<td align="center">
					<input type="submit" value="提交">
					<input type="hidden" name="action" value="modifyEmailSubmit">
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