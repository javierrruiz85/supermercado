package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.Usuario;
import com.ipartek.formacion.modelo.UsuarioDAOImpl;

/**
 * Servlet implementation class UsuarioCrearController
 */
@WebServlet("/alumno-crear")
public class UsuarioCrearController extends HttpServlet {
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
		
		// recoger los valores del formulario
		// el nombre del parametro debe coincidir con el atributo 'name' del input
		String nombre = request.getParameter("nombre");
		
		UsuarioDAOImpl dao = UsuarioDAOImpl.getInstance();
		
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		
		String mensaje="";
			
		try {
			dao.insert(usuario);
			mensaje = "Usuario insertado con exito";
			
		} catch (Exception e) {
			mensaje = "Lo sentimos, a ocurrido un error";
			e.printStackTrace();
		}
		
		// enviar datos a la vista
		request.setAttribute("mensaje", mensaje);
		
		// ir a la nueva vista o jsp
		request.getRequestDispatcher("formulario-usuario.jsp").forward(request, response);
		
	}

}
