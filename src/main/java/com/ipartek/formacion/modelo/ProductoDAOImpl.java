package com.ipartek.formacion.modelo;

/**
 * 
 * Descripcion
 * 
 * Clase que realiza un CRUD de los productos de un supermercado
 * 
 * @see https://github.com/javierrruiz85?tab=repositories
 * 
 * @author Javier Ruiz
 * 
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductoDAOImpl implements ProductoDAO{
	
	private static ProductoDAOImpl INSTANCE = null;
	
	private ProductoDAOImpl() {
		super();
	}
	
	public static synchronized ProductoDAOImpl getInstance() {
		
		if (INSTANCE == null) {
			INSTANCE = new ProductoDAOImpl();
		}
		
		return INSTANCE;
	}
	
	// executeQuery => ResultSet
	private final String SQL_GET_ALL = " SELECT id, nombre, precio, foto FROM producto ORDER BY id DESC LIMIT 500; ";
	private final String SQL_GET_BY_ID = " SELECT id, nombre, precio, foto FROM producto WHERE id = ? LIMIT 500 ; ";
	
	// executeUpdate => int de numero de filas afectadas (affectedRows)
	private final String SQL_INSERT = " INSERT INTO producto (nombre, precio, foto, id_usuario) VALUES ( ?, ?, ?, 1 ); ";
	private final String SQL_DELETE = " DELETE FROM producto WHERE id = ? ; ";
	private final String SQL_UPDATE = " UPDATE producto SET nombre = ?, precio = ?, foto = ? WHERE id = ? ; ";
	
	
	public ArrayList<Producto> getAllByNombre( String nombre ) {
		
		return null;
	}	

	@Override
	public ArrayList<Producto> getAll() {
		
		ArrayList<Producto> registros = new ArrayList<Producto>();
		
		try (
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();
				
			) {
			
				while ( rs.next() ) {
				
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				float precio = rs.getFloat("precio");
				String foto = rs.getString("foto");
				
				Producto p = new Producto(nombre);
				p.setId(id);
				p.setPrecio(precio);
				p.setFoto(foto);
								
				//guardar en lista
				registros.add(p);
				
			} // while
			
				
		} catch (Exception e) {
				
				e.printStackTrace();
				
			}
		
		return registros;
	}

	
	@Override
	public Producto getById(int id) throws Exception {
		Producto registro = new Producto();
		
		try (
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_BY_ID);
				
			) {
			
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if ( rs.next() ) {
				registro.setId(rs.getInt("id"));
				registro.setNombre(rs.getString("nombre"));
				registro.setPrecio(rs.getFloat("precio"));
				registro.setFoto(rs.getString("foto"));
				
			} else {
				throw new Exception("No se puede encontrar registro con id=" + id);
			}
		}
		
		
		return registro;
	}

	
	@Override
	public Producto delete(int id) throws Exception {
		
		Producto registro = getById(id);
		
		
		try (
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_DELETE);
				
			) {
			
			pst.setInt(1, id);
			int affectedRows = pst.executeUpdate();
			
			if (affectedRows != 1) {
				throw new Exception("No se pudo eliminar el registro con ID = " + id);
				
			}
			
		}//try
		
		
		return registro;
	}

	
	@Override
	public Producto insert(Producto pojo) throws Exception {
		
		try (
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
				
			) {
			
			pst.setString(1, pojo.getNombre());
			pst.setFloat(2, pojo.getPrecio());
			pst.setString(3, pojo.getFoto());
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

	
	@Override
	public Producto update(Producto pojo) throws Exception {
		
		if (pojo == null) {
			throw new Exception("No se puede modificar si es null");
		}
		
		try (
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_UPDATE);
				
			) {
			
			pst.setString( 1, pojo.getNombre() );
			pst.setFloat( 2, pojo.getPrecio() );
			pst.setString( 3, pojo.getFoto() );
			pst.setInt( 4, pojo.getId() );
			
			int affectedRows = pst.executeUpdate();
			
			if (affectedRows != 1) {
				throw new Exception( "No se pudo modificar el registro con ID=" + pojo.getId() );
			}
			
		} catch (Exception e) {
			throw new Exception( "Ya existe el producto con nombre " + pojo.getNombre() );
		}
		
		return pojo;
	}
	

}
