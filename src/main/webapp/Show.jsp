<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="add" method="post">
		<table>
			<tr>
				<td>PaperID:</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>Title:</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>Date:</td>
				<td><input type="text" name="date">(yyyy-MM-yy)</td>
			</tr>

			<c:forEach var="o" items="${list}">
				<tr>
					<td></td>
					<td><input type="checkbox" name="author" value="${o.getId()}">${o.getName()}</td>
				</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td><input type="submit" value="Save"></td>
			</tr>

		</table>
	</form>
</body>
</html>