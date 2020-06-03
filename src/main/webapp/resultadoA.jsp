<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="Login" />
  <jsp:param name="title" value="Login" /> 
</jsp:include>


	<h1>Resultado A</h1>
	
	<h5>Nombre de usuario:</h5>
	<p>${ cookie['cNombre'].value }</p>
	<h5>Color elegido:</h5>
	<p>${ cookie['cColor'].value }</p>


<%@ include file="includes/pie.jsp" %>