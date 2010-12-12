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
				if(document.modifyNikeNameForm.newNikeName.value.Trim()=="") {
					alert("新电话不能为空,请重新输入!");
					return false;
				}
				return true;
			}
		</script>
	</head>
	<body>
		<form action="UserAccountManager?action=modifyPhone" method="post" name="modifyPhone"
		      onsubmit="return checkValue()"><br><br>
		<center><font size="3" color="">修改我的联系</font><font size="3" color="">电话</font></center><br><br>
		<center>
		<%
       		User curUser =(User)session.getAttribute("curUser");
       %>
		<% 
			String msg=request.getParameter("msg");
			if(msg==null||msg.equals("")) {
			%>
			<table width="35%" border="0">
			<tbody>
				<tr>
					<td>
					<table border="0" width="100%">
					<tbody>
					<tr align="center">
						<td>我的旧电话:</td>
						<td><input type="text" name="oldPhone" size="20" 
						    value="<%= curUser.getPhone() %>" readonly="true" class="inputtext">
						</td>
					</tr>
					<tr align="center">
						<td>我的新电话:</td>
						<td>
							<input type="text" name="newPhone" size="20" value="" maxlength="12" class="inputtext">
						</td>
					</tr>
					</tbody>
					</table>
					</td>
				</tr><br>
				<tr>
					<td align="center">
					<input type="submit" value="提交">
					<input type="hidden" name="action" value="modifyPhoneSubmit">
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
			</center>
		</form>
	</body>
</html>