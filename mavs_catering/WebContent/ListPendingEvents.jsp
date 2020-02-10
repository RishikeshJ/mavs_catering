<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Pay Deposit for the reservation</h1>
 
  <form action="/mav_catering/EventController?action=PayDeposit" method="post">          
       <table border="1" class="myTable"> 
			<tr class="myTableRow"> 
				<th class="myTableHead" style="padding-right: 20px; text-align: left">Last Name</th>
				<th class="myTableHead" style="padding-right: 35px; text-align: left">First Name</th> 
				<th class="myTableHead" style="padding-right: 20px; text-align: left">Date</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">Start Time</th> 
				<th class="myTableHead" style="padding-right: 30px; text-align: left">Duration</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">Hall Name</th> 
				<th class="myTableHead" style="padding-right: 30px; text-align: left">Attendees</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">Event Name</th> 
				<th class="myTableHead" style="padding-right: 30px; text-align: left">Food Type</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">Meal</th> 
				<th class="myTableHead" style="padding-right: 30px; text-align: left">Meal Formality</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">Drink Type</th> 
				<th class="myTableHead" style="padding-right: 30px; text-align: left">Entertainment Items</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">Event ID</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">Reserve Event</th>
			</tr>
			<c:forEach items="${PendingEvents}" var="item" varStatus="status">
				<tr class="myTableRow">
				<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.lastName}" /></td>
				<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.firstName}" /></td>
				<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.date}" /></td>
				<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.startTime}" /></td>
				<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.duration}" /></td>
				<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.hallName}" /></td>
				<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.estAttendees}" /></td>
				<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.eventName}" /></td>
				<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.foodType}" /></td>
				<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.meal}" /></td>
				<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.mealFormality}" /></td>
				<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.drinkType}" /></td>
				<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.entertainmentItems}" /></td>
				<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.eventID}" /></td>
				<td>
					<a href="<c:url value='/EventController?action=viewSepcificEvent&eventID=${item.eventID}'/>">Pay Deposit</a>
				</td>
				
				</tr>
			</c:forEach>
 </table>
<input name="PayDeposit" type="submit" value="Submit">
 </form>
</body>
</html>