package com.ipartek.formacion.modelo;

import java.util.ArrayList;

public interface UsuarioDAO extends CrudAble<Usuario>{
	
	/**
	 * Busca alumnos que contengan la palabraBuscada
	 * @param palabraBuscada palabra a buscar
	 * @return ArrayList<Usuario>
	 */
	
	ArrayList<Usuario> getAllByNombre( String palabraBuscada );


}
