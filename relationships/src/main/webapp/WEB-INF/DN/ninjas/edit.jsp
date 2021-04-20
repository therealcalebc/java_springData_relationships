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
		<a href="/DN/dashboard">Dashboard</a>
		<h1>Edit Ninja</h1>
		<form:form action="/ninjas/${ninja.id}" method="post" modelAttribute="ninja" id="editNinjaForm">
			<input type="hidden" name="_method" value="put">
		    <p>
		        <form:label path="dojo">Dojo</form:label>
		        <form:select path="dojo">
		        	<c:forEach items="${dojos}" var="d">
		        		<c:choose>
			        		<c:when test="${d.id == ninja.dojo.id}">
			        			<form:option value="${d}" selected="true" label="${d.name}"/>
			        		</c:when>
			        		<c:otherwise>
			        			<form:option value="${d}" label="${d.name}"/>
			        		</c:otherwise>
		        		</c:choose>
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
		    <!-- <input type="submit" value="Update"/> -->
		</form:form>
		<button type="submit" form="editNinjaForm">Update</button>
		<form action="/ninjas/${ninja.id}" method="post" style="display: inline;">
			<input type="hidden" name="_method" value="delete">
			<input type="submit" value="Delete">
		</form>
	</div>
</body>
</html>
