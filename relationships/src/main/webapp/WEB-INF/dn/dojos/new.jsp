<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dojos</title>
</head>
<body>
	<div>
		<a href="/dashboard-dn">Dashboard</a>
		<h1>New Dojo</h1>
		<form:form action="/dojos" method="post" modelAttribute="dojo">
		    <p>
		        <form:label path="name">Name</form:label>
		        <form:input path="name"/>
		        <form:errors path="name"/>
		    </p>
		    <input type="submit" value="Add Dojo"/>
		</form:form>
	</div>
</body>
</html>
