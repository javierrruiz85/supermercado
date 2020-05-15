
<%@page import="com.ipartek.formacion.modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<a href="index.jsp">VOLVER</a>

<h1>Tabla con alumnos <h1/>


<style>
	th {border:1px solid black}
	td {border:1px solid black}
</style>


<%
	// Recogemos la informacion "atributo" enviada desde el controlador
	ArrayList<Usuario> alumnos = (ArrayList<Usuario>)request.getAttribute("alumnos");
%>


<table style="width:100%; border:1px solid black;">
  <tr>
    <th>ID</th>
    <th>Nombre</th> 
  </tr>
  
  <% for( Usuario u : alumnos ) { %>
  	<tr>
  		<td><%= u.getId() %></td>
  		<td><%= u.getNombre() %></td>
  	</tr>
  <% } %>
  
</table>