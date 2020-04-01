<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Страница подтверждения успешной регистрации посетителя</title>
    </head>
    <body>
    <h1>Регистрация посетителя успешно завершена</h1>
<table>
	<tr>
		<td>FirstName</td>
		<td><c:out value="${userSave.firstName}"/></td>
	</tr> 
	<tr>
		<td>LastName</td>
		<td><c:out value="${userSave.lastName}"/></td>
	</tr> 
	<tr>
		<td>Email</td>
		<td><c:out value="${userSave.email}"/></td>
	</tr> 
	<tr>
		<td>Phone</td>
		<td><c:out value="${userSave.phone}"/></td>
	</tr> 
</table>
   <a href=${pageContext.request.contextPath}/login.jsp">Войти в систему</a>
    </body>
</html>