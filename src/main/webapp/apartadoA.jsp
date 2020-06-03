<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="Login" />
  <jsp:param name="title" value="Login" /> 
</jsp:include>

	<h1>Rellene los campos - Apartado A</h1>
		
	
		<form action ="apartado-a" method="post">
		
			<label for="nombre">Nombre:</label> 
			<input type="text" name="nombre" placeholder="Tu nombre">
			<br>
			 <label for="color">Selecciona tu color favorito:</label>
				<select name="color" id="color">
					<option value="rojo">Rojo</option>
					<option value="amarillo">Amarillo</option>
					<option value="azul">Azul</option>
					<option value="verde">Verde</option>
				</select> 
			<br>
			<input type="submit" value="Enviar">
		
		</form>

<%@ include file="includes/pie.jsp" %>