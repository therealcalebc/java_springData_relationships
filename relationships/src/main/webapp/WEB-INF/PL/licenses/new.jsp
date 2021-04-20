<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Licenses</title>
</head>
<body>
	<div>
		<a href="/PL/dashboard">Dashboard</a>
		<h1>New License</h1>
		<form:form action="/licenses" method="post" modelAttribute="license">
		    <p>
		        <form:label path="person">Person</form:label>
		        <form:select path="person">
		        	<c:forEach items="${persons}" var="p">
		        		<form:option value="${p}" label="${p.firstName} ${p.lastName}"/>
			        </c:forEach>
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
