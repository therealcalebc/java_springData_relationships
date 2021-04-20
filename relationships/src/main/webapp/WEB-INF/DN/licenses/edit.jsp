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
		<a href="/dashboard">Dashboard</a>
		<h1>Edit License</h1>
		<form:form action="/licenses/${license.id}" method="post" modelAttribute="license" id="editLicenseForm">
			<input type="hidden" name="_method" value="put">
		    <p>
		        <form:label path="person">Person</form:label>
		        <form:select path="person">
		        	<c:forEach items="${persons}" var="p">
		        		<c:choose>
			        		<c:when test="${p.id == license.person.id}">
			        			<form:option value="${p}" selected="true" label="${p.firstName} ${p.lastName}"/>
			        		</c:when>
			        		<c:otherwise>
			        			<form:option value="${p}" label="${p.firstName} ${p.lastName}"/>
			        		</c:otherwise>
		        		</c:choose>
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
		    <!-- <input type="submit" value="Update"/> -->
		</form:form>
		<button type="submit" form="editLicenseForm">Update</button>
		<form action="/licenses/${license.id}" method="post" style="display: inline;">
			<input type="hidden" name="_method" value="delete">
			<input type="submit" value="Delete">
		</form>
	</div>
</body>
</html>
