<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="Login" />
  <jsp:param name="title" value="Login" /> 
</jsp:include>

	<h1>Rellene los campos - Apartado B</h1>
					
		<form action ="apartado-b" method="post">
		
			<label for="nombre">Nombre:</label> 
			<input type="text" name="nombre" placeholder="Tu nombre">
			<br>
			
			<input type="submit" value="Enviar">
		
		</form>

<%@ include file="includes/pie.jsp" %>