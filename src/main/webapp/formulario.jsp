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
	<br>

	<h1>Formulario Completo</h1>
	
	TODO maquetar formulario del CV
	
	llamara  a un controlador "formulario-completo"
	
	mostrar una nueva JSP para resumir los datos
	
	
	
	
	
	<h1>Rellena tu CV</h1>

    <form action="formulario-completo" method="post">
    
    	Nombre: 
    	<input type="text" name="value1" value="${value1}" placeholder="Nombre">
    	<br>
    	Apellidos: 
    	<input type="text" name="value2" value="${value2}" placeholder="Apellidos">
    	<br>
    	Contraseña: 
    	<input type="text" name="value3" value="${value3}" placeholder="Contraseña">
    	<br>
    	DNI: 
    	<input type="text" name="value4" value="${value4}" placeholder="DNI">
    	<br>
    
        <fieldset>
            <legend>Sexo</legend>
            <input type="radio" name="value5" value="hombre" checked="checked" /> Hombre <br>
            <input type="radio" name="value5" value="mujer" /> Mujer <br>
        </fieldset>
        

        <br>
        <input name="value6" type="checkbox" value="Acepto suscribir a novedades"/> Suscribirme al boletin de novedades. <br>

        <br>
        <input type="submit" name="enviar" value="Enviar" />
        <input type="reset" name="limpiar" value="Borrar datos del formulario" />
    </form>
    
    
	
	
	

</body>
</html>