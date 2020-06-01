package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAOImpl;

/**
 * Servlet implementation class ProductoCrearController
 */
@WebServlet("/producto-crear")
public class ProductoCrearController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String parametroId = request.getParameter("id");
			Producto producto = new Producto();
			
			if (parametroId != null && !"".equals(parametroId)) {
				int id =Integer.parseInt(parametroId);
				ProductoDAOImpl dao = ProductoDAOImpl.getInstance();
				producto = dao.getById(id);
			} //if
			
			request.setAttribute("producto", producto);

		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			// ir a la nueva vista o jsp
			request.getRequestDispatcher("formulario-producto.jsp").forward(request, response);
			
		} //finally
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Alerta alerta = new Alerta();
		Producto producto = new Producto();
		
			
		try {
			
			// recoger los valores del formulario
			String idParametro = request.getParameter("id");
			String nombre = request.getParameter("nombre");
			String precioParametro = request.getParameter("precio");
			String foto = request.getParameter("foto");
			
			
			int id = Integer.parseInt(idParametro);
			float precio = Float.parseFloat(precioParametro);
			
			
			ProductoDAOImpl dao = ProductoDAOImpl.getInstance();
			
			
			producto.setId(id);
			producto.setNombre(nombre);
			producto.setPrecio(precio);
			producto.setFoto(foto);
			
			
			if (id == 0) {
				dao.insert(producto);
			} else {
				dao.update(producto);
			}
			
			alerta = new Alerta("success", "Datos guardados");
			
			
		} catch (Exception e) {
			
			alerta = new Alerta( "danger", "Lo sentimos, a ocurrido un error" + e.getMessage() );
			e.printStackTrace();
			
		} finally {
			
			// enviar datos a la vista
			request.setAttribute("alerta", alerta);
			request.setAttribute("producto", producto);
			
			// ir a la nueva vista o jsp
			request.getRequestDispatcher("formulario-producto.jsp").forward(request, response);
			
		}
		
	}

}
