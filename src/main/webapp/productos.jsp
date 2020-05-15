<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="index.jsp">VOLVER</a>


	<h1>Listado Productos</h1>
	
	

	<%
		// Podemos usar el ${}  EL - Expresion Lenguage en los JSPs
		// suele ser mas comodo que tener que usar < % % >, a estos porcentajes se les llama SCRIPLETS
		// ademas se pueden combinar con JSTL - Java Servlet Tag Libraries
	%>	
	
	
	<style>
		th {border:1px solid black}
		td {border:1px solid black}
	</style>
	<table style="width:50%; border:1px solid black;">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productos}" var="p">
				<tr>
					<td>${p.id}</td> <% // no hace falta usar el getter p.id == p.getId() %>
					<td>${p.nombre}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	


</body>
</html>