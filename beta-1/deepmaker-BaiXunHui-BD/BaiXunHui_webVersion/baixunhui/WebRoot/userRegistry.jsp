<%@ page
 contentType="text/html;charset=GBK"%>
<html>
  <head>
    <title>�û�ע��</title>
    <link href="../css/06default.css" type="text/css" rel=stylesheet type="text/css"/>
	<link href="../css/default.css" type="text/css" rel=stylesheet type="text/css"/>
	
    <script language="JavaScript">
      String.prototype.Trim = function()
      {
         return this.replace(/(^\s*)|(\s*$)/g, "");
      }
      function checkValue() {
          if(document.registeryForm.userName.value.Trim()=="") {
              alert("�û�������Ϊ��,����������!");
              return false;
          } else if(document.registeryForm.password.value.Trim()=="") {
              alert("���벻��Ϊ��,����������!");
              return false;
          } else if(document.registeryForm.confirmpassword.value.Trim()=="") {
              alert("ȷ�����벻��Ϊ��,����������!");
              return false;
          } else if(document.registeryForm.email.value.Trim()=="") {
              alert("email��ַ����Ϊ��,����������!");
              return false;
          } else {
              return checkPWS();
          }
      }
      function checkPWS(){
      	  var password1=document.registeryForm.password.value.Trim();
      	  var password2=document.registeryForm.confirmpassword.value.Trim();
          if(password1==password2) {
              return true;
          } else {
              alert("��������������벻��ͬ,����������!");
              return false;
          }
      }
      
	 var submitFlag=false;
	 function checkSubmit() {
    	if(submitFlag) {	
			alert("���ڴ���,���Ժ�...!");
			return false;
		} else {
			submitFlag=true;
			return true;
		}
     }
    </script>

    <style type="text/css">
    	.imagefilter {
    		filter:Blinds(direction='down');
    	}
    </style>
  </head>
  <body>
  <%
		  			String userName=(String)session.getAttribute("userName");
		  			if(userName!=null) {
		  				session.removeAttribute("userName");
		  				session.removeAttribute("curUser");
		  			} else {
		  			}
		  		%>
  <jsp:include page="topPage.jsp"/><br><br>
    <fieldset>
      <legend><font color="#ff6600" size="5">���û�ע��</font></legend>
      <form action="UserRegister" method="post" name="registeryForm"
            onsubmit="return checkValue();return checkSubmit();"><div align="center"> 
        </div><table align="center">
          <tr>
            <td align="center"><font color="#ff6600">*</font>�� �� ��:</td>
            <td><input type="text" size="25" name="userName" class="inputtext"></td>
          </tr>
          <tr>
            <td align="center"><font color="#ff6600">*</font>�� ��:</td>
            <td><input type="password" size="25" name="password" value="" class="inputtext"></td>
          </tr>
          <tr>
            <td align="center"><font color="#ff6600">*</font>ȷ������:</td>
            <td><input type="password" size="25" name="confirmpassword" value="" class="inputtext"></td>
          </tr>
          <tr>
            <td align="center"><font color="#ff6600">*</font>E&nbsp;-&nbsp;Mail:</td>
            <td><input type="text" size="25" name="email" value="" class="inputtext"></td>
          </tr>
          <tr>
            <td align="center">�绰����:</td>
				<td><input type="text" size="25" name="phone" value="" class="inputtext"></td>
          </tr>
          <tr>
            <td align="center">&nbsp;QQ:</td>
            <td><input type="text" size="25" name="qq" value="" class="inputtext"></td>
          </tr>
          
          
        </table><br>
        <center>
          <input type="submit" value="�ύ">
          <input type="hidden" name="action" value="registrySubmit">
          <input type="reset" value="����">
        </center>
      </form>
      <div align="center"><em><%=(request.getAttribute("msg")==null)?"":request.getAttribute("msg") %></em></div>
    </fieldset>
    <br>
  </body>
</html>