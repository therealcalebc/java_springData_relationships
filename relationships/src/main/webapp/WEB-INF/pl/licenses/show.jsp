<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Licenses</title>
</head>
<body>
	<div>
		<a href="/dashboard-pl">Dashboard</a>
		<br>
		<h1><c:out value="${license.number}"/></h1>
		<table>
			<tr><td>State: </td><td><c:out value="${license.state}"/></td></tr>
			<tr><td>Expiration Date: </td><td><c:out value="${license.expirationDate}"/></td></tr>
			<tr><td>Person: </td><td><c:out value="${license.person.firstName}"/> <c:out value="${license.person.lastName}"/></td></tr>
		</table>
		<p><a href="/licenses/${license.id}/edit">Edit</a></p>
		<form action="/licenses/${license.id}" method="post">
			<input type="hidden" name="_method" value="delete">
			<input type="submit" value="Delete">
		</form>
	</div>
</body>
</html>