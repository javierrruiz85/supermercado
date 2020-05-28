
<%@page import="com.ipartek.formacion.modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="alumnos" />
  <jsp:param name="title" value="Tabla alumnos (usuarios)" /> 
</jsp:include>




	<a href="index.jsp">VOLVER</a>
	
	
	<h1>Tabla con alumnos </h1>
	<p>${mensaje}</p>
	

	
	<%
		// Recogemos la informacion "atributo" enviada desde el controlador
		ArrayList<Usuario> alumnos = (ArrayList<Usuario>)request.getAttribute("alumnos");
	%>
	

	
	<a href="alumno-crear">Ir a formulario para crear un nuevo alumno</a>
	<br>
	<table id="tabla-productos" class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Precio</th>
				<th>Imagen</th>
				<th>Operaciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${alumnos}" var="a">
				<tr>
					<td>${a.id}</td> <% // no hace falta usar el getter p.id == p.getId() %>
					<td>${a.nombre}</td>
					<td>${a.precio} &euro;</td>
					<td><div class="img-tabla"><img src="${a.foto}" alt="imagen..."></div></td>
					<td>
						<!-- En la linea siguiente, rara vez el href va a una .jsp, es mejor ir directo al controlador (alumno crear) -->
						<a href="alumno-crear"><i class="fas fa-user-plus fa-2x" title="Crear usuario"></i></a>
						<a href="alumno-crear?id=${a.id}"><i class="fas fa-user-edit fa-2x" title="Editar usuario"></i></a>
						
						<a href="usuario-eliminar?id=${a.id}"><i class="fas fa-user-times fa-2x" title="Eliminar usuario"></i></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
<%@ include file="includes/pie.jsp" %>

