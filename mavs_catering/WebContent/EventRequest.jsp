<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <form name="EventRequestForm" action="UserController?action=BookEvent" method="post">
    <table>
	<tr>
		<td>Date: </td>
			<td>
				<input type="date" id="iddate" value="<c:out value='${currenttime}' />" name="iddate">
				<td> <input name="selecteddatetimeerror"  value="<c:out value='${TIMEERROR.timeerror}'/>" type="text"  style ="color: red; border: none;"> </td>
	</tr>
	<tr>
		<td>Time: </td>
			<td>
				<input type="time" id="idtime" value="hh:mm:ss" name="idtime">
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


