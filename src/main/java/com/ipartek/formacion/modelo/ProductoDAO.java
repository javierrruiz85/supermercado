package com.ipartek.formacion.modelo;

import java.util.ArrayList;



public interface ProductoDAO extends CrudAble<Producto>{
		
	/**
	 * Busca alumnos que contengan la palabraBuscada
	 * @param palabraBuscada palabra a buscar
	 * @return ArrayList<Usuario>
	 */
	
	ArrayList<Producto> getAllByNombre( String palabraBuscada );


}
	

