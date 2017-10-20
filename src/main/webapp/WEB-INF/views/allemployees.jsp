<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>TakeALot Register</title>

	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>

</head>


<body>
	<h2>List of users</h2>	
	<table>
		<tr>
			<td>First Name</td><td>Last Name</td><td>Date of Birth</td><td>Phone</td><td>Gender</td><td>Email</td><td></td>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
			<td>${user.firstName}</td>
			<td>${user.lastName}</td>
			<td>${user.birthdate}</td>
			<td>${user.phone}</td>
			<td>${user.gender}</td>
			<td><a href="<c:url value='/edit-${user.emailAddress}-user' />">${user.emailAddress}</a></td>
			<td><a href="<c:url value='/delete-${user.emailAddress}-user' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/new' />">Add New User</a>
</body>
</html>