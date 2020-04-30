package com.ipartek.formacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.ipartek.formacion.modelo.Producto;



public class InsertarProductoComprobarRepetido {

	public static void main(String[] args) {
		System.out.println("Insertar producto");
		System.out.println("-------------------------");
		
		final String URL = "jdbc:mysql://localhost/supermercado";
		final String USUARIO = "debian-sys-maint";
		final String PASS = "o8lAkaNtX91xMUcV";
		final String SQL = "INSERT INTO producto (nombre, id_usuario) VALUES (?, 1);";
		
		Scanner teclado = new Scanner(System.in);
		boolean continuar = true; 

		try {

			Scanner sc = new Scanner(System.in);

			// comprobar que tengamos el .jar de MySQL
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Existe el .jar para mysql");

			// conectarnos a la bbdd supermercado
			Connection conexion = DriverManager.getConnection(URL, USUARIO, PASS);
			System.out.println("Conexion con exito");

			// Realizar una consulta
			PreparedStatement pst = conexion.prepareStatement(SQL);

			System.out.println("Dime un producto a guardar");
			
			
			do {
			
				String nombre = sc.nextLine();
	
				// cambiamos el 1º ? de la SQL por la varaiabel nombre
				// INSERT INTO producto (nombre, id_usuario) VALUES ( ? , 1) ;
				pst.setString(1, nombre);
	
				try {
					
					int affectedRows = pst.executeUpdate();
					// affedetedRows es el numero de registros insertados
					if (affectedRows == 1) {
						System.out.println("El producto se ha guardado con exito");
						continuar = false;
					}
					
				} catch (Exception e) {
					System.out.println("Lo sentimos pero el nombre ya existe, dime otro:");
					
				}
				
			} while(continuar);	
				

		} catch (Exception e) {

			System.out.println("Tenemos un problema " + e.getMessage());

		}
		
		System.out.println("Agur, nos vemos otro día");

	}

}
