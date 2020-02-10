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
  <form action="/mav_catering/EventController?action=PayDeposit" method="post">          
       <table border="1" class="myTable"> 
			<tr>
			<th class="myTableHead" style="padding-right: 35px; text-align: left">First Name</th>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${EVENT.firstName}" /></td>
			</tr>
			
			<tr>
			<th class="myTableHead" style="padding-right: 20px; text-align: left">Last Name</th>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${EVENT.lastName}" /></td>
			</tr>
			
			<tr>
			<th class="myTableHead" style="padding-right: 20px; text-align: left">Date</th>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${EVENT.date}" /></td>
			</tr>
			
			<tr>
			<th class="myTableHead" style="padding-right: 30px; text-align: left">Start Time</th>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${EVENT.startTime}" /></td>
			</tr>
			
			<tr>
			<th class="myTableHead" style="padding-right: 30px; text-align: left">Duration</th>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${EVENT.duration}" /></td>
			</tr>
			
			<tr>
			<th class="myTableHead" style="padding-right: 30px; text-align: left">Hall Name</th>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${EVENT.hallName}" /></td>
			</tr>
			
			<tr>
			<th class="myTableHead" style="padding-right: 30px; text-align: left">Attendees</th>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${EVENT.estAttendees}" /></td>
			</tr>
			
			<tr>
			<th class="myTableHead" style="padding-right: 30px; text-align: left">Event Name</th>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${EVENT.eventName}" /></td>
			</tr>
			
			<tr>
			<th class="myTableHead" style="padding-right: 30px; text-align: left">Food Type</th>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${EVENT.foodType}" /></td>
			</tr>
			
			<tr>
			<th class="myTableHead" style="padding-right: 30px; text-align: left">Meal Formality</th>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${EVENT.meal}" /></td>
			</tr>
			
			<tr>
			<th class="myTableHead" style="padding-right: 30px; text-align: left">Meal</th>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${EVENT.mealFormality}" /></td>
			</tr>
			
			<tr>
			<th class="myTableHead" style="padding-right: 30px; text-align: left">Drink Type</th>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${EVENT.drinkType}" /></td>
			</tr>
			
			<tr>
			<th class="myTableHead" style="padding-right: 30px; text-align: left">Entertainment Items</th>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${EVENT.entertainmentItems}" /></td>
			</tr>
			
				<%-- <tr><td class="myTableCell" style="padding-right: 20px; "><c:out value="${EVENT.eventID}" /></td></tr> --%>
				
 </table>
 </form>
 
 <form action="/mav_catering/EventController?action=PayFinalDeposit" method="post">
    <table style="width: 1200px; ">
 <tr>
	<td> Card Number : </td>
	<td> <input name="idccNum" value="" type="text" maxlength="16"> </td>
	<td style="padding:0px"><input name="statusError"  value="<c:out value='${errorMsgs.ccError}'/>" type="text"  style ="border: none;margin-left:100;width:185px"   disabled="disabled" maxlength="120">		        
</tr>
<tr>
	<td> Security Code : </td>
	<td> <input name="idccvNum" value="" type="text" maxlength="16"> </td>
	<td style="padding:0px"><input name="statusError"  value="<c:out value='${errorMsgs.ccvError}'/>" type="text"  style ="border: none;margin-left:100;width:185px"   disabled="disabled" maxlength="120">		        
</tr>
<tr>
	<td> Exp Date : </td>
	<td> <input name="idexpDate" value="" type="text" maxlength="16"> </td>
	<td style="padding:0px"><input name="statusError"  value="<c:out value='${errorMsgs.ccvError}'/>" type="text"  style =" border: none;margin-left:100;width:185px"   disabled="disabled" maxlength="120">		        
</tr>
   
    </table>
    <a href="<c:url value='/EventController?action=PayFinalDeposit&eventID=${REGISTEREVENT.eventID}'/>">Pay Deposit</a>
 </form>

 
</body>
</html>