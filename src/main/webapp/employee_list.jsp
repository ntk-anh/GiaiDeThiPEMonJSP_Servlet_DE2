<%@page import="java.util.ArrayList"%>
<%@page import="Q1.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<h1>Hello <%= request.getAttribute("id") %></h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Gender</th>
			<th>DOB</th>
		</tr>
		<%
		List<Employee> list = (List<Employee>)request.getAttribute("list");
		%>
		<%
		for (Employee item : list) {
		%>
		<tr>
			<td>
				<%=
				item.getId() 
				%>
			</td>
			<td>
				<%=
				item.getName()
				%>
			</td>
			<td>
				<%=
				item.toGender()				
				%>
			</td>
			<td>
				<%=
				item.getDob()
				%>
			</td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>