package com.ipartek.formacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ipartek.formacion.modelo.Producto;



public class ListarProductos {

	public static void main(String[] args) {
		System.out.println("Listado de productos");
		System.out.println("-------------------------");
		
		final String URL = "jdbc:mysql://localhost/supermercado";
		final String USUARIO = "debian-sys-maint";
		final String PASS = "o8lAkaNtX91xMUcV";
		final String SQL = "SELECT id, nombre FROM producto ORDER BY nombre ASC;";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Existe el jar para SQL");
			Connection conexion = DriverManager.getConnection (URL, USUARIO, PASS);
			System.out.println("Conexion con exito");
			
			//Realizar la consulta
			PreparedStatement pst = conexion.prepareStatement(SQL);
			ResultSet rs = pst.executeQuery();
			
			//consultar los resultados uno por uno
			while ( rs.next() ) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				
				Producto p = new Producto(nombre);
				p.setId(id);
				
				System.out.println(p);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
