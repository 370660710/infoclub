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
					alert("�����벻��Ϊ��,����������!");
					return false;
				} else if(document.modifyPasswordForm.newPassword.value.Trim()=="") {
					alert("�����벻��Ϊ��,����������!");
					return false;
				} else if(document.modifyPasswordForm.newPassword1.value.Trim()=="") {
             		 alert("ȷ�����벻��Ϊ��,����������!");
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
	              alert("��������������벻��ͬ,����������!");
	              return false;
	          }
	       }
		</script>
	</head>
	<body>
		<form action="UserAccountManager?action=modifyPassword" method="post" name="modifyPasswordForm"
		      onsubmit="return checkValue();"><br><br>
		<center><font color="" size="3">�޸��ҵĵ�¼����</font></center><br><br>
		<center>
		<% 
			String msg=request.getParameter("msg");
			if(msg==null||msg.equals("")) {
			%><font color="red" size="2">�´���ʹ���������¼!</font>
			<table width="35%" border="0">
			<tbody>
				<tr>
					<td width="100%">
					<table border="0" width="100%">
					<tbody>	
					<tr align="center">
						<td>�ҵľ�����:</td>
						<td><input type="password" name="oldPassword" size="20" value="" class="inputtext">
						</td>
					</tr>
					<tr align="center">
						<td>�ҵ�������:</td>
						<td>
							<input type="password" name="newPassword" size="20" value="" maxlength="12" class="inputtext">
						</td>
					</tr>
					<tr align="center">
						<td>ȷ������:</td>
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
					<input type="submit" value="�ύ">
					<input type="hidden" name="action" value="modifyPasswordSubmit">
					<input type="reset" name="reset" value="����">
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