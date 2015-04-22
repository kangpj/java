<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.itmoth.playball.model.Sport" %>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>전산통합센터 예체능</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.0/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.10.0/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css" />
<script type="text/javascript">
 $(function() { 
  $(".datepicker").datepicker({
	dateFormat: 'yy-mm-dd',
	monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
     dayNamesMin: ['일','월','화','수','목','금','토'],
	 changeMonth: true, //월변경가능
     changeYear: true, //년변경가능
	 showMonthAfterYear: true, //년 뒤에 월 표시
  });
 });
</script>
  <style type='text/css'>
    body
{
    padding:0px;
    font-family:verdana;
    font-size:8pt;
}

select
{
    font-family:verdana;
    font-size:8pt;
    width : 150px;
    height:100px;
}
input
{
    text-align: center;
    v-align: middle;
}
  </style>

</head>
<body>
<center>
<table width="100%">
<tr>
<td align="left" width="15%"><a href="index.jsp"><img src="img/logo_small.png"></a></td>
<td valign="bottom" align="left"><b>기획</b></td>
<td valign="bottom" align="left">
<form id="opForm" method="POST" action="plan">
<input type="hidden" id="opHidden" name="operation" value="">
 <table width="300"><tr>
<td width="100" align="center">
<small><input type="button" value="새 경기" onclick="setNfoward('gamePlan')"></small>
</td>
<td width="100" align="center">
<small><input type="button" value="대전표 작성" onclick="setNfoward('matchPlan')"></small>
</td>
</tr>
</table>
</form>
</td>
</tr>
</table>
<hr>
<table bordercolor="#aaccff" width="50%" border="0" cellpadding="2" cellspacing="0">
<tr>
<td align="right">종목</td>
<td>
<select name="sport">
<%
	List<Sport> sportList = (List<Sport>)request.getAttribute("list");
	for(Sport sport : sportList) {
		long id = sport.getId_sport();
		String name = sport.getName_sport();
		out.print("<option value=\"" + id + "\">" + name + "</option>");
	}
%>
</select>
</td>
<td align="right">일자</td>
<td>
<input name="gameDate" type="text" class="datepicker"/>
</td>
<td align="right">게임비</td>
<td>
<select name="due">
<option value="1000">1000</option>
<option value="2000">2000</option>
<option value="3000">3000</option>
<option value="4000">4000</option>
<option value="5000">5000</option>
</select>
<td>
<small><input type="submit" value="만들기"></small>
</td>
</tr>
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