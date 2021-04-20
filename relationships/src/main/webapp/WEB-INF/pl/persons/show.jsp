<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Persons</title>
</head>
<body>
	<div>
		<a href="/dashboard-pl">Dashboard</a>
		<br>
		<h1><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></h1>
		<table>
			<tr><td>License Number: </td><td><c:out value="${person.license.number}"/></td></tr>
			<tr><td>State: </td><td><c:out value="${person.license.state}"/></td></tr>
			<tr><td>Expiration Date: </td><td><c:out value="${person.license.expirationDate}"/></td></tr>
		</table>
		<p><a href="/persons/${person.id}/edit">Edit</a></p>
		<form action="/persons/${person.id}" method="post">
			<input type="hidden" name="_method" value="delete">
			<input type="submit" value="Delete">
		</form>
	</div>
</body>
</html>