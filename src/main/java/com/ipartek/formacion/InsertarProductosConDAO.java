package com.ipartek.formacion;

import java.util.Scanner;

import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAOImpl;

public class InsertarProductosConDAO {
	
	public static void main(String[] args) {


		boolean continuar = true; 
		ProductoDAOImpl dao = ProductoDAOImpl.getInstance();				

		try( Scanner sc = new Scanner(System.in)) {	
			
			do {
				
				try {
					System.out.println("Dime el nombre del producto a guardar");
					String nombre = sc.nextLine();	
					
					Producto producto = new Producto();
					producto.setNombre(nombre);
					
					producto = dao.insert(producto);
					continuar = false;
				
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
