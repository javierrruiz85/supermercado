package com.ipartek.formacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.ipartek.formacion.modelo.Producto;



public class InsertarProducto {

	public static void main(String[] args) {
		System.out.println("Insertar producto");
		System.out.println("-------------------------");
		
		final String URL = "jdbc:mysql://localhost/supermercado";
		final String USUARIO = "debian-sys-maint";
		final String PASS = "o8lAkaNtX91xMUcV";
		final String SQL = "INSERT INTO producto (nombre, id_usuario) VALUES (?, 1);";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Existe el jar para SQL");
			Connection conexion = DriverManager.getConnection (URL, USUARIO, PASS);
			System.out.println("Conexion con exito");
			
			//Realizar la consulta
			PreparedStatement pst = conexion.prepareStatement(SQL);
			
			
			//TODO pedir el nombre por pantalla
			Scanner teclado = new Scanner(System.in);
			System.out.println("Dame el nombre del producto a insertar: ");
			String nombre = teclado.nextLine();
			
			//cambiamos la interrogacion de SQL en VALUES por "Galletitas saladas"
			pst.setString(1, nombre);
			int affectedRows = pst.executeUpdate();
			System.out.println("Numero de registros creados " + affectedRows);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
