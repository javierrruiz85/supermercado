<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="alumnos" />
  <jsp:param name="title" value="Crear alumno" /> 
</jsp:include>



	<h1>Formulario para crear y/o modificar usuarios</h1>
	
	<!-- Para comprobar que llega bien, es recomendable, antes de nada, poner lo siguiente -->
	<!-- ${variable}, en este caso en concreto seria ${usuario} -->
	 
	 <form action="alumno-crear" method="post">
	
		<div class="form-group">
			<label for="id">ID:</label>
			<input type="text" name="id" id="id" value="${usuario.id}" readonly class="form-control">
		</div>
			
		<div class="form-group">
			<label for="nombre">Nombre:</label>
			<input type="text" name="nombre" id="nombre" value="${usuario.nombre}" class="form-control" placeholder="Escribe el nombre del alumno">
		</div>
		
		<div class="form-group">
			<label for="precio">Precio:</label>
			<input type="text" name="precio" id="precio" value="${usuario.precio}" class="form-control" placeholder="Escribe el sueldo del alumno yoquesexd">
		</div>
		
		<div class="form-group">
			<label for="foto">Foto:</label>
			<input type="text" name="foto" id="foto" value="${usuario.foto}" class="form-control" placeholder="URL de la imagen">
		</div>
	
		<input type="submit" value="Guardar" class="btn btn-primary btn-block">
		
	 </form>
	 
	 
	 

<%@ include file="includes/pie.jsp" %>