<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h3>Regisration</h3>
<form action="${pageContext.request.contextPath}/registration" method="post">
<table style="with: 50%">
	<tr>
		<td>First Name</td>
		<td><input type="text" name="firstName" /></td>
	</tr>
	<tr>
		<td>Last Name</td>
		<td><input type="text" name="lastName" /></td>
	</tr>
	<tr>
    		<td>e-mail</td>
    		<td><input type="text" name="email" /></td>
    	</tr>
    	<tr>
        	<td>telephone</td>
        	<td><input type="text" name="telephone" /></td>
        </tr>
    	<tr>
		<td>Login</td>
		<td><input type="text" name="login" /></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input type="password" name="password" /></td>
	</tr>
	<tr>
		<td><button type="submit" name="Save"> Save</button></td>
		<td><button type="submit" name="Cancel" >Cancel</button></td>
	</tr>
</table>


</form>