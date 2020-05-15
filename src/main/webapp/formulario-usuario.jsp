<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="index.jsp">VOLVER</a>

	<h1>Formulario para crear alumnos</h1>
	
	<p>${mensaje}</p>
	
	<form action="alumno-crear" method="post">
	
		<input type="text" name="nombre" placeholder="Escribe el nombre del alumno">
	
		<input type="submit" value="Crear">
	
	 </form>

</body>
</html>