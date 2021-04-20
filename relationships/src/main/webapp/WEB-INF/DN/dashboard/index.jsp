<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
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
		<a href="/ninjas/new">Add New Ninja</a>
		<a href="/dojos/new">Add New Dojo</a>
		<form action="/search" style="display: inline-block;">
			<input type="search" id="searchInput" name="q" placeholder="Enter artist name...">
			<button type="submit">Search Artists</button>
		</form>
	</header> -->
	<main>
		<div>
			<p><a href="/ninjas/new">Add New Ninja</a></p>
			<table>
			    <thead>
			        <tr>
			            <th>Name</th>
			            <th>actions</th>
			        </tr>
			    </thead>
			    <tbody>
			        <c:forEach items="${ninjas}" var="ninja">
			        <tr>
			            <td><a href="/ninjas/${ninja.id}"><c:out value="${ninja.firstName} ${ninja.lastName}"/></a></td>
			            <td>
							<a href="/ninjas/${ninja.id}/edit">edit</a> | 
			            	<form action="/ninjas/${ninja.id}" method="post" style="display: inline;">
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
			<p><a href="/dojos/new">Add New Dojo</a></p>
			<table>
			    <thead>
			        <tr>
			            <th>Name</th>
			            <th>actions</th>
			        </tr>
			    </thead>
			    <tbody>
			        <c:forEach items="${dojos}" var="dojo">
			        <tr>
			            <td><a href="/dojos/${dojo.id}"><c:out value="${dojo.name}"/></a></td>
			            <td>
							<a href="/dojos/${dojo.id}/edit">edit</a> | 
			            	<form action="/dojos/${dojo.id}" method="post" style="display: inline;">
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
