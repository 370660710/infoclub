<%@ page
 contentType="text/html;charset=GBK"
 import="java.util.*,java.io.*"
 import="instance.User;"
%>
<html>
  <head>
    <title>�ʻ���Ϣ</title>
    <link href="../css/06default.css" type="text/css" rel=stylesheet type="text/css"/>
	<link href="../css/default.css" type="text/css" rel=stylesheet type="text/css"/>
    	<style type="text/css">
			.a{color:#000000;font-size:14};
		</style>
  </head>
  <body>
  <jsp:include page="userAccountTopPage.jsp"/><br>
  <jsp:include page="userIndex.jsp"/>
  <fieldset>
  <legend><font color="#ff6600" size="5">�ʻ���Ϣ</font></legend>
    <form action="" method="post" name="userInfoForm"><br><br>
   
       <%
       		User curUser =(User)session.getAttribute("curUser");
       %><center>
       <table border="1" width="497" borderColorDark=#ffffec 
       			borderColorLight=#5e5e00 cellPadding=1 cellSpacing=0 height="229">
       	 <tbody>	
       <%
         if(((String)session.getAttribute("userName"))==null) {
         	%>
         		<font color="" size="3">
         			<font color="#000000" size="3">������</font><a href="/baixunhui/login.jsp" target="_blank">��¼</a>
         			<font color="#000000" size="3">!</font>
         		</font>
         	<%
         }
	    		
						%>
						<tr>
						  <td>
						  	<table border="1" width="491" borderColorDark=#ffffec 
						  			borderColorLight=#5e5e00 cellPadding=1 cellSpacing=0 height="25">
						  	<tbody>
								<tr align="center">
									<td width="32%" bgcolor="#FFFFCC">��&nbsp;��:</td>
			       	  				<td class="a" bgcolor="#CCFFCC""><%= curUser.getUserName()%></td>	
		       	 				</tr>
						  	</tbody></table>
						  </td>
						</tr>
						</tbody>
						<tr>
							<td>
							<table border="1" width="100%" borderColorDark=#ffffec 
									borderColorLight=#5e5e00 cellPadding=1 cellSpacing=0>
							<tbody>
								<tr align="center">
       	 							<td width="32%" bgcolor="#FFFFCC">Email&nbsp;��ַ:</td>
       	 							<td class="a" bgcolor="#CCFFCC"><%= curUser.getEmail() %></td>
       	 						</tr>
							</table>
	       	 			<tr>
							<td>
							<table border="1" width="100%" borderColorDark=#ffffec 
							       borderColorLight=#5e5e00 cellPadding=1 cellSpacing=0>
							<tbody>
								<tr align="center">
									<td width="32%" bgcolor="#FFFFCC">�绰����:</td>
									<td class="a" bgcolor="#CCFFCC"><%= curUser.getPhone() %></td>
								</tr>
							</tbody>
							</table>
							</td>
						</tr>
						<tr>
							<td>
							<table border="1" width="100%" borderColorDark=#ffffec 
							       borderColorLight=#5e5e00 cellPadding=1 cellSpacing=0>
							<tbody>
								<tr align="center">
									<td width="14%" bgcolor="#FFFFCC">QQ����:</td>
									<td width="30%" bgcolor="#CCFFCC"><font color="#000000" size="2"><%= curUser.getUserQQ() %></font></td>	
								</tr>
							</tbody>
							</table>	 
  </body>
</html>