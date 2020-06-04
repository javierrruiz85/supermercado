package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.Usuario;
import com.ipartek.formacion.modelo.UsuarioDAOImpl;
																			// MODELO DE ANDER
/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/usuario")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static UsuarioDAOImpl daoUsuario = UsuarioDAOImpl.getInstance();
    private static String VIEW_LIST = "usuario-lista.jsp";
    private static String VIEW_FORM = "usuario-formulario.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idParametro = request.getParameter("id");
		String view = VIEW_LIST;
		
		try {
		
			if ( idParametro == null ) {									// Listar
				
				request.setAttribute("usuarios", daoUsuario.getAll() );
				
			}else {															// Mostrar usuario en formulario
				
				view = VIEW_FORM;
				int id = Integer.parseInt(idParametro);
				if ( id == 0 ) {
					request.setAttribute("usuario", new Usuario() );
				}else {
					request.setAttribute("usuario", daoUsuario.getById(id) );	
				}
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			
			request.getRequestDispatcher(view).forward(request, response);	
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recoger parametros del formulario
		String idParametro = request.getParameter("id");
		String rol = request.getParameter("rol");
		String nombre = request.getParameter("nombre");
		String pass = request.getParameter("pass");
		String precio = request.getParameter("precio");
		String foto = request.getParameter("foto");
		
		Usuario usuario = new Usuario();
				
		try {
		
			int id = Integer.parseInt(idParametro);
			int idRol = Integer.parseInt(rol);
			float idPrecio = Float.parseFloat(precio);
			
			
			usuario.setId(id);
			usuario.setIdRol(idRol);
			usuario.setNombre(nombre);
			usuario.setPrecio(idPrecio);
			usuario.setFoto(foto);
			
			
			if ( id == 0 ) {
				
				//guardamos contraseña hash del formulario
				usuario.setContrasenia(pass);
				daoUsuario.insert(usuario);
				
			}else {
				
				//recupero la contrseña de la bbdd TODO mirar como cambiarla 
				Usuario uGuardado = daoUsuario.getById(id);				
				usuario.setContrasenia( uGuardado.getContrasenia() );
				
				daoUsuario.update(usuario);
			}
			
			request.setAttribute("alerta", new Alerta("success", "Datos Guardado con exito"));
			
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("alerta", new Alerta("danger", e.getMessage() ));
			
		}finally {
			
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher(VIEW_FORM).forward(request, response);	
		}
		
	}

}
