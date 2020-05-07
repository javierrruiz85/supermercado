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
	private final String SQL_GET_ALL = " SELECT id, nombre, contrasenia, id_rol FROM usuario ORDER BY id DESC; ";
	private final String SQL_GET_BY_ID = " SELECT id, nombre, contrasenia, id_rol FROM usuario WHERE id = ? ; ";
	private final String SQL_GET_BY_NOMBRE = " SELECT id, nombre, contrasenia, id_rol FROM usuario WHERE nombre LIKE ? ; ";
	
	// executeUpdate => int de numero de filas afectadas (affectedRows)
	private final String SQL_INSERT = " INSERT INTO usuario (nombre, contrasenia, id_rol) VALUES ( ?, '12345', 1 ); ";
	private final String SQL_DELETE = " DELETE FROM usuario WHERE id = ? ; ";
	private final String SQL_UPDATE = " UPDATE usuario SET nombre = ? WHERE id = ? ; ";
	
	
	/////////////////////////////////////////////////   getAll   ////////////////////////////////////////////////////

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
				String contrasenia = rs.getString("contrasenia");
				int id_rol = rs.getInt("id_rol");
				
				Usuario u = new Usuario();
				u.setId(id);
				u.setNombre(nombre);
				u.setContrasenia(contrasenia);
				u.setId_rol(id_rol);
				
				//Usuario usuario2 = new Usuario(id, nombre); => es lo mismo que las 3 lineas de arriba (usuario u, setid y setnombre)
								
				//guardar en lista
				registros.add(u);
				
			} // while
			
				
		} catch (Exception e) {
				
				e.printStackTrace();
				
			}
		
		return registros;
	}
		

	/////////////////////////////////////////////////   getById   ////////////////////////////////////////////////////
	
	@Override
	public Usuario getById(int id) throws Exception {

		Usuario registro = new Usuario();

		try (	Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_BY_ID);

			) {

			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				registro.setId(rs.getInt("id"));
				registro.setNombre(rs.getString("nombre"));
				registro.setContrasenia(rs.getString("contrasenia"));
				registro.setId_rol(rs.getInt("id_rol"));

			} else {
				throw new Exception("No se puede encontrar registro con id=" + id);
			}// ifelse
		}

		return registro;

	}

	
	/////////////////////////////////////////////////   delete   ////////////////////////////////////////////////////
	
	@Override
	public Usuario delete(int id) throws Exception {
		
		Usuario registro = getById(id);
		
		
		try (
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_DELETE);
				
			) {
			
			pst.setInt(1, id);
			int affectedRows = pst.executeUpdate();
			
			if (affectedRows != 1) {
				throw new Exception("No se pudo eliminar al usuario con ID = " + id);
				
			}
			
		}//try
		
		
		return registro;
		
	}

	
	/////////////////////////////////////////////////   insert   ////////////////////////////////////////////////////
	
	@Override
	public Usuario insert(Usuario pojo) throws Exception {
		
		try (
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
				
			) {
			
			pst.setString(1, pojo.getNombre());
			int affectedRows = pst.executeUpdate();
			
			if (affectedRows == 1) {
				
				try ( ResultSet rsKeys = pst.getGeneratedKeys() ){
					
					if ( rsKeys.next() ) {
						int id = rsKeys.getInt(1);
						pojo.setId(id);
					}
				}//try2
				
			} else {
				
				throw new Exception ("No se ha podido guardar el registro " + pojo);
			}
						
		}//try 
		
		return pojo;
		
	}

	
	/////////////////////////////////////////////////   update   ////////////////////////////////////////////////////
	
	@Override
	public Usuario update(Usuario pojo) throws Exception {
		
		if (pojo == null) {
			throw new Exception("No se puede modificar si es null");
		}
		
		try (
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_UPDATE);
				
			) {
			
			pst.setString( 1, pojo.getNombre() );
			pst.setInt( 2, pojo.getId() );
			
			int affectedRows = pst.executeUpdate();
			
			if (affectedRows != 1) {
				throw new Exception( "No se pudo modificar el registro con ID=" + pojo.getId() );
			}
			
		} catch (Exception e) {
			throw new Exception( "Ya existe el usuario " + pojo.getNombre() );
		}
		
		return pojo;
		
	}

	
	//////////////////////////////////////////////   getAllByNombre   ////////////////////////////////////////////////
	
	@Override
	public ArrayList<Usuario> getAllByNombre(String palabraBuscada) {
		
		ArrayList<Usuario> registro = new ArrayList<Usuario>();

		try (	Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_BY_NOMBRE);

			) {

			pst.setString(1, "%" + palabraBuscada + "%");
			
			try (ResultSet rs = pst.executeQuery();) {
				
				while ( rs.next() ) {
					int id = rs.getInt("id");
					String nombre = rs.getString("nombre");
					String contrasenia = rs.getString("contrasenia");
					int id_rol = rs.getInt("id_rol");
					
					Usuario u = new Usuario();
					u.setId(id);
					u.setNombre(nombre);
					u.setContrasenia(contrasenia);
					u.setId_rol(id_rol);
					
					registro.add(u);
				} // while
				
			} // try2
		
		} catch (Exception e) {
			
			e.printStackTrace();

		} // catch

		return registro;
		
	}

}
