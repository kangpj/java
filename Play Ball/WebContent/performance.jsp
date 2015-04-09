<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="com.itmoth.playball.model.Ranking" %>    
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
<form method="POST" action="lookup">
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
<td align="center" width="10%">순위</td>
<td width="20%">이름</td>
<td width="15%">출경기수</td>
<td width="10%">승</td>
<td width="10%">패</td>
<td width="10%">승률(%)</td>
<td width="10%">부과금액</td>
<td width="10%">납부금액</td>
</tr>
<%
	List<Ranking> rankingList = (List<Ranking>)request.getAttribute("list");
	for(Ranking ranking : rankingList) {
		String name = ranking.getName();
		String id = ranking.getId();
		int win = ranking.getWinNum();
		int lose = ranking.getLoseNum();
		int participate = ranking.getParticipateNum();
		int rank = ranking.getRank();
		int rate = ranking.getRatePercent();
		BigDecimal charge = ranking.getChargeDec();
		BigDecimal payment = ranking.getPaymentDec();
		out.print("<tr>");
		out.print("<td>"+ rank + "</td>");
		out.print("<td>"+ name + "</td>");
		out.print("<td>"+ participate + "</td>");
		out.print("<td>"+ win + "</td>");
		out.print("<td>"+ lose + "</td>");
		out.print("<td>"+ rate + "</td>");
		out.print("<td>"+ charge +"</td>");
		out.print("<td>"+ payment + "</td>");
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