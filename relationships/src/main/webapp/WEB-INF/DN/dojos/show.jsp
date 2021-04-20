<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dojos</title>
</head>
<body>
	<div>
		<a href="/DN/dashboard">Dashboard</a>
		<br>
		<h1><c:out value="${dojo.name}"/> Location Ninjas</h1>
		<table>
		    <thead>
		        <tr>
		            <th>First Name</th>
		            <th>Last Name</th>
		            <th>Age</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${dojo.ninjas}" var="ninja">
			        <tr>
			            <td><c:out value="${ninja.firstName}"/></td>
			            <td><c:out value="${ninja.lastName}"/></td>
			            <td><c:out value="${ninja.age}"/></td>
			        </tr>
		        </c:forEach>
		    </tbody>
		</table>
		<p><a href="/dojos/${dojo.id}/edit">Edit</a></p>
		<form action="/dojos/${dojo.id}" method="post">
			<input type="hidden" name="_method" value="delete">
			<input type="submit" value="Delete">
		</form>
	</div>
</body>
</html>