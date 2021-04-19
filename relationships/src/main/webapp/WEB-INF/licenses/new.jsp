<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Licenses</title>
</head>
<body>
	<div>
		<a href="/dashboard">Dashboard</a>
		<br>
		<form:form action="/licenses" method="post" modelAttribute="license">
		    <p>
		        <form:label path="person">Person</form:label>
		        <form:select path="person">
		        	<form:options items="${persons}" itemValue="id" itemLabel="fullName"/>
		        </form:select>
		        <form:errors path="person"/>
		    </p>
		    <p>
		        <form:label path="state">State</form:label>
		        <form:input path="state"/>
		        <form:errors path="state"/>
		    </p>
		    <p>
		        <form:label path="expirationDate">Expiration Date</form:label>
		        <form:input path="expirationDate" type="date"/>
		        <form:errors path="expirationDate"/>
		    </p>
		    <input type="submit" value="Add License"/>
		</form:form>
	</div>
</body>
</html>
