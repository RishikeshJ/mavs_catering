<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
  <tr>
   <td>
    <form name="EventRequestForm" action="UserController" method="post">
    <table style="width: 1200px; ">
	<tr>
		<td>Date: </td>
			<td>
				<input type="date" id="iddate" name="iddate">
			</td>
	</tr>
	<tr>
		<td>Time: </td>
			<td>
				<input type="time" id="idtime" name="idtime">
			</td>
	</tr>
    </table>
    <input name="NextBtn" type="submit" value="Next">
    </form>
</td>
</tr>
</table>
</body>
</html>


