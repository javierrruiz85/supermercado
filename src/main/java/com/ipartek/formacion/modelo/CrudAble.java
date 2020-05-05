package com.ipartek.formacion.modelo;

import java.util.ArrayList;

public interface CrudAble<P> {
	
	ArrayList<P> getAll();
	
	P getById(int id) throws Exception;
	
	P delete(int id) throws Exception;
	
	P insert(P pojo) throws Exception;
	
	P update(P pojo) throws Exception;

}
