package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApartadoAController
 */
@WebServlet("/apartado-a")
public class ApartadoAController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApartadoAController() {
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
		
		
		// recoger parametros
		String nombre = request.getParameter("nombre");
		String color = request.getParameter("color");
		
		
		// gestionar el nombre
		Cookie cNombre = new Cookie("cNombre", nombre);
		cNombre.setMaxAge(60 * 60 * 24);
		response.addCookie(cNombre);
		
		
		// gestionar el color
		Cookie cColor = new Cookie("cColor", color);
		cColor.setMaxAge(60 * 60 * 24);
		response.addCookie(cColor);
		
		
		// recoger todas las cookies en el servidor
		Cookie[] arrayGalletitas = request.getCookies();
		// para buscar una habra que hacer un for y buscar por su identificador
		
		
		String colorElegido = "";
		
		switch (color) {
		case "rojo":
			colorElegido = "Rojo";
			break;
			
		case "amarillo":
			colorElegido = "Amarillo";
			break;	
			
		case "azul":
			colorElegido = "Azul";
			break;	

		default:
			colorElegido = "Verde";
			break;
		}
		
		// en lugar de hacer la siguiente linea como siempre, vamos a hacer la line de response, ya que si no, aunque en la cookie guarda el valor, no lo muestra si no se hace F5
		// request.getRequestDispatcher("resultadoA.jsp").forward(request, response);
		
		// redireccion como respuesta, el cliente automaticamente hace la segunda request a esta nueva url
		response.sendRedirect("resultadoA.jsp");
		
		
		
	}

}
