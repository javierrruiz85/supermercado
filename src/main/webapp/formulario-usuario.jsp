<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="alumnos" />
  <jsp:param name="title" value="Crear usuario" /> 
</jsp:include>



	<h1>Formulario para crear alumnos</h1>
	
	<p>${mensaje}</p>
	
	<form action="alumno-crear" method="post">
	
		<label for="id">ID:</label>
		<br>
		<input type="text" name="id" id="id" value="${usuario.id}" readonly>
		<br><br>
		<label for="nombre">Nombre:</label>
		<br>
		<input type="text" name="nombre" id="id" value="${usuario.nombre}" placeholder="Escribe el nombre del alumno">
		<br><br>
		<input type="submit" value="Guardar">
		
	 </form>

<%@ include file="includes/pie.jsp" %>