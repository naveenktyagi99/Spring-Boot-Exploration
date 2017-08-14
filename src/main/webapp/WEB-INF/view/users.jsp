<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	List of the User
	<table>
	<tr>
	<th>First Name</th><th>Middle Name</th>
	<th>Last Name</th><th>Email</th><th>Contact</th>
	</tr>
	<s:if test="${not empty users}">
		<s:forEach items="${users}" var="user">
		<tr>
      	 	<td>${user.firstName}</td>
      	 	<td>${user.middleName}</td>
      	 	<td>${user.lastName}</td>
      	 	<td>${user.email}</td>
      	 </tr>
		</s:forEach>
</s:if>
</table>
</body>
</html>