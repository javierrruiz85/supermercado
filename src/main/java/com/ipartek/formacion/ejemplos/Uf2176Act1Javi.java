package com.ipartek.formacion.ejemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Uf2176Act1Javi {
	
	private final static String URL = "jdbc:mysql://localhost/uf2176_act1_javi";
	private final static String USUARIO = "debian-sys-maint";
	private final static String PASS = "o8lAkaNtX91xMUcV";

	public static void main(String[] args) throws SQLException {
		
Connection con = DriverManager.getConnection(URL, USUARIO, PASS);

		
		// ---------------------------------------------------------------  CONSULTA 1  ----------------------------------------------------------------
		
		System.out.println("");
		System.out.println("");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		System.out.println("1. Lista el nombre de todos los productos que hay en la tabla producto.");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		
		String sql = "SELECT nombre FROM productos ORDER BY nombre ASC;";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		
		while ( rs.next() ) {
			System.out.println( rs.getString("nombre") );
		} // while
		
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		
		
		// ----------------------------------------------------------------  CONSULTA 2  ----------------------------------------------------------------
		
		System.out.println("");
		System.out.println("");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		System.out.println("2. Lista todas las columnas de la tabla producto.");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		
		sql = "SELECT codigo, nombre, precio, codigo_fabricante FROM productos ORDER BY codigo ASC;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while ( rs.next() ) {
			System.out.println( "codigo: " + rs.getInt("codigo") + " || nombre: " + rs.getString("nombre") + " || precio: " + rs.getFloat("precio") + "€ || codigo_fabricante: " + rs.getFloat("codigo_fabricante") );
		} // while
		
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		
		
		// ----------------------------------------------------------------  CONSULTA 3  ----------------------------------------------------------------

		System.out.println("");
		System.out.println("");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		System.out.println("3. Lista los nombres y los precios de todos los productos de la tabla producto, convirtiendo los nombres a mayúscula.");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		
		sql = "SELECT UPPER(nombre) 'nombre', precio FROM productos ORDER BY nombre ASC;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while ( rs.next() ) {
			System.out.println( "nombre: " + rs.getString("nombre")+ " || precio: " + rs.getFloat("precio") + "€" );
		}  // while
		
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		
		
		// ----------------------------------------------------------------  CONSULTA 4  ----------------------------------------------------------------

		System.out.println("");
		System.out.println("");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		System.out.println("4. Lista los nombres y los precios de todos los productos de la tabla producto, redondeando el valor del precio.");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		
		sql = "SELECT nombre, ROUND(precio, 1) 'precio' FROM productos ORDER BY precio ASC;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while ( rs.next() ) {
			System.out.println( "nombre: " + rs.getString("nombre")+ " || precio: " + rs.getFloat("precio") + "€" );
		} // while
		
		System.out.println("--------------------------------------------------------------------------------------------------------------");

		
		// ----------------------------------------------------------------  CONSULTA 5  ----------------------------------------------------------------

		System.out.println("");
		System.out.println("");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		System.out.println("5. Lista el código de los fabricantes que tienen productos en la tabla producto.");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		
		sql = "SELECT DISTINCT codigo_fabricante FROM productos ORDER BY codigo_fabricante ASC;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while ( rs.next() ) {
			System.out.println( "codigo_fabricante: " + rs.getInt("codigo_fabricante") );
		} // while
		
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		
		
		// ----------------------------------------------------------------  CONSULTA 6  ----------------------------------------------------------------

		System.out.println("");
		System.out.println("");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		System.out.println("6. Lista los nombres de los fabricantes ordenados de forma descendente.");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		
		sql = "SELECT nombre FROM fabricantes ORDER BY nombre DESC;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while ( rs.next() ) {
			System.out.println( "nombre: " + rs.getString("nombre") );
		} // while
		
		System.out.println("--------------------------------------------------------------------------------------------------------------");

		
		// ----------------------------------------------------------------  CONSULTA 7  ----------------------------------------------------------------

		System.out.println("");
		System.out.println("");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		System.out.println("7. Lista el nombre y el precio del producto más barato.");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		
		sql = "SELECT nombre, precio FROM productos ORDER BY precio ASC LIMIT 1;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while ( rs.next() ) {
			System.out.println( "nombre: " + rs.getString("nombre") + " || precio: " + rs.getFloat("precio") + "€" );
		} // while
		
		System.out.println("--------------------------------------------------------------------------------------------------------------");

		
		// ----------------------------------------------------------------  CONSULTA 8  ----------------------------------------------------------------

		System.out.println("");
		System.out.println("");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		System.out.println("8. Lista el nombre de los productos que no tienen un precio mayor o igual a 400€.");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		
		sql = "SELECT nombre, precio FROM productos WHERE precio < 400 ORDER BY nombre ASC;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while ( rs.next() ) {
			System.out.println( "nombre: " + rs.getString("nombre") + " || precio: " + rs.getFloat("precio") + "€" );
		} // while
		
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		
		
		// ----------------------------------------------------------------  CONSULTA 9  ----------------------------------------------------------------

		System.out.println("");
		System.out.println("");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		System.out.println("9. Devuelve una lista con el nombre de todos los productos que contienen la cadena 'Portátil' en el nombre.");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		
		sql = "SELECT nombre FROM productos WHERE nombre LIKE '%Portátil%' ORDER BY nombre ASC;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while ( rs.next() ) {
			System.out.println( "nombre: " + rs.getString("nombre") );
		} // while
		
		System.out.println("----------------------------------------------------------------------------------------------------");

		
		// ----------------------------------------------------------------  CONSULTA 10  ----------------------------------------------------------------

		System.out.println("");
		System.out.println("");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		System.out.println("10. Devuelve una lista con el nombre de todos los productos que contienen la cadena 'Monitor' en el nombre y tienen un precio inferior a 215 €.");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		
		sql = "SELECT nombre, precio FROM productos WHERE nombre LIKE '%monitor%' AND precio < 215 ORDER BY nombre ASC;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while ( rs.next() ) {
			System.out.println( "nombre: " + rs.getString("nombre") + " - precio: " + rs.getFloat("precio") + "€" );
		} // while
		
		System.out.println("--------------------------------------------------------------------------------------------------------------");

	} // main

} // class
