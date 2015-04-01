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
<%
	List<User> users = (List<User>)request.getAttribute("list");
	out.print("<table>");
	for(User user : users) {
		out.print("<tr><td>이름</td><td>" + user.getId_user() + "</td></tr>");
		out.print("<tr><td>성별</td><td>" + user.getGender_user() + "</td></tr>");
		out.print("<tr><td>별칭</td><td>" + user.getId_user() + "</td></tr>");
		out.print("<tr><td>인증키</td><td>" + user.getAuthKey_user() + "</td></tr>");
		out.print("<tr><td>수준</td><td>" + user.getLeague_user() + "</td></tr>");		
	}
	out.print("</table>");
%>
</body>
</html>