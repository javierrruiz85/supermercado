<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="index.jsp">VOLVER</a>
	<br>

	
	
	<h1>Rellena tu CV</h1>
	
	
	
	<c:if test="${not empty validationes}">
		<div style="padding:20px; background-color: #DDD; color:#000; ">
			<ol>
				<c:forEach items="${validationes}" var="validacion">
					<li>${validacion}</li>
				</c:forEach>
			</ol>
		</div>
		<br>
	</c:if>
	
	

    <form action="formulario-completo" method="post">
    
    	<label for="nombre">*Nombre:</label> 
    	<input type="text" name="value1" value="${value1}" autofocus placeholder="Nombre">
    	<br>
    	<label for="apellidos">*Apellidos:</label> 
    	<input type="text" name="value2" value="${value2}" placeholder="Apellidos">
    	<br>
    	<label for="dni">*DNI:</label> 
    	<input type="text" name="value4" value="${value4}" placeholder="DNI">
    	<br>
    	<label for="telefono">Telefono:</label> 
    	<input type="text" name="value3" value="${value3}" placeholder="Contraseña">
    	<br>
    
    	<br>
        <fieldset>
            <legend>Sexo</legend>
            <input type="radio" name="value5" value="hombre" checked />
            <label for="hombre">Hombre</label>
            <br>
            <input type="radio" name="value5" value="mujer" />
            <label for="mujer">Mujer</label>
            <br>
        </fieldset>
        

        <br>
        <input name="value6" type="checkbox" value="Aceptar"/>
        <label for="boletin">Suscribirme al boletin de novedades.</label>
        <br>

        <br>
        <input type="submit" name="enviar" value="Enviar" />
        <input type="reset" name="limpiar" value="Borrar datos del formulario" />
    </form>
    
    
    <h4 style="color:red">Los campos marcados con un * son obligatorios</h4>
	
	

</body>
</html>