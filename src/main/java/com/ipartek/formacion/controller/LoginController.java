package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
		
		String nombre = request.getParameter("nombre");
		String pass = request.getParameter("pass");
		
		HttpSession session = request.getSession();
		
		//TODO validar contra la BBDD (con DAO)
		
		if ( "admin".equals(nombre) && "12345".equals(pass) ) {
			
			session.setMaxInactiveInterval( 60 * 5 ); // 5 minutos sin peticiones, se invalida la session del usuario
			session.setAttribute("isLogeado", true);
			session.setAttribute("nombreUsuario", "Admin");
			
			request.setAttribute("alerta", new Alerta("success", "Sesion iniciada, bienvenido"));
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}else {
			
			//TODO logout controller
			session.invalidate();
			
			request.setAttribute("alerta", new Alerta("danger", "Las credenciales son incorrectas"));
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}
		
	}

}
