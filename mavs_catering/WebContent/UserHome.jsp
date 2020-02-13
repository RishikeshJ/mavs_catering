<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Home Page</title>
</head>
<body>
<header>
        <h1>User Home Page</h1>
        <p>Welcome <c:out value="${userid}" /></p>
    </header>
    <table class="center">
    <tr>
		<td><a href="/mavs_catering/UserController?action=EventRequest" target="_top" style="margin-left: 118px;"> Request an event </a></td>
	</tr>
	<tr>
    	<td><a href="/mavs_catering/UserController?action=EventRequest" target="_top" style="margin-left: 118px;"> View My Event Summary </a></td>
    </tr>
    </table>
</body>
</html>