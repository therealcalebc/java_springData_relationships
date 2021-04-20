<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<h1>New Ninja</h1>
		<form:form action="/ninjas" method="post" modelAttribute="ninja">
		    <p>
		        <form:label path="dojo">Dojo</form:label>
		        <form:select path="dojo">
		        	<c:forEach items="${dojos}" var="do">
			        	<form:option value="${do.id}"><c:out value="${do.name}"/></form:option>
			        </c:forEach>
		        </form:select>
		        <form:errors path="dojo"/>
		    </p>
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
		    <p>
		        <form:label path="age">Age</form:label>
		        <form:input path="age" type="number"/>
		        <form:errors path="age"/>
		    </p>
		    <input type="submit" value="Add Ninja"/>
		</form:form>
	</div>
</body>
</html>
