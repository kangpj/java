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
<table bordercolor="#bfdff0" width="20%" border="1" cellpadding="2" cellspacing="0">
<tr><td align="right" width="35%">이름</td><td><input type="text" name="name"></td></tr>
<tr><td align="right" >성별</td>
<td>
<select name="gender">
<option value="MALE">남자</option>
<option value="FEMALE">여자</option>
</select>
</td></tr>
<tr><td align="right" >별칭</td><td><input type="text" name="id"></td></tr>
<tr><td align="right" >비밀번호</td><td><input type="text" name="authKey"></td></tr>
<tr><td align="right" >수준</td><td><input type="text" name="league"></td></tr>
<tr><td align="right" >참가여부</td>
<td>
<select name="participant">
<option value="true">참가</option>
<option value="false">불참</option>
</select>
</td></tr>
<tr>
<td align="right"><form method="POST" action="addUser"><input type="submit" value="등록"></form></td><td></td>
</table>
<hr>
<table><tr><td align="center">건강한 그리고 즐거운 직장생활을 위하여</td></tr><tr><td align="center">Ver.0.1</td></tr></table>
</center>
</body>
</html>