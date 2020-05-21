package com.ipartek.formacion.controller;

import java.io.IOException;
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
		
		// recoger parametros del formulario formulario.jsp
		String parametro1 = request.getParameter("value1");
		String parametro2 = request.getParameter("value2");
		String parametro3 = request.getParameter("value3");
		String parametro4 = request.getParameter("value4");
		String parametro5 = request.getParameter("value5");
		String parametro6 = request.getParameter("value6");
		
		
		// volver a enviar los parametros recibidos como atributos
		request.setAttribute("value1", parametro1);
		request.setAttribute("value2", parametro2);
		request.setAttribute("value3", parametro3);
		request.setAttribute("value4", parametro4);
		request.setAttribute("value5", parametro5);
		request.setAttribute("value6", parametro6);
		
		
		// settear los valores recogidos en formulario.jsp
		String nombre = parametro1;
		request.setAttribute("nombre", nombre);
		
		String apellidos = parametro2;
		request.setAttribute("apellidos", apellidos);
		
		String contrasenia = parametro3;
		request.setAttribute("contrasenia", contrasenia);
		
		String dni = parametro4;
		request.setAttribute("dni", dni);
		
		String sexo = parametro5;
		request.setAttribute("sexo", sexo);
		
		String boletin = parametro6;
		request.setAttribute("boletin", boletin);
		
		
		// enviarlo todo a formulario-resumen.jsp
		request.getRequestDispatcher("formulario-resumen.jsp").forward(request, response);

		
		
	}

}
