package com.ipartek.formacion.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RolDAOImpl implements RolDAO {

	//Inicio Singleton
	private static RolDAOImpl INSTANCE = null;
		
	private RolDAOImpl() {
		super();
	}
	
	public static synchronized RolDAOImpl getInstance() {
		
		if (INSTANCE == null) {
			INSTANCE = new RolDAOImpl();
		}
		
		return INSTANCE;
	}
	//Fin Singleton
	
	
	// executeQuery => ResultSet
	private final String SQL_GET_ALL = " SELECT id, nombre FROM rol ORDER BY id DESC LIMIT 500 ; ";
	private final String SQL_GET_BY_ID = " SELECT id, nombre FROM rol WHERE id = ? LIMIT 500 ; ";
	
	// executeUpdate => int de numero de filas afectadas (affectedRows)
	private final String SQL_INSERT = " INSERT INTO rol (nombre) VALUES ( ? ); ";
	private final String SQL_DELETE = " DELETE FROM rol WHERE id = ? ; ";
	private final String SQL_UPDATE = " UPDATE rol SET nombre = ? WHERE id = ? ; ";
	
	
	
	
	/////////////////////////////////////////////////   getAll   ////////////////////////////////////////////////////
	@Override
	public ArrayList<Rol> getAll() {
		
		ArrayList<Rol> registros = new ArrayList<Rol>();
		
		try (
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();
				
			) {
			
				while ( rs.next() ) {
				
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				
				Rol r = new Rol();
				r.setId(id);
				r.setNombre(nombre);
				
				registros.add(r);
				
			} // while
			
				
		} catch (Exception e) {
				
				e.printStackTrace();
				
			}
		
		return registros;
	}

	
	/////////////////////////////////////////////////   getById   ////////////////////////////////////////////////////
	@Override
	public Rol getById(int id) throws Exception {
		
		Rol registro = new Rol();

		try (	Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_BY_ID);

			) {

			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				registro.setId(rs.getInt("id"));
				registro.setNombre(rs.getString("nombre"));
				

			} else {
				throw new Exception("No se puede encontrar registro con id=" + id);
			}// ifelse
		}

		return registro;

	}

	
	/////////////////////////////////////////////////   delete   ////////////////////////////////////////////////////
	@Override
	public Rol delete(int id) throws Exception {
		
		Rol registro = getById(id);
		
		
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
	public Rol insert(Rol pojo) throws Exception {
		
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
	public Rol update(Rol pojo) throws Exception {
		
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

}
