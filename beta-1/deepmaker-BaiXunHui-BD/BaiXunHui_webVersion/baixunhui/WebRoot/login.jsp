<%@ page
 contentType="text/html;charset=GBK"
%>
<html>
	<head>
		<title>�û���¼</title>
		<link href="../css/06default.css" type="text/css" rel=stylesheet type="text/css"/>
		<link href="../css/default.css" type="text/css" rel=stylesheet type="text/css"/>
		<script language="JavaScript">
	      String.prototype.Trim = function()
	      {
	         return this.replace(/(^\s*)|(\s*$)/g, "");
	      }
	      function checkValue() {
	          if(document.loginForm.userName.value.Trim()=="") {
	              alert("�û�������Ϊ��!");
	              return false;
	          } else if(document.loginForm.password.value.Trim()=="") {
	              alert("���벻��Ϊ��!");
	              return false;
	          }
	      }
        </script>
	</head>
	<body>
		<jsp:include page="topPage.jsp"/><br><br>
		<form action="UserLogin" method="post" name="loginForm" onsubmit="">
			<fieldset>
		      <legend><font color="#ff6600" size="5">�û���¼</font></legend>
		      <form action="UserRegister" method="post" name="registeryForm"
		            onsubmit="return checkValue();return checkSubmit();">
		        <table align="center">
		          <%
		          	String regLogin=(String)request.getAttribute("regLogin");
		          	if(regLogin!=null&&!regLogin.equals("")) {
		          		%>
		          			<tr>
		            			<td><font color="#ff6600" size="3">���ȵ�¼!</font></td>
		          			</tr>
		          		<%
		          	}
		          %>
		          <tr>
		            <td align="center">�� �� ��:</td>
		            <td><input type="text" size="25" name="userName"></td>
		          </tr>
		          <tr>
		            <td align="center">�� ��:</td>
		            <td><input type="password" size="25" name="password" value=""></td>
		          </tr>
		        </table><br>
		        <center>
		          <input type="submit" name="submit" value="�ύ">
		          <input type="hidden" name="action" value="UserLogin">
		        </center>
		        <a href="/baixunhui/userRegistry.jsp"><img src="image/home_create_button.jpg"></a>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
		      </form><div align="center"><%=(request.getAttribute("msg")==null)?"":request.getAttribute("msg") %><em></em> 
		    </div></fieldset>
		</form>
	</body>
</html>