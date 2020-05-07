package com.ipartek.formacion;

import java.util.ArrayList;
import java.util.Scanner;

import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAO;
import com.ipartek.formacion.modelo.Usuario;
import com.ipartek.formacion.modelo.UsuarioDAO;
import com.ipartek.formacion.modelo.UsuarioDAOImpl;

public class GestionUsuarios {

	static UsuarioDAOImpl dao = UsuarioDAOImpl.getInstance();
	static boolean salir = false;
	

	public static void main(String[] args) {
		
		while (!salir) {
			
			System.out.println("-----------------Menu-----------------");
			System.out.println("");
			System.out.println("1. Listar usuarios");
			System.out.println("2. Listar usuarios filtrados por ID");
			System.out.println("3. Listar usuarios filtrados por nombre");
			System.out.println("4. Borrar un usuario");
			System.out.println("5. Crear un usuario");
			System.out.println("6. Actualizar usuarios");
			System.out.println("");
			System.out.println("7. Salir");
			System.out.println("");
			System.out.println("--------------------------------------");
			
			
			
			try {
				
				System.out.println("Selecciona una opcion (1-7): ");
				
				Scanner sc = new Scanner(System.in);
				int opcion = Integer.parseInt(sc.nextLine());
				
				switch (opcion) {
				case 1:
					listar();

					break;

				case 2:
					listarPorId();

					break;

				case 3:
					listarPorNombre();

					break;

				case 4:
					Borrar();

					break;

				case 5:
					Insertar();

					break;

				case 6:
					Actualizar();

					break;
					
				case 7:
					salir = true;
					break;

				default:
					System.out.println("Por favor, introduce un numero del 1 al 7");
					break;
				} // switch
				
			} catch (Exception e) {
				System.out.println("Debes insertar un numero del 1 al 7");
			} // try-catch
			
		}// while

	} // main

	
	private static void listar() { // getAll

		// Inicio GetAll

		ArrayList<Usuario> usuarios = dao.getAll();

		System.out.println("--------------------------------------");
		System.out.println("Listado de usuarios");
		System.out.println("--------------------------------------");

		for (Usuario u : usuarios) {
			System.out.println(u);
		}

		// Inicio GetAll

	}

	private static void listarPorId() { // getById

		// Inicio GetByID

		System.out.println("--------------------------------------");
		System.out.println("Listado de usuarios");
		System.out.println("--------------------------------------");

		for (Usuario u : dao.getAll()) {
			System.out.println(u);
		}

		try (Scanner sc = new Scanner(System.in)) {

			System.out.println("Dime el ID del usuario que quieras ver: ");
			int id = Integer.parseInt(sc.nextLine());

			Usuario u = dao.getById(id);
			System.out.println(u);

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		// Final GetByID

	}

	private static void listarPorNombre() { // getAllByNombre
		
		// Inicio GetAllByNombre
		
		System.out.println("Dime el nombre del usuario que deseas buscar: ");
		Scanner sc = new Scanner(System.in);
		String buscar = sc.nextLine();
		
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		
		if (lista.isEmpty()) {
			System.out.println("No hay coincidencias");
		}
		else {
			for (Usuario usuario : lista) {
				System.out.println(usuario);
			}
		}

		// Final GetAllByNombre

	}

	private static void Borrar() { // delete

		// Inicio delete

		System.out.println("--------------------------------------");
		System.out.println("Listado de usuarios");
		System.out.println("--------------------------------------");

		for (Usuario u : dao.getAll()) {
			System.out.println(u);
		}

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Dime el id del usuario a eliminar: ");
			int id = Integer.parseInt(sc.nextLine());

			Usuario uEliminado = dao.delete(id);

			System.out.println(uEliminado.getNombre() + " eliminado con exito ");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Final delete

	}

	private static void Insertar() { // insert
		
		// Inicio insert

		boolean continuar = true;

		try (Scanner sc = new Scanner(System.in)) {

			do {

				try {
					System.out.println("Dime el nombre del usuario a insertar");
					String nombre = sc.nextLine();

					Usuario usuario = new Usuario();
					usuario.setNombre(nombre);

					usuario = dao.insert(usuario);
					continuar = false;

				} catch (Exception e) {
					System.out.println("Lo sentimos, el usuario ya existe, dime otro:");

				}

			} while (continuar);

		} catch (Exception e) {

			System.out.println("Ha ocurrido un problema: " + e.getMessage());

		}

		// Final insert

	}

	private static void Actualizar() { // update
		
		// Inicio update
		
		System.out.println("--------------------------------------");
		System.out.println("Listado de usuarios");
		System.out.println("--------------------------------------");
		
		for (Usuario u : dao.getAll()) {
			System.out.println(u);
		}
		
		try ( Scanner sc = new Scanner(System.in) ) {
			System.out.println("Dime el ID para modificar un usuario: ");
			int id = Integer.parseInt( sc.nextLine() );
			
			System.out.println("Dime el nuevo nombre para el usuario: ");
			String nombre = sc.nextLine();
			
			Usuario u = new Usuario();
			u.setId(id);
			u.setNombre(nombre);
			
			dao.update(u);
			System.out.println("Usuario modificado correctamente");
			
		} catch (Exception e) {
			System.out.println( e.getMessage() );
		}

		// Final update

	}

}
