<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="productos" />
  <jsp:param name="title" value="Crear producto" /> 
</jsp:include>



	<h1>Formulario para crear productos</h1>
	
	
	
	<form action="producto-crear" method="post">
	
		<div class="form-group">
			<label for="id">ID:</label>
			<input type="text" name="id" id="id" value="${producto.id}" readonly class="form-control">
		</div>
			
		<div class="form-group">
			<label for="nombre">Nombre:</label>
			<input type="text" name="nombre" id="nombre" value="${producto.nombre}" class="form-control" placeholder="Escribe el nombre del producto">
		</div>
		
		<div class="form-group">
			<label for="precio">Precio:</label>
			<input type="text" name="precio" id="precio" value="${producto.precio}" class="form-control" placeholder="Escribe el precio del producto">
		</div>
		
		<div class="form-group">
			<label for="foto">Foto:</label>
			<input type="text" name="foto" id="foto" value="${producto.foto}" class="form-control" placeholder="URL de la imagen">
		</div>
	
		<input type="submit" value="Guardar" class="btn btn-primary btn-block">
		
	 </form>

<%@ include file="includes/pie.jsp" %>