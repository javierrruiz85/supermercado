<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    

<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="productos" />
  <jsp:param name="title" value="Tabla productos" /> 
</jsp:include>

	<a href="index.jsp">VOLVER</a>


	
	<h1>Tabla con productos </h1>
	<p>${mensaje}</p>
	

	

	
	

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
				<th>Operaciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productos}" var="p">
				<tr>
					<td>${p.id}</td> <% // no hace falta usar el getter p.id == p.getId() %>
					<td>${p.nombre}</td>
					<td>${p.precio}</td>
					<td><div class="img-tabla"><img src="${p.foto}" alt="imagen..."></div></td>
					<td>
						<!-- En la linea siguiente, rara vez el href va a una .jsp, es mejor ir directo al controlador (alumno crear) -->
						<a href="producto-crear"><i class="fas fa-plus fa-2x" title="Crear producto"></i></a>
						<a href="producto-crear?id=${p.id}"><i class="fas fa-edit fa-2x" title="Editar producto"></i></a>
						
						<a href="producto-eliminar?id=${p.id}"><i class="far fa-trash-alt fa-2x" title="Eliminar producto"></i></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
<%@ include file="includes/pie.jsp" %>

