package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/LogoutController")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idioma = "es";
		String mensaje = "";
		
		// recuperar cookie de Idioma para mensaje de salida, solo se hace en el logout, en el login NO		
		Cookie[] cookies = request.getCookies();
		if (cookies != null) { // con este if nos aseguramos de que, en caso de borrar la cookie, no nos de un null exception y el codigo falle
			for ( Cookie c : cookies ) {			
				if ( "cIdioma".equals(c.getName()) ) {   // cookie encontrada
					idioma = c.getValue();
					break;
				} // if2		
			} // for
		} // if1
		
		
		switch (idioma) {
		case "castellano":
			mensaje = "Adiosito";
			break;
			
		case "euskera":
			mensaje = "Agur";
			break;	

		default:
			mensaje = "Bye";
			break;
		}

		request.setAttribute("alerta", new Alerta("success", mensaje ));
		
		
		// Hacer esto al final, despues de recoger las cookies
		HttpSession session = request.getSession();
		session.invalidate();
		session = null;
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
