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
		out.print("<tr>");
		out.print("<td align=\"center\"><input name=\"" + user.getId_user() + "\" type=\"checkbox\"></td>");
		out.print("<td>" + user.getName_user() + "</td>");
		out.print("<td>" + user.getGender_user() + "</td>");
		out.print("<td>" + user.getId_user() + "</td>");
		out.print("<td>" + user.getLeague_user() + "</td>");
		if (user.isParticipant_user() == true)
			out.print("<td><input name=\"" + user.getId_user() + "\" type=\"checkbox\" checked disabled></td>");
		else
			out.print("<td><input name=\"" + user.getId_user() + "\" type=\"checkbox\" disabled></td>");
		out.print("</tr>");
	}
%>
</table>

 <table width="400"><tr>
<td width="100" align="center">
<form method="POST" action="addUser.jsp"><small><input type="submit" value="등록"></small></form>
</td>
<td width=100" align="center">
<form method="POST" action="modifyUser"><small><input type="submit" value="수정"></small></form>
</td>
<td width="100" align="center">
<form method="POST" action="deleteUser"><small><input type="submit" value="탈퇴"></small></form>
</td>
</tr>
</table>
<hr>
<table><tr><td align="center">건강한 그리고 즐거운 직장생활을 위하여</td></tr><tr><td align="center">Ver.0.1</td></tr></table>
</center>
</body>
</html>