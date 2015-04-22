<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.itmoth.playball.model.Participant" %>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>전산통합센터 예체능</title>
<link rel="stylesheet" href="/resources/demos/style.css" />  
  <script type='text/javascript' src='https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js'></script>
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

<script type='text/javascript'>
$(window).load(function(){
$(document).ready(function() {
    $('#btnRight').click(function(e) {
        var selectedOpts = $('#lstBoxEven option:selected');
        if (selectedOpts.length == 0) {
            alert("Nothing to move.");
            e.preventDefault();
        }

        $('#lstBoxOdd').append($(selectedOpts).clone());
        $(selectedOpts).remove();
        e.preventDefault();
    });

    $('#btnLeft').click(function(e) {
        var selectedOpts = $('#lstBoxOdd option:selected');
        if (selectedOpts.length == 0) {
            alert("Nothing to move.");
            e.preventDefault();
        }

        $('#lstBoxEven').append($(selectedOpts).clone());
        $(selectedOpts).remove();
        e.preventDefault();
    });
});
});
</script>
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
<form method="post" action="/team">  
<table border="0" style='width:370px;'>
    <tr>
        <td rowspan="2" align="center" style='width:160px;'>
        <b><font color="green">A팀</font></b><br/>
        <select multiple="multiple" id='lstBoxEven'>
<%
	List<Participant> participantList = (List<Participant>)request.getAttribute("list");
	for(Participant participant : participantList) {
		String id = participant.getId_user();
		String name = participant.getName_user();
		char group = participant.getName_group();
		if (group == 'A') {
			out.print("<option value=\"" + id + "\">" + name + "</option>");
		}
	}
%>        
        </select>
    </td>
    <td style='height:50px;width:50px;text-align:center;vertical-align:bottom;'>
        <input type='button' id='btnRight' value ='  >  '/>
    </td>
    <td rowspan="2" align="center" style='width:160px;'>
        <b><font color="blue">B팀</font></b><br/>
        <select multiple="multiple" id='lstBoxOdd'>
<%
	//List<Participant> participantList = (List<Participant>)request.getAttribute("list");
	for(Participant participant : participantList) {
		String id = participant.getId_user();
		String name = participant.getName_user();
		char group = participant.getName_group();
		if (group == 'B') {
			out.print("<option value=\"" + id + "\">" + name + "</option>");
		}
	}
%>               
		</select>
    </td>
</tr>
<tr>
    <td style='height:50px;width:50px;text-align:center;vertical-align:top;'>
        <input type='button' id='btnLeft' value ='  <  '/>
    </td>
</tr>
<tr>
        <td align="center" colspan="3">
          <input type="submit" value="저장">        </td>
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
</script>

</body>
</html>