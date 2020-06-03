<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="Login" />
  <jsp:param name="title" value="Login" /> 
</jsp:include>
	
	<h1>Resultado B</h1>
	
	<h4>Hora de inicio:</h4>
	<p>${hora}</p>
	<h5>Nombre de usuario:</h5>
	<p>${nombre}</p>
	<h5>Navegador utilizado:</h5>
	<p>${navegador}</p>
	
	
<%@ include file="includes/pie.jsp" %>