<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>시합관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
  body {
    padding:0px;
    font-familly:vernada;
    font-size:8pt;
  }
</style>
</head>
<body>
<center>
<table width="100%">
<tr>
<td align="left"><a href="/menu.jsp"><img src="img/logo_small.png"></a></td>
</tr>
</table>
<table border="1" width="300" height="50">
  <tr><td align="center" bgcolor="white"><b>시합관리</b></td></tr>
</table>
<br><br>
<table width="400" height="35"><tr>
<td width="100" align="center" bgcolor="orange">
<form method="POST" action="match.html">
종목
<select name="events">
<option value="jokgu">족구</option>
<option value="billiard">당구</option>
<option value="bowling">볼링</option>
<option value="golf">골프</option>
</select>
날짜
<input name="ilja" type="text" class="datepicker"/>
<small><input type="submit" value="만들기"></small>
</form>
</td>
</tr>
</table>
</center>
</body>
</html>
