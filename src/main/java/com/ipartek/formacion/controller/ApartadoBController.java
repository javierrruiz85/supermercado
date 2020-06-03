package com.ipartek.formacion.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ApartadoBController
 */
@WebServlet("/apartado-b")
public class ApartadoBController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApartadoBController() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		
		// recoger la hora
		LocalDateTime horaLocal = LocalDateTime.now();
		String hora = horaLocal.format(DateTimeFormatter.ofPattern("HH:mm"));
		
		// recoger el nombre de apartadoB.jsp
		String nombre = request.getParameter("nombre");
		
		// recoger el navegador
		String navegador = request.getHeader("User-Agent");
		
		
		// crear la sesion para almacenar los datos
		HttpSession session = request.getSession();
		
		
		// guardar los datos
		session.setAttribute("nombre", nombre);
		session.setAttribute("hora", hora);
		session.setAttribute("navegador", navegador);
		
		
		request.getRequestDispatcher("resultadoB.jsp").forward(request, response);
		
		
	}

}
