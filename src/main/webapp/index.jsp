<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="inicio" />
  <jsp:param name="title" value="Inicio" /> 
</jsp:include>

<h1>Página principal</h1>

<%
	//esto es codigo java
	out.print("<p>Esta linea esta en java</p>");
%>

<br>
<h3>Ejercicios Alumnos</h3>
<br>
<a href="ver-tabla-alumnos">Ver alumnos en tabla</a>
<br>
<a href="formulario-usuario.jsp">Crear alumno</a>
<br>



<br>
<h3>Ejercicios Productos</h3>
<br>
<a href="productos">Ver Productos</a>
<br>


<br>
<h3>Ejercicios Curriculum</h3>
<br>
<a href="formulario.jsp">Ejemplos de formulario con curriculum</a>
<br>


<br>
<h3>Ejercicios Ejemplos</h3>
<br>
<a href="getYpost.jsp">Ejemplos GET y POST</a>
<br>

<%@ include file="includes/pie.jsp" %>





