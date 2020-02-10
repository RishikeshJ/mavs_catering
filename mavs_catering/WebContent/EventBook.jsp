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
<h2>Event request form</h2>
<table>
  <tr>
   <td>
    <form name="EventbookingForm" action="EventController?action=BookEvent" method="post">
    <table style="width: 1200px; ">
    
    <tr>
    <td> Last Name: </td>
    <td> <input name="lastName" value="<c:out value='${Event.lastName}'/>" type="text" maxlength="50"> </td>
  	<td> <input name="lastNameError"  value="<c:out value='${errorMsgs.lastNameError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    </tr>
    
	<tr>
    <td> First Name: </td>
    <td> <input name="firstName" value="<c:out value='${Event.firstName}'/>" type="text" maxlength="50"> </td>
  	<td> <input name="firstNameError"  value="<c:out value='${errorMsgs.firstNameError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
		<td>Date: </td>
			<td>
				<input type="date" id="iddate" name="iddate">
			</td>
	</tr>
	
	<tr>
		<td>Time: </td>
			<td>
				<input type="time" id="startTime" name="idtime">
			</td>
	</tr>
    

    <tr>
    <td> Duration: </td>
    <td><select name="duration" >
      <option id="2" value="2">2</option>
      <option id="3" value="3">3</option>
      <option id="4" value="4">4</option>
      <option id="5" value="5">5</option>
      <option id="6" value="6">6</option>
      <option id="7" value="7">7</option>
      <option id="8" value="8">8</option>
    </select>
   	</tr>
    
    <tr>
    <td> Hall Name: </td>
    <td><select name="hallName" >
      <option id="Maverick" value="Maverick">Maverick</option>
      <option id="KC" value="KC">KC</option>
      <option id="Arlington" value="Arlington">Arlington</option>
      <option id="Shard" value="Shard">Shard</option>
      <option id="Liberty" value="Shard">Shard</option>
    </select>
   	</tr>
   	
   	<tr>
    <td> Estimated Attendees: </td>
    <td> <input name="estAttendees" value="<c:out value='${Event.estAttendees}'/>" type="text" maxlength="16">  </td>
  	<td> <input name="passwordError"  value="<c:out value='${errorMsgs.passwordError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
   	
   	<tr>
    <td> Event Name: </td>
    <td> <input name="eventName" value="<c:out value='${Event.eventName}'/>" type="text" maxlength="10">  </td>
  	<td> <input name="utaIdError"  value="<c:out value='${errorMsgs.utaIdError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> Food Type: </td>
    <td><select name="foodType" >
      <option id="American" value="American">American</option>
      <option id="Chinese" value="Chinese">Chinese</option>
      <option id="French" value="French">French</option>
      <option id="Greek" value="Greek">Greek</option>
      <option id="Indian" value="Indian">Indian</option>
      <option id="Italian" value="Italian">Italian</option>
      <option id="Japanese" value="Japanese">Japanese</option>
      <option id="Mexican" value="Mexican">Mexican</option>
      <option id="Pizza" value="Pizza">Pizza</option>
    </select>
   	</tr>
   	
   	<tr>
    <td> Meal: </td>
    <td><select name="meal" >
      <option id="Breakfast" value="Breakfast">Breakfast</option>
      <option id="Lunch" value="Lunch">Lunch</option>
      <option id="Supper" value="Supper">Supper</option>
    </select>
   	</tr>
   	
   	<tr>
    <td> Meal Formality: </td>
    <td><select name="mealFormality" >
      <option id="Formal" value="Formal">Formal</option>
      <option id="Informal" value="Informal">Informal</option>
    </select>
   	</tr>
   	
   	<tr>
    <td> Drink Type: </td>
    <td><select name="drinkType" >
      <option id="Standard" value="Standard">Standard</option>
      <option id="Alcohol" value="Alcohol">Alcohol</option>
    </select>
   	</tr>
   	
   	<tr>
    <td> Entertainment items: </td>
    <td><select name="entertainmentItems" >
      <option id="music" value="music">Music</option>
      <option id="non-music" value="non-music">Non-Music</option>
    </select>
   	</tr>
   	
    </table>
    <input type="submit" value="Book Event">
    </form>
</td>
</tr>
</table>
</body>
</html>