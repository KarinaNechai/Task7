﻿<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Пользователи, зарегистрированные в системе</title>
 	<h1>Пользователи, зарегистрированные в системе</h1>
    </head>
    <body>
<form action="${pageContext.request.contextPath}/Admin" method="post">
<table >
   <tr>
         <td>FirstName</th>
         <td>LastName</th>
         <td>Email</th>
         <td>Phone</th>
  </tr>                           
  <c:forEach items="${users}" var="user">
       <tr>
             <td> <%if (userUpdate.user.login== user.login) {
                out.println(<input id="login" type="text" name="login" value=${user.firstName}/>);
            }%>
${user.firstName}</td>
             <td> ${user.lastName}</td>
             <td> ${user.email}</td>
             <td> ${user.phone}</td>
<td><button type="submit" value=${user.login} name="Update"> Update</button></td>
<td><button type="submit" name="Delete" value=${user.login}>Delete</button></td>
</tr>
   
</c:forEach>
</table>
<div id="zatemnenie">
      <div id="okno">

        Всплывающее окошко!<br>
        <a href="#" class="close">Закрыть окно</a>
      </div>
    </div>
<a href=${pageContext.request.contextPath}/login.jsp">Войти в систему</a>
</form>
</body>
</html>