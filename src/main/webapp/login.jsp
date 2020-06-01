
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="Login" />
  <jsp:param name="title" value="Login" /> 
</jsp:include>

	<h1>Iniciar sesion</h1>

	<form action ="login" method="post">
	
		<input type="text" name="nombre" placeholder="Tu nombre">
		<br>
		<input type="password" name="pass" placeholder="Tu contraseña">
		<br>
		<input type="checkbox" name="recuerdame" ${ (not empty cookie['cEmail'].value) ? "checked" : ""  } >Recuerdame
		<br>
		<input type="submit" value="Iniciar sesion">
	
	</form>

<%@ include file="includes/pie.jsp" %>