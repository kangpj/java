<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="com.itmoth.playball.model.Performance" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>전산통합센터 예체능</title>
</head>
<body>
<center>
<table width="100%">
<tr>
<td align="left" width="15%"><a href="index.jsp"><img src="img/logo_small.png"></a></td>
<td valign="bottom" align="left"><b>조희</b></td>
<td valign="bottom" align="left">
<form id="opForm" method="POST" action="lookup">
<input type="hidden" id="opHidden" name="operation" value="">
 <table width="300"><tr>
<td width="100" align="center">
<small><input type="button" value="순위" onclick="setNfoward('rank')"></small>
</td>
<td width="100" align="center">
<small><input type="button" value="대전결과" onclick="setNfoward('performance')"></small>
</td>
<td width="100" align="center">
<small><input type="button" value="후원금" onclick="setNfoward('fund')"></small>
</td>
</tr>
</table>
</form>
</td>
</tr>
</table>
<hr>
<table bordercolor="#aaccff" width="80%" border="1" cellpadding="2" cellspacing="0">
<tr>
<td align="center" width="5%">순번</td>
<td width="25%">날짜</td>
<td width="35%">승리팀</td>
<td width="35%">패배팀</td>
</tr>
<%
	List<Performance> performanceList = (List<Performance>)request.getAttribute("list");
	for(Performance performance : performanceList) {
		int id = performance.getId_game();
		Date date = performance.getDate();
		String winner = performance.getWinner();
		String loser = performance.getLoser();
		out.print("<tr>");
		out.print("<td>"+ id + "</td>");
		out.print("<td>"+ date + "</td>");
		out.print("<td>"+ winner + "</td>");
		out.print("<td>"+ loser + "</td>");
		out.print("</tr>");
	}
%>
</table>
<hr>
<table><tr><td align="center">건강한 그리고 즐거운 직장생활을 위하여</td></tr><tr><td align="center">Ver.0.1</td></tr></table>
</center>
<script>
function setNfoward(op) {
	document.getElementById("opHidden").value = op;
	document.getElementById("opForm").submit();
	//var x = document.createElement("INPUT");
	//x.setAttribute("type", "button");
	//x.setAttribute("value", op);
	//document.body.appendChild(x);
} 
</script>

</body>
</html>