<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="Q2.Author"%>
<%@page import="Q2.Article"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="http://localhost:8080/GiaiDeThiJSP_Servlet/search"
		method="post">
		Authors: <select name="author">
			<c:forEach var="o" items="${listAuthors}">
				<!-- value phục vụ cho nút search -->
				<option ${authorID==o.getId() ? "selected":""}
					value="${o.getId()}">${o.getName()}</option>
			</c:forEach>
		</select> <input type="submit" value="Search">
	</form>
	<c:if test="${listArticles!=null}">
		<table border="1">
			<tr>
				<th>Paper ID</th>
				<th>Title</th>
				<th>Published Date</th>
			</tr>
			<c:forEach var="o" items="${listArticles}">
				<tr>
					<td>${o.getId()}</td>
					<td>${o.getName()}</td>
					<td>${o.getDate()}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>