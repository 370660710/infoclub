<%@ page
 contentType="text/html;charset=GBK"
%>
<html>
	<head>
		<title></title>
		<link href="../css/06default.css" type="text/css" rel=stylesheet type="text/css"/>
		<link href="../css/default.css" type="text/css" rel=stylesheet type="text/css"/>
		<script language="JavaScript">
	     function outwarning(){
			alert("���ȵ�¼,лл��");
		}

        </script>
	</head>
	<body>
		<form action="Toppage" method="post" name="topPageform">
		<br>
		  <table align="left" width="17%">
		    <tr align="center"> 
		      <td><a href="/baixunhui/index.jsp"  method="post" target="_self">��ҳ</a></td>		      
		    </tr>
		  </table>
		   
		  <table align="right" width="30%">
		    <tr align="center">    
		    <% String curUserName = (String)session.getAttribute("userName");
		  	  		if(curUserName!=null) {
		  	  		%>
		  	  		 <td><a href="/baixunhui/accountMenu.jsp" target="_self">�ҵ��ʻ�</a></td>
		  		<% 
		  			} else { %>
		  			<td><a href="javascript:outwarning()" target="_self">�ҵ��ʻ�</a></td>
		  			
		  		<% 	}%>
		     	      
		    </tr>
		  </table><br><br>
		  <center><br>
		  		<%
		  			String userName=(String)session.getAttribute("userName");
		  			if(userName==null) {
		  				%>
		  					<font color="black">����,��ӭ����.[��</font>
		  					<a href="/baixunhui/userRegistry.jsp">ע��</a>
		  				    /<a href="/baixunhui/login.jsp">��¼</a><font color="black">]</font>
		  				<%
		  			} else {
		  				%>
		  					����!<font color="black"><%= userName %></font>&nbsp;
		  					��ӭ����.
		  				<%
		  			}
		  		%>
		  </center>
		</form>
	</body>
</html>
	