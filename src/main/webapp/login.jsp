
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="Login" />
  <jsp:param name="title" value="Login" /> 
</jsp:include>

	<h1>Iniciar sesion</h1>
	
	<br>
	
	<p>Para acceder y poder ver la tabla productos => user: admin, pass: admin</p>
	<p>Resto de contraseñas: 12345</p>
	
	<br>
	
	<p>Podemos usar el inspector de codigo para ver las cookies, pestaña <b>Storage</b></p>
	<p>Su ultima visita fue el dia <b> ${ cookie['ultima_visita'].value } </b></p>

	<form action ="login" method="post" class="form-login" onsubmit="cifrar()">
	
	
		<div class="form-group">
			<input type="text" name="nombre" id="nombre" placeholder="Tu nombre" class="form-control">
		</div>
		
		<div class="form-group">
			<input type="password" name="pass" id="pass" placeholder="Tu contraseña" class="form-control">
		</div>
		
		<div class="form-group">
			<select name="idioma" id="idioma" class="custom-select">		  
			  <option value="castellano">Castellano</option>
			  <option value="euskera">Euskera</option>
			  <option value="ingles">Ingles</option>
			</select>
		</div>
	
		<div class="form-group">
		<input type="checkbox" name="recuerdame" ${ (not empty cookie['cEmail'].value) ? "checked" : ""  } >Recuerdame
		</div>
		<input type="submit" value="Iniciar sesion" class="btn btn-primary btn-block">
	
	</form>

<%@ include file="includes/pie.jsp" %>

