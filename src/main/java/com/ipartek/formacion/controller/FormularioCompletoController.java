package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormularioCompletoController
 */
@WebServlet("/formulario-completo")
public class FormularioCompletoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<String> validaciones = new ArrayList<>();
		
		try {
			// recoger parametros del formulario formulario.jsp
			String parametro1 = request.getParameter("value1");
			String parametro2 = request.getParameter("value2");
			String parametro3 = request.getParameter("value3");
			String parametro4 = request.getParameter("value4");
			String parametro5 = request.getParameter("value5");
			String parametro6 = request.getParameter("value6");
			
			
			
			// logica de negocio, comprobar si los campos obligatorios estan vacios
	        if ( "".equalsIgnoreCase(parametro1) ) {
	        	validaciones.add("El NOMBRE es obligatorio");
	        } //if
	        if ( "".equalsIgnoreCase(parametro2) ) {
	        	validaciones.add("El APELLIDO es obligatorio");
	        } //if
	        if ( "".equalsIgnoreCase(parametro4) ) {
	        	validaciones.add("El DNI es obligatorio");
	        } //if
	        
	        
	        
	        // comprobar si el campo 'boletin' esta marcado o no
	        if (parametro6 != null){
	        	parametro6 = "Deseo recibir informacion sobre las novedades";
	        } else {
	        	parametro6 = "No deseo recibir informacion sobre las novedades";
	        } //if-else
			
			
			
			// volver a enviar los parametros recibidos como atributos a formulario-resumen.jsp
			request.setAttribute("value1", parametro1);
			request.setAttribute("value2", parametro2);
			request.setAttribute("value3", parametro3);
			request.setAttribute("value4", parametro4);
			request.setAttribute("value5", parametro5);
			request.setAttribute("value6", parametro6);
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			request.setAttribute("mensaje", "Lo sentimos pero tenemos un ERROR " + e.getMessage());
			
		} finally {
			
			// Enviar todo a la vista que corresponda:
			// - si no hay fallos ni errores, a formulario-resumen.jsp, para que lo muestre
			if( validaciones.isEmpty() ) {
				request.getRequestDispatcher("formulario-resumen.jsp").forward(request, response);
				
			// - si hay	errores, mostrarlos en formulario.jsp
			}else {
				request.setAttribute("validationes", validaciones);
				request.getRequestDispatcher("formulario.jsp").forward(request, response);
				
			} // if-else
			
		} //finally
	}

}
