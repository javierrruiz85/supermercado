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
		
		// COOKIES
		
		// recoger parametros
		String recuerdame = request.getParameter("recuerdame");
		String email = request.getParameter("email");
		String idioma = request.getParameter("idioma");
		
		
		// Guardar una cookie con la ultima visita
		
		LocalDateTime tiempo = LocalDateTime.now();
		String formattedDate = tiempo.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy_HH:mm"));		
		Cookie cUltimaVisita = new Cookie("ultima_visita",formattedDate );
		
		cUltimaVisita.setMaxAge( 60 * 60 * 24 * 365  );  // 1 año
		response.addCookie(cUltimaVisita);
			
		
		// gestionar cookie del email		
		Cookie cEmail = new Cookie("cEmail", email );		
		if ( recuerdame != null ) {			
			cEmail.setMaxAge( 60 * 1 *60 *24 * 365  );  // 1 año
					
		}else{
			cEmail.setMaxAge(0);  // invalidar
			
		}		
		response.addCookie(cEmail);
		
		
		// gestionar el idioma
		Cookie cIdioma = new Cookie("cIdioma", idioma);
		cIdioma.setMaxAge( 60 * 60 * 24 * 365 * 5 ); // 5 años
		response.addCookie(cIdioma);
		
		
		// recoger todas las cookies en el servidor
		Cookie[] arrayGalletitas = request.getCookies();
		// para buscar una habra que hacer un for y buscar por su identificador
				
		
		
		
		// LOGIN		
				
		String nombre = request.getParameter("nombre");
		String pass = request.getParameter("pass");
		
		HttpSession session = request.getSession();
		
		//TODO validar contra la BBDD (con DAO)
		
		
		if ( "admin".equals(nombre) && "12345".equals(pass) ) {
			
			session.setMaxInactiveInterval( 60 * 5 ); // 5 minutos sin peticiones, se invalida la session del usuario
			session.setAttribute("isLogeado", true);
			session.setAttribute("nombreUsuario", "Admin");
			
			
			String mensaje = "";
			
			switch (idioma) {
			case "castellano":
				mensaje = "Bienvenido";
				break;
				
			case "euskera":
				mensaje = "Ongi etorri";
				break;	

			default:
				mensaje = "Welcome";
				break;
			}
		
			request.setAttribute("alerta", new Alerta("success", mensaje ));
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}else {
			
			//TODO logout controller
			session.invalidate();
			
			request.setAttribute("alerta", new Alerta("danger", "Las credenciales son incorrectas"));
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}
		
	}

}
