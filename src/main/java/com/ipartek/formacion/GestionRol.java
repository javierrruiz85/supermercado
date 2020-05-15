package com.ipartek.formacion;

import java.util.ArrayList;
import java.util.Scanner;

import com.ipartek.formacion.modelo.Rol;
import com.ipartek.formacion.modelo.RolDAOImpl;
import com.ipartek.formacion.modelo.Usuario;

public class GestionRol {

	static RolDAOImpl dao = RolDAOImpl.getInstance();
	static boolean continuar = false;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		try {

			

			do {

				System.out.println("");
				System.out.println("-----------------Menu-----------------");
				System.out.println("");
				System.out.println("1. Listar roles");
				System.out.println("2. Listar roles filtrados por ID");
				System.out.println("3. Borrar un rol");
				System.out.println("4. Crear un rol");
				System.out.println("5. Actualizar roles");
				System.out.println("");
				System.out.println("6. Salir");
				System.out.println("");
				System.out.println("--------------------------------------");
				
				
				System.out.println("Selecciona una opcion (1-6): ");

				int opcion = Integer.parseInt(sc.nextLine());

				switch (opcion) {
				case 1:
					listar();

					break;

				case 2:
					listarPorId();

					break;

				case 3:
					Borrar();

					break;

				case 4:
					Insertar();

					break;

				case 5:
					Actualizar();

					break;

				case 6:
					System.out.println("Hasta pronto");
					continuar = false;
					break;

				default:
					System.out.println("Por favor, introduce un numero del 1 al 6");
					break;
				} // switch

			} while (continuar); // while

		} catch (Exception e) {
			System.out.println("Debes insertar un numero del 1 al 6");
		} // try-catch

	} // main

	
	
	private static void listar() {

		ArrayList<Rol> roles = dao.getAll();

		System.out.println("--------------------------------------");
		System.out.println("Listado de roles");
		System.out.println("--------------------------------------");

		for (Rol r : roles) {
			System.out.println(r);
		}
		
		continuar = true;
		
	} // getAll
	
	
	private static void listarPorId() {

		System.out.println("--------------------------------------");
		System.out.println("Listado de roles");
		System.out.println("--------------------------------------");

		for (Rol r : dao.getAll()) {
			System.out.println(r);
		}

		try {

			System.out.println("Dime el ID del rol que quieras ver: ");
			int id = Integer.parseInt(sc.nextLine());

			Rol r = dao.getById(id);
			System.out.println(r);

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
		
		continuar = true;
		
	} // getById
	
	
	private static void Borrar() {

		System.out.println("--------------------------------------");
		System.out.println("Listado de roles");
		System.out.println("--------------------------------------");

		for (Rol r : dao.getAll()) {
			System.out.println(r);
		}

		try {
			System.out.println("Dime el id del rol a eliminar: ");
			int id = Integer.parseInt(sc.nextLine());

			Rol rEliminado = dao.delete(id);

			System.out.println(rEliminado.getNombre() + " eliminado con exito ");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		continuar = true;
	
	} // delete
	
	
	private static void Insertar() {
		
		boolean continuar = true;

		try {
			do {
				try {
					System.out.println("Dime el nombre del rol a insertar");
					String nombre = sc.nextLine();

					Rol rol = new Rol();
					rol.setNombre(nombre);

					rol = dao.insert(rol);
					continuar = false;

				} catch (Exception e) {
					System.out.println("Lo sentimos, el rol ya existe, dime otro:");
				}

			} while (continuar);

		} catch (Exception e) {
			System.out.println("Ha ocurrido un problema: " + e.getMessage());
		}
		
		continuar = true;
		
	} // insert
	
	
	private static void Actualizar() {
		
		System.out.println("--------------------------------------");
		System.out.println("Listado de roles");
		System.out.println("--------------------------------------");
		
		for (Rol r : dao.getAll()) {
			System.out.println(r);
		}
		
		try {
			System.out.println("Dime el ID para modificar un rol: ");
			int id = Integer.parseInt( sc.nextLine() );
			
			System.out.println("Dime el nuevo nombre para el rol: ");
			String nombre = sc.nextLine();
			
			Rol r = new Rol();
			r.setId(id);
			r.setNombre(nombre);
			
			dao.update(r);
			System.out.println("Rol modificado correctamente");
			
		} catch (Exception e) {
			System.out.println( e.getMessage() );
		}
		
		continuar = true;
		
	} // update

} // class
