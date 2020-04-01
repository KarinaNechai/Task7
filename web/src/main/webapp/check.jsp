<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Блоки div в HTML</title>
    <style>
      .example_main_div div {
        border: 1px solid black;
        margin: 1px;
        padding: 1px;
      }
      .example_content2 {
        height: 100px;
 	    width: 67.00%;
		float: right;
      }
      .example_content {
        height: 100px;
 	    width: 33.00%;
		float: left;
      }
    </style>
  </head>
	<body>
		<div class="example_content">
			<h3>Input new check</h3>
			<p style="color: red"><c:out value="${user.getFirstName()}" default="" /></p>
			<form action="${pageContext.request.contextPath}/check" method="post">
				<table style="with: 50%">
				<tr>
					<td>
						<input type="radio" name="rdo" value="REVENUE"> revenue<br>
					</td>
					<td>
						<input type="radio" name="rdo" value="EXPENCES" checked> expenses<br>
					</td>
				</tr>
				<tr>
					<td>
						date
					</td>
					<td>
						<input 'fmt:formatDate type="date" value="${now}" pattern="yyyy-MM-dd" required id="date" name="date"'/>
					</td>
				</tr>
				<tr>
					<td>sum</td>
					<td><input type="number" required name="sum" value="0" /></td>
				</tr>
				<tr>
					<td>text</td>
					<td><input type="text" name="text" value="0"/></td>
				</tr>
				<tr>
					<td><button type="submit" name="AddCheck" >AddCheck</button></td></td>
				</tr>
			</table>
			</form>
		</div>
		<div class="example_content2">
		<h3>Your balance</h3>
		<form action="${pageContext.request.contextPath}/check" method="post">
				<table style="with: 50%" border = "1">
				<tr>
					<td>№</th>
					<td>Date</th>
					<td>Type</th>
					<td>Sum</th>
					<td>Text</th>
				</tr>   
	<c:forEach items="${listCheck}" var="check">
				<tr>
					<td> ${check.number}</td>
					<td> ${check.date}</td>
					<td> ${check.typeOfCheck}</td>
					<td> ${check.sum}</td>
					<td> ${check.text}</td>
<td><button type="submit" name="Delete" value=${check.number}>Delete</button></td>
</tr>
</c:forEach>
</table>
<table border = "1">
	<tr>
		<td> Total(Revenue)</td>
		<td><c:out value="${totalRevenue}"/> </td>
	</tr>
	<tr>
		<td> Total(totalExpences)</td>
		<td><c:out value="${totalExpences}"/> </td>
	</tr>
</table>

			</form>
		</div>
<td><button type="submit" name="Logout" >Logout</button></td>
    </body>
</html>