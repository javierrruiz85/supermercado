
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="usuario" />
  <jsp:param name="title" value="Usuarios" /> 
</jsp:include>


<h1>Usuarios</h1>

<a href="usuario?id=0">Dar de Alta Nuevo Usuario</a>

<table class="tabla table table-striped table-bordered">
	<thead>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Rol</th>
			<th>Cuota</th>
			<th>Foto</th>
			<th>Operaciones</th>					
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${usuarios}" var="usuario">
			<tr>
				<td>${usuario.id}</td> 
				<td>${usuario.nombre}</td>
				<td>${usuario.idRol}</td>
				<td>${usuario.precio}</td>
				<td><div class="img-tabla"><img src="${usuario.foto}" alt="imagen..."></div></td>
				<td><a href="usuario?id=${usuario.id}" class="mr-4"> <i class="far fa-edit fa-2x" title="Editar Registro"></i></a>			
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>


<%@include file="includes/pie.jsp" %>

