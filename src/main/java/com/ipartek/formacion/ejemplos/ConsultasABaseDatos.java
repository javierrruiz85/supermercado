package com.ipartek.formacion.ejemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConsultasABaseDatos {
	
	private final static String URL = "jdbc:mysql://localhost/supermercado";
	private final static String USUARIO = "debian-sys-maint";
	private final static String PASS = "o8lAkaNtX91xMUcV";

	public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager.getConnection(URL, USUARIO, PASS);

		
		// ---------------------------------------------------------------  CONSULTA 1  ----------------------------------------------------------------
		
		System.out.println("");
		System.out.println("");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		System.out.println("1. Listado de todos los productos");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		
		String sql = "SELECT id, nombre, precio FROM producto ORDER BY nombre ASC;";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		
		while ( rs.next() ) {
			System.out.println( rs.getInt("id") + " " + rs.getString("nombre") + " " + rs.getFloat("precio") );
		} // while
		
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		
		
		// ----------------------------------------------------------------  CONSULTA 2  ----------------------------------------------------------------
		
		System.out.println("");
		System.out.println("");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		System.out.println("2. Listar todas las columnas de la tabla productos");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		
		sql = "SELECT * from producto ORDER BY nombre ASC;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while ( rs.next() ) {
			System.out.println( rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getFloat(4) + " " + rs.getString(5) + " " + rs.getInt(6) );
		} // while
		
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		
		
		// ----------------------------------------------------------------  CONSULTA 3  ----------------------------------------------------------------

		System.out.println("");
		System.out.println("");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		System.out.println("3. Listar todos los nombres y precios de los productos, con los nombres en mayusculas");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		
		sql = "SELECT UPPER(nombre), precio FROM producto ORDER BY nombre ASC;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while ( rs.next() ) {
			System.out.println( rs.getString("UPPER(nombre)")+ " " + rs.getFloat("precio") );
		}  // while
		
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		
		
		// ----------------------------------------------------------------  CONSULTA 4  ----------------------------------------------------------------

		System.out.println("");
		System.out.println("");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		System.out.println("4. Listar los nombres y los precios de los productos redondeando el valor del precio");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		
		sql = "SELECT nombre, ROUND(precio, 1) FROM producto ORDER BY nombre ASC;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while ( rs.next() ) {
			System.out.println( rs.getString("nombre")+ " " + rs.getFloat("ROUND(precio, 1)") );
		} // while
		
		System.out.println("--------------------------------------------------------------------------------------------------------------");

		
		// ----------------------------------------------------------------  CONSULTA 5  ----------------------------------------------------------------

		System.out.println("");
		System.out.println("");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		System.out.println("5. Listar los codigos de las categorias de la tabla productos SIN REPETICIONES");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		
		sql = "SELECT DISTINCT id_categoria FROM producto;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while ( rs.next() ) {
			System.out.println( rs.getInt("id_categoria") );
		} // while
		
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		
		
		// ----------------------------------------------------------------  CONSULTA 6  ----------------------------------------------------------------

		System.out.println("");
		System.out.println("");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		System.out.println("6. Listar los nombres de las categorias de forma descendente");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		
		sql = "SELECT nombre FROM categoria ORDER BY nombre DESC;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while ( rs.next() ) {
			System.out.println( rs.getString("nombre") );
		} // while
		
		System.out.println("--------------------------------------------------------------------------------------------------------------");

		
		// ----------------------------------------------------------------  CONSULTA 7  ----------------------------------------------------------------

		System.out.println("");
		System.out.println("");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		System.out.println("7. Listar los productos con nombre y ordenarlos por el precio mas bajo");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		
		sql = "SELECT nombre, precio FROM producto ORDER BY precio ASC;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while ( rs.next() ) {
			System.out.println( rs.getString("nombre") + " " + rs.getFloat("precio") );
		} // while
		
		System.out.println("--------------------------------------------------------------------------------------------------------------");

		
		// ----------------------------------------------------------------  CONSULTA 8  ----------------------------------------------------------------

		System.out.println("");
		System.out.println("");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		System.out.println("8. Listar el nombre de los productos que tienen un precio mayor o igual a 2.35");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		
		sql = "SELECT nombre, precio FROM producto WHERE precio >= 2.35 ORDER BY precio ASC;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while ( rs.next() ) {
			System.out.println( rs.getString("nombre") + " " + rs.getFloat("precio") );
		} // while
		
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		
		
		// ----------------------------------------------------------------  CONSULTA 9  ----------------------------------------------------------------

		System.out.println("");
		System.out.println("");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		System.out.println("9. Listar todos los productos cuyo nombre contenga 'patatas'");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		
		sql = "SELECT nombre FROM producto WHERE nombre LIKE '%patata%' ORDER BY nombre DESC;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while ( rs.next() ) {
			System.out.println( rs.getString("nombre") );
		} // while
		
		System.out.println("----------------------------------------------------------------------------------------------------");

		
		// ----------------------------------------------------------------  CONSULTA 10  ----------------------------------------------------------------

		System.out.println("");
		System.out.println("");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		System.out.println("10. Listar todos los productos cuyo nombre contenga la palabra 'patata' y su precio sea superior a 2");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		
		sql = "SELECT nombre, precio FROM producto WHERE nombre LIKE '%patata%' AND precio > 2 ORDER BY nombre ASC;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while ( rs.next() ) {
			System.out.println( rs.getString("nombre") + " " + rs.getFloat("precio"));
		} // while
		
		System.out.println("--------------------------------------------------------------------------------------------------------------");


		
	} // main

} // class
