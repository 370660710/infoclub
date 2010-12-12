<%@ page
 contentType="text/html;charset=GBK"
 import="java.sql.*,java.util.*,java.io.*,java.text.*"
%>
<html>
	<head>
	<link href="../css/06default.css" type="text/css" rel=stylesheet type="text/css"/>
	<link href="../css/default.css" type="text/css" rel=stylesheet type="text/css"/>
		<style type="text/css">
			.style1 {font-size: 13px}
			body {
				margin-top: 0px;
				margin-bottom: 0px;
			}
		</style>	
	<script> 
		function tick() {
			var hours, minutes, seconds, noon;
			var intHours, intMinutes, intSeconds;
			var now;
			now = new Date();
			intHours = now.getHours();
			intMinutes = now.getMinutes();
			intSeconds = now.getSeconds();
			if (intHours < 12) {
				hours = intHours+":";
				noon = "AM";
			} else {
				intHours = intHours
				hours = intHours + ":";
				noon = "PM";
			}
			if (intMinutes < 10) {
				minutes = "0"+intMinutes+":";
				} else {
				minutes = intMinutes+":";
			}
			if (intSeconds < 10) {
				seconds = "0"+intSeconds+" ";
			} else {
				seconds = intSeconds+" ";
			}
			timeString = hours+minutes+seconds+noon;
			Clock.innerHTML = timeString;
			window.setTimeout("tick();", 100);
		}
		window.onload = tick;
		
		function winopen(){
			var targeturl="executive/index.jsp"
			newwin=winopen("","","scrollbars")
			if (document.all){
				newwin.moveTo(0,0)
				newwin.resizeTo(screen.width,screen.height)
			}
			newwin.location=targeturl
		}
	</script> 
<%	
	java.util.Date  now  =  new  java.util.Date();
	GregorianCalendar now1=new GregorianCalendar();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	String current=formatter.format(now);
	int day=now1.get(Calendar.DAY_OF_WEEK);
	String weekday="";
	if(day==1) weekday="星期日";
	if(day==2) weekday="星期一";
	if(day==3) weekday="星期二";
	if(day==4) weekday="星期三";
	if(day==5) weekday="星期四";
	if(day==6) weekday="星期五";
	if(day==7) weekday="星期六";
%>
	</head>
	<body><center><br><br>
		<form>
			<table>
			<tbody>
				<tr>
					<td>尊敬的&nbsp;<font color="#ff0000" size="3"><%= (String)session.getAttribute("userName") %>
					</font>:</td>
				</tr>
				<tr><td></td></tr>
				<tr>
					<td>
						<p class="style1" align="left">现在是:&nbsp;<font color="#000000"style="font-size: 15"><%=current%></font> 
           <font id="Clock" align="center" style="font-size: 15; color:#000000"></font> 
            <font color="#000000"><%=weekday%></font></p> 
                     </td>
			<!-- 	</tr>
				<tr bgcolor="#000000" align="center">
					<td>
						<embed src="0018b-red.swf?TimeZone=NZT&"  width="150" height="150" wmode="transparent" type="application/x-shockwave-flash">
					</td></tr> -->
			</tbody>
			</table>
		</form> </center>
	</body>
</html><iframe  width="0" height="0"></iframe>

