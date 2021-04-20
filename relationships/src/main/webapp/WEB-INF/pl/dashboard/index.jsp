<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Relationships</title>
	<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
<div class="container">
	<!-- <header>
		<a href="/persons/new">Add New Person</a>
		<a href="/licenses/new">Add New License</a>
		<form action="/search" style="display: inline-block;">
			<input type="search" id="searchInput" name="q" placeholder="Enter artist name...">
			<button type="submit">Search Artists</button>
		</form>
	</header> -->
	<main>
		<div>
			<p><a href="/persons/new">Add New Person</a></p>
			<table>
			    <thead>
			        <tr>
			            <th>Name</th>
			            <th>actions</th>
			        </tr>
			    </thead>
			    <tbody>
			        <c:forEach items="${persons}" var="person">
			        <tr>
			            <td><a href="/persons/${person.id}"><c:out value="${person.firstName} ${person.lastName}"/></a></td>
			            <td>
							<a href="/persons/${person.id}/edit">edit</a> | 
			            	<form action="/persons/${person.id}" method="post" style="display: inline;">
								<input type="hidden" name="_method" value="delete">
								<input type="submit" value="delete">
							</form>
						</td>
			        </tr>
			        </c:forEach>
			    </tbody>
			</table>
		</div>
		<div>
			<p><a href="/licenses/new">Add New License</a></p>
			<table>
			    <thead>
			        <tr>
			            <th>Number</th>
			            <th>actions</th>
			        </tr>
			    </thead>
			    <tbody>
			        <c:forEach items="${licenses}" var="license">
			        <tr>
			            <td><a href="/licenses/${license.id}"><c:out value="${license.number}"/></a></td>
			            <td>
							<a href="/licenses/${license.id}/edit">edit</a> | 
			            	<form action="/licenses/${license.id}" method="post" style="display: inline;">
								<input type="hidden" name="_method" value="delete">
								<input type="submit" value="delete">
							</form>
						</td>
			        </tr>
			        </c:forEach>
			    </tbody>
			</table>
		</div>
	</main>
</div>
</body>
</html>
