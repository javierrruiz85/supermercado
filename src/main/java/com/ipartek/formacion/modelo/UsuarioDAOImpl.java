package com.ipartek.formacion.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsuarioDAOImpl implements UsuarioDAO{
	
	//Inicio Singleton
	private static UsuarioDAOImpl INSTANCE = null;
		
	private UsuarioDAOImpl() {
		super();
	}
	
	public static synchronized UsuarioDAOImpl getInstance() {
		
		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAOImpl();
		}
		
		return INSTANCE;
	}
	//Fin Singleton
	
	
	// executeQuery => ResultSet
	private final String SQL_GET_ALL = " SELECT id, nombre FROM usuario ORDER BY id DESC; ";
	private final String SQL_GET_BY_ID = " SELECT id, nombre FROM usuario WHERE id = ? ; ";
	private final String SQL_GET_BY_NOMBRE = " SELECT id, nombre FROM usuario WHERE nombre LIKE ? ; ";
	
	// executeUpdate => int de numero de filas afectadas (affectedRows)
	private final String SQL_INSERT = " INSERT INTO usuario (nombre, contrasenia, id_rol) VALUES ( ?, 12345, 1 ); ";
	private final String SQL_DELETE = " DELETE FROM usuario WHERE id = ? ; ";
	private final String SQL_UPDATE = " UPDATE usuario SET nombre = ? WHERE id = ? ; ";
	
	
	

	@Override
	public ArrayList<Usuario> getAll() {
		
		
		ArrayList<Usuario> registros = new ArrayList<Usuario>();
		
		try (
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();
				
			) {
			
				while ( rs.next() ) {
				
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				
				Usuario u = new Usuario(nombre);
				u.setId(id);
				u.setNombre(nombre);
				
				//Usuario usuario2 = new Usuario(id, nombre); => es lo mismo que las 3 lineas de arriba
								
				//guardar en lista
				registros.add(u);
				
			} // while
			
				
		} catch (Exception e) {
				
				e.printStackTrace();
				
			}
		
		return registros;
	}
		

	@Override
	public Usuario getById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario insert(Usuario pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario update(Usuario pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Usuario> getAllByNombre(String palabraBuscada) {
		// TODO Auto-generated method stub
		return null;
	}

}
