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
		<a href="/PL/dashboard">Dashboard</a>
		<h1>New Person</h1>
		<form:form action="/persons" method="post" modelAttribute="person">
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
		    <input type="submit" value="Add Person"/>
		</form:form>
	</div>
</body>
</html>
