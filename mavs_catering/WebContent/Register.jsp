b<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
<div class="logo"><h1><a href="<c:url value='/' />">Mavs Catering System</a></h1></div>
<h2>Registration Form</h2>
<input name="errMsg"  value="<c:out value='${errorMsgs.errorMsg}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
<table>
  <tr>
   <td>
    <form name="registrationForm" action="RegistrationController" method="post">
    <table style="width: 1200px; ">
    
    
    <tr>
    <td> Username (*): </td>
    <td> <input name="username" value="<c:out value='${User.username}'/>" type="text" maxlength="16">  </td>
  	<td> <input name="usernameError"  value="<c:out value='${errorMsgs.usernameError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> Password (*): </td>
    <td> <input name="password" type="password" value="<c:out value='${User.password}'/>" type="text" maxlength="16">  </td>
  	<td> <input name="passwordError"  value="<c:out value='${errorMsgs.passwordError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> Role: </td>
    <td><select name="role" >
      <option id="Caterer Manager" value="Caterer Manager">Caterer Manager</option>
      <option id="User" value="User">User</option>
      <option id="Caterer staff" value="Caterer staff">Caterer staff</option>
      <option id="Admin" value="Admin">Admin</option>
    </select>
   	</tr>
   	
   	<tr>
    <td> UTA ID (*): </td>
    <td> <input name="utaId" value="<c:out value='${User.utaId}'/>" type="text" maxlength="10">  </td>
  	<td> <input name="utaIdError"  value="<c:out value='${errorMsgs.utaIdError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> First Name (*): </td>
    <td> <input name="firstName" value="<c:out value='${User.firstName}'/>" type="text" maxlength="50"> </td>
  	<td> <input name="firstNameError"  value="<c:out value='${errorMsgs.firstNameError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    </tr>

    <tr>
    <td> Last Name (*): </td>
    <td> <input name="lastName" value="<c:out value='${User.lastName}'/>" type="text" maxlength="50"> </td>
  	<td> <input name="lastNameError"  value="<c:out value='${errorMsgs.lastNameError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> Phone : </td>
    <td> <input name="phone" value="<c:out value='${User.phone}'/>" type="text" maxlength="50"> </td>
  	<td> <input name="phoneError"  value="<c:out value='${errorMsgs.phoneError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    </tr>
  
    <tr>
    <td> Email : </td>
    <td> <input name="email" value="<c:out value='${User.email}'/>" type="text" maxlength="45">  </td>
  	<td> <input name="emailError"  value="<c:out value='${errorMsgs.emailError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> Street Number : </td>
    <td> <input name="streetNumber" value="<c:out value='${User.streetNumber}'/>" type="text" maxlength="45">  </td>
  	<td> <input name="addressError"  value="<c:out value='${errorMsgs.addressError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> Street Name : </td>
    <td> <input name="streetName" value="<c:out value='${User.streetName}'/>" type="text" maxlength="45">  </td>
  	<td> <input name="addressError"  value="<c:out value='${errorMsgs.addressError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> City : </td>
    <td> <input name="city" value="<c:out value='${User.city}'/>" type="text" maxlength="45">  </td>
  	<td> <input name="addressError"  value="<c:out value='${errorMsgs.addressError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> State : </td>
    <td> <input name="state" value="<c:out value='${User.state}'/>" type="text" maxlength="45">  </td>
  	<td> <input name="addressError"  value="<c:out value='${errorMsgs.addressError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> Zipcode : </td>
    <td> <input name="zipcode" value="<c:out value='${User.zipcode}'/>" type="text" maxlength="45">  </td>
  	<td> <input name="addressError"  value="<c:out value='${errorMsgs.addressError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    
    <tr>
    <td colspan="2"><i>(*) Mandatory field</i></td>
    </tr>
    </table>
    <input type="submit" value="Register">
    </form>
</td>
</tr>
</table>
</body>
</html>