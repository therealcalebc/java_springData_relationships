<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Persons</title>
</head>
<body>
	<div>
		<a href="/dashboard">Dashboard</a>
		<h1>Edit Person</h1>
		<form:form action="/persons/${person.id}" method="post" modelAttribute="person" id="editPersonForm">
			<input type="hidden" name="_method" value="put">
		    <p>
		        <form:label path="firstName">First Name</form:label>
		        <form:input path="firstName"/>
		        <form:errors path="firstName"/>
		    </p>
		    <p>
		        <form:label path="lastName">Last Name</form:label>
		        <form:input path="lastName"/>
		        <form:errors path="lastName"/>
		    </p>
		    <!-- <input type="submit" value="Update"/> -->
		</form:form>
		<button type="submit" form="editPersonForm">Update</button>
		<form action="/persons/${person.id}" method="post" style="display: inline;">
			<input type="hidden" name="_method" value="delete">
			<input type="submit" value="Delete">
		</form>
	</div>
</body>
</html>
