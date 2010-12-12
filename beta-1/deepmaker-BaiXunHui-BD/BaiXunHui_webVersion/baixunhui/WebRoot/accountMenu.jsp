<%@ page
 contentType="text/html;charset=GBK"
%>
<html>
	<head>
		<title></title>
		<link href="../css/06default.css" type="text/css" rel=stylesheet type="text/css"/>
		<link href="../css/default.css" type="text/css" rel=stylesheet type="text/css"/>
		<style>
	    	.mbutton{
	    	     cursor:hand;font-size:10pt;color:white;height:20px;
	    	     width:210px;text-align:left;border:1px none;
	    	     padding:3px 0px 0px 0px;margin: 1px 0px 0px 0px;
	    	     background-color:#C9E1FB;position:relative;
	    	}    
	    	.moverbutton{
	    	     cursor:hand;font-size:10pt;color:#C9E1FB;height:20px;
	    	     width:210px;text-align:left;border:1px none;
	    	     padding:3px 0px 0px 0px;margin: 1px 0px 0px 0px;
	    	     background-color:white;position:relative;
	    	}    
	    	demo{
			    overflow:visible;
			    font: 1em Helvetica, Arial, sans-serif;
			    text-align:center;
			    background-color:#539CE6;
			    padding-top: 2px;
			    border: solid 1px;
			    border-color:#ffffff #808080 #808080 #ffffff;
			    height:23px;
			}
    	</style>
		<script language="JavaScript">
	        function myMouseOver(xx) {
	           eval("document.all."+xx+".className='moverbutton';");
	        }
	        function myMouseOut(xx) {
	           eval("document.all."+xx+".className='mbutton';");
	        }        
    	</script>
	</head>
	<jsp:include page="userAccountTopPage.jsp"/><br>
	<jsp:include page="userIndex.jsp"/>
	<body style="margin:0;border:none;padding:0;white-space:nowrap;">
	  <div class="demo"><div align="left"> 
	  </div><table width="192"  style="white-space: nowrap;" cellpadding="0" cellspacing="0" height="341">
	  
	  	<tr>
	  	<td><div align="left"> 
	  		</div><div id="button2" class="mbutton" align="right"
               onMouseOut="myMouseOut('button2')" onMouseOver="myMouseOver('button2');"><div align="left"> 
          	   <a href="/baixunhui/accountInfo.jsp" target="mainFrame">&nbsp;查看帐户信息</a></div>
          </div>
	  	</td></tr>
	  	<tr>
	  	<td>
	  		<div id="button10" class="mbutton" align="right"
               onMouseOut="myMouseOut('button10')" onMouseOver="myMouseOver('button10');">
          	   <a href="/baixunhui/modifyEMail.jsp" target="mainFrame">&nbsp;修改我的E-mail地址</a>
          </div>
	  	</td></tr>
	  	<tr>
	  	<td>
	  		<div id="button11" class="mbutton" align="right"
               onMouseOut="myMouseOut('button11')" onMouseOver="myMouseOver('button11');">
          	   <a href="/baixunhui/modifyphone.jsp" target="mainFrame">&nbsp;修改我的联系号码</a>
          </div>
	  	</td></tr>
	  	<tr>
	  	<td>
	  		<div id="button12" class="mbutton" align="right"
               onMouseOut="myMouseOut('button12')" onMouseOver="myMouseOver('button12');">
          	   <a href="/baixunhui/modifyPassword.jsp" target="mainFrame">&nbsp;修改我的登录密码</a>
          </div>
	  	</td></tr>
	  	<tr>
	  	<td>
	  		<div id="button13" class="mbutton" align="right"
               onMouseOut="myMouseOut('button13')" onMouseOver="myMouseOver('button13');">
          	   <a href="/baixunhui/modifyQQ.jsp" target="mainFrame">&nbsp;修改QQ</a>
          </div>
	  	</td></tr>
	  	<tr>
	  	<td>
	  		<div id="button14" class="mbutton" align="right" 
               onMouseOut="myMouseOut('button14')" onMouseOver="myMouseOver('button14');">
          	   <a href="UserAccountManager?action=logout" target="_parent">&nbsp;退出登录</a>
          </div>
	  	</td>
	  </tr>
	  </table></div>
	</body>
</html>