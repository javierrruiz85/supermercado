package com.ipartek.formacion.modelo;

import java.util.ArrayList;

public interface UsuarioDAO extends CrudAble<Usuario>{
	
	/**
	 * Busca alumnos que contengan la palabraBuscada
	 * @param palabraBuscada palabra a buscar
	 * @return ArrayList<Usuario>
	 */
	
	ArrayList<Usuario> getAllByNombre( String palabraBuscada );
	
	
	
	
	/**
	 * Busca si existe el usuario en la base de datos
	 * @param nombre
	 * @param password
	 * @return Si lo encuentra devuelve el usuario con datos, si NO lo encuentra, devuelve null
	 */
	
	Usuario existe (String nombre, String password);


}
