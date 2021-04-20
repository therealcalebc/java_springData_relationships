<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ninjas</title>
</head>
<body>
	<div>
		<a href="/dashboard-dn">Dashboard</a>
		<br>
		<h1><c:out value="${ninja.firstName}"/> <c:out value="${ninja.lastName}"/></h1>
		<table>
			<tr><td>Age: </td><td><c:out value="${ninja.age}"/></td></tr>
			<tr><td>Dojo: </td><td><c:out value="${ninja.dojo.name}"/></td></tr>
		</table>
		<p><a href="/ninjas/${ninja.id}/edit">Edit</a></p>
		<form action="/ninjas/${ninja.id}" method="post">
			<input type="hidden" name="_method" value="delete">
			<input type="submit" value="Delete">
		</form>
	</div>
</body>
</html>