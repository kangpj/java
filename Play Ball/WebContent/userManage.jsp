<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.itmoth.playball.model.User" %>
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
<td valign="bottom" align="left"><b>관리</b></td>
<td valign="bottom" align="left">
 <table width="400"><tr>
<td width="100" align="center">
<form method="POST" action="dept"><small><input type="submit" value="기관"></small></form>
</td>
<td width="100" align="center"><font color="#3366aa">&lt;선수&gt;</font></td>
<td width="100" align="center">
<form method="POST" action="sport"><small><input type="submit" value="종목"></small></form>
</td>
<td width="100" align="center">
<form method="POST" action="fund"><small><input type="submit" value="후원"></small></form>
</td>
</tr>
</table>
</td>
</tr>
</table>
<hr>
<form id="opForm" method="POST" action="userManage">
<table bordercolor="#aaccff" width="80%" border="1" cellpadding="2" cellspacing="0">
<tr>
<td align="center" width="5%">선택</td>
<td width="25%">이름</td>
<td width="20%">성별</td>
<td width="20%">별칭</td>
<td width="20%">수준</td>
<td width="10%">참가여부</td>
</tr>
<%
	List<User> users = (List<User>)request.getAttribute("list");
	for(User user : users) {
		String name = user.getName_user();
		String id = user.getId_user();
		String gender = user.getGender_user();
		String league = user.getLeague_user();
		out.print("<tr>");
		out.print("<td align=\"center\"><input name=\"checkId\" id=\""+ id +"Check\" value=\"" + id + "\" type=\"checkbox\" onclick=\"switchMod('"+id+"')\"></td>");
		out.print("<td><input name=\"" + id + "\" id=\""+ id +"Name\" value=\""+ name +"\" readonly></td>");
		//out.print("<td><input name=\"" + id + "\" id=\""+ id +"Gender\" value=\""+ gender +"\" readonly></td>");
		out.print("<td>");
		out.print("<select name=\"" + id + "\" id=\""+ id + "Gender\" disabled>");
		if ("MALE".equals(gender))
			out.print("<option value=\"MALE\" selected>남자</option>");
		else 
			out.print("<option value=\"MALE\">남자</option>");
		if ("FEMALE".equals(gender))
			out.print("<option value=\"FEMALE\" selected>여자</option>");
		else
			out.print("<option value=\"FEMALE\">여자</option>");
		out.print("</select>");
		out.print("</td>");
		out.print("<td><input name=\"" + id + "\" id=\""+ id +"Id\" value=\""+ id +"\" readonly></td>");
		//out.print("<td><input name=\"" + id + "\" id=\""+ id +"League\" value=\""+ league +"\" readonly></td>");
		out.print("<td>");
		out.print("<select name=\""+ id + "\" id=\""+ id + "League\" disabled>");
		if ("MAJOR".equals(league))
			out.print("<option value=\"MAJOR\" selected>Major</option>");
		else 
			out.print("<option value=\"MAJOR\">Major</option>");
		if ("MINOR".equals(league))
			out.print("<option value=\"MINOR\" selected>Minor</option>");
		else
			out.print("<option value=\"MINOR\">Minor</option>");
		out.print("</select>");
		out.print("</td>");		
		if (user.isParticipant_user() == true)
			out.print("<td><input name=\"" + id + "\" id=\"" + id + "Participant\" type=\"checkbox\" checked disabled></td>");
		else
			out.print("<td><input name=\"" + id + "\" id=\"" + id + "Participant\" type=\"checkbox\" disabled></td>");
		out.print("</tr>");
	}
%>
</table>
<input type="hidden" id="opHidden" name="operation" value="">
<table width="400"><tr>
<td width="100" align="center">
<small><input type="button" value="등록" onclick="setNfoward('create')"></small>
</td>
<td width="100" align="center">
<small><input type="button" value="수정" onclick="setNfoward('update')"></small>
</td>
<td width="100" align="center">
<small><input type="button" value="탈퇴" onclick="setNfoward('delete')"></small>
</td>
</tr>
</table>
</form>
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
function switchMod(id) {
	var x = document.getElementById(id + "Check");
	if(x.checked) {
		x = document.getElementById(id + "Name");
		x.removeAttribute("readOnly");
		x = document.getElementById(id + "Gender");
		x.removeAttribute("disabled");
		x = document.getElementById(id + "Id");
		x.removeAttribute("readOnly");
		x = document.getElementById(id + "League");
		x.removeAttribute("disabled");
		x = document.getElementById(id + "Participant");
		x.removeAttribute("disabled");
	} else {
		document.getElementById(id + "Name").readOnly=true;
		document.getElementById(id + "Gender").disabled=true;
		document.getElementById(id + "Id").readOnly=true;
		document.getElementById(id + "League").disabled=true;
		document.getElementById(id + "Participant").disabled=true;
	}
	
}
</script>
</body>
</html>