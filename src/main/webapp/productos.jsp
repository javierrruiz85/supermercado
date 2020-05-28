<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    

<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="productos" />
  <jsp:param name="title" value="Tabla productos" /> 
</jsp:include>

	<a href="index.jsp">VOLVER</a>


	<h1>Listado Productos</h1>
	
	

	<%
		// Podemos usar el ${}  EL - Expresion Lenguage en los JSPs
		// suele ser mas comodo que tener que usar < % % >, a estos porcentajes se les llama SCRIPLETS
		// ademas se pueden combinar con JSTL - Java Servlet Tag Libraries
	%>	
	
	
	
	<table id="tabla-productos" class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Precio</th>
				<th>Foto</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productos}" var="p">
				<tr>
					<td>${p.id}</td> <% // no hace falta usar el getter p.id == p.getId() %>
					<td>${p.nombre}</td>
					<td>${p.precio}</td>
					<td><div class="img-tabla"><img src="${p.foto}" alt="imagen..."></div></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
<%@ include file="includes/pie.jsp" %>

