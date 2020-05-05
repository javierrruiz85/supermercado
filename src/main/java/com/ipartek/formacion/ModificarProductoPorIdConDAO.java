package com.ipartek.formacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAO;
import com.mysql.jdbc.PreparedStatement.ParseInfo;

public class ModificarProductoPorIdConDAO {

	public static void main(String[] args) {
		
		ProductoDAO dao = ProductoDAO.getInstance();
		
		System.out.println("Listado de productos");
		System.out.println("--------------------------");
		
		for (Producto p : dao.getAll()) {
			System.out.println(p);
		}
		
		try ( Scanner sc = new Scanner(System.in) ) {
			System.out.println("Dime el ID para modificar el producto: ");
			int id = Integer.parseInt( sc.nextLine() );
			
			System.out.println("Dime el nuevo nombre para el producto: ");
			String nombre = sc.nextLine();
			
			Producto p = new Producto();
			p.setId(id);
			p.setNombre(nombre);
			
			dao.update(p);
			System.out.println("Producto modificado correctamente");
			
		} catch (Exception e) {
			System.out.println( e.getMessage() );
		}		
	}// main

}
