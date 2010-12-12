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
			alert("请先登录,谢谢！");
		}

        </script>
	</head>
	<body>
		<form action="Toppage" method="post" name="topPageform">
		<br>
		  <table align="left" width="17%">
		    <tr align="center"> 
		      <td><a href="/baixunhui/index.jsp"  method="post" target="_self">首页</a></td>		      
		    </tr>
		  </table>
		   
		  <table align="right" width="30%">
		    <tr align="center">    
		    <% String curUserName = (String)session.getAttribute("userName");
		  	  		if(curUserName!=null) {
		  	  		%>
		  	  		 <td><a href="/baixunhui/accountMenu.jsp" target="_self">我的帐户</a></td>
		  		<% 
		  			} else { %>
		  			<td><a href="javascript:outwarning()" target="_self">我的帐户</a></td>
		  			
		  		<% 	}%>
		     	      
		    </tr>
		  </table><br><br>
		  <center><br>
		  		<%
		  			String userName=(String)session.getAttribute("userName");
		  			if(userName==null) {
		  				%>
		  					<font color="black">您好,欢迎光临.[请</font>
		  					<a href="/baixunhui/userRegistry.jsp">注册</a>
		  				    /<a href="/baixunhui/login.jsp">登录</a><font color="black">]</font>
		  				<%
		  			} else {
		  				%>
		  					您好!<font color="black"><%= userName %></font>&nbsp;
		  					欢迎回来.
		  				<%
		  			}
		  		%>
		  </center>
		</form>
	</body>
</html>
	