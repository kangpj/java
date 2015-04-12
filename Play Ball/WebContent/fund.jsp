<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="com.itmoth.playball.model.Funding" %>    
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
<small><input type="button" value="개인성적" onclick="setNfoward('performance')"></small>
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
<td align="center" width="10%">순번</td>
<td width="15%">날짜</td>
<td width="10%">입금액</td>
<td width="10%">출금액</td>
<td width="45%">명단</td>
<td width="10%">모금액</td>
</tr>
<%
	List<Funding> fundingList = (List<Funding>)request.getAttribute("list");
	for(Funding item : fundingList) {
		int rank = item.getRank();
		Date ilja = item.getDate();
		BigDecimal invest = item.getSum_invest();
		BigDecimal withdraw = item.getSum_withdraw();
		String investor = item.getInvestor();
		BigDecimal balance = item.getBalance();
		out.print("<tr>");
		out.print("<td>"+ rank + "</td>");
		out.print("<td>"+ ilja + "</td>");
		out.print("<td>"+ invest + "</td>");
		out.print("<td>"+ withdraw + "</td>");
		out.print("<td>"+ investor + "</td>");
		out.print("<td>"+ balance + "</td>");
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