package com.ipartek.formacion.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	private final String SQL_GET_ALL 		= " SELECT u.id, u.nombre, contrasenia, id_rol, r.nombre AS 'nombre_rol', precio, foto FROM usuario AS u INNER JOIN rol AS r ON u.id_rol = r.id ORDER BY u.id DESC LIMIT 500 ; ";
	private final String SQL_GET_BY_ID 		= " SELECT u.id, u.nombre, contrasenia, id_rol, r.nombre AS 'nombre_rol', precio, foto FROM usuario AS u INNER JOIN rol AS r ON u.id_rol = r.id WHERE u.id = ? LIMIT 500 ; ";
	private final String SQL_GET_BY_NOMBRE 	= " SELECT u.id, u.nombre, contrasenia, id_rol, r.nombre AS 'nombre_rol', precio, foto FROM usuario AS u INNER JOIN rol AS r ON u.id_rol = r.id WHERE u.nombre LIKE ? LIMIT 500 ; ";
	private final String SQL_EXISTE 		= " SELECT u.id, u.nombre, contrasenia, id_rol, r.nombre AS 'nombre_rol', precio, foto FROM usuario AS u INNER JOIN rol AS r ON u.id_rol = r.id WHERE u.nombre = ? AND contrasenia = ? LIMIT 500 ; ";
	
	// executeUpdate => int de numero de filas afectadas (affectedRows)
	private final String SQL_INSERT = " INSERT INTO usuario (nombre, contrasenia, id_rol, precio, foto) VALUES ( ?, ?, ?, ?, ? ); ";
	private final String SQL_DELETE = " DELETE FROM usuario WHERE id = ? ; ";
	private final String SQL_UPDATE = " UPDATE usuario SET nombre = ?, contrasenia = ?, id_rol = ?, precio = ?, foto = ? WHERE id = ? ; ";
	
	
	
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
					registros.add(mapper(rs)); // gracias al mapper del final de la pagina, esto hace lo mismo que todas las lineas comentadas abajo
				//int id = rs.getInt("id");
				//String nombre = rs.getString("nombre");
				//String contrasenia = rs.getString("contrasenia");
				//int idRol = rs.getInt("id_rol");
				//float precio = rs.getFloat("precio");
				//String foto = rs.getString("foto");
				
				//Usuario u = new Usuario();
				//u.setId(id);
				//u.setNombre(nombre);
				//u.setContrasenia(contrasenia);
				//u.setIdRol(idRol);
				//u.setPrecio(precio);
				//u.setFoto(foto);
				
				//Usuario usuario2 = new Usuario(id, nombre); => es lo mismo que las 3 lineas de arriba (usuario u, setid y setnombre)
								
				//guardar en lista
				//registros.add(u);
				
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
				//registro.setId(rs.getInt("id"));
				//registro.setNombre(rs.getString("nombre"));
				//registro.setContrasenia(rs.getString("contrasenia"));
				//registro.setIdRol(rs.getInt("id_rol"));
				//registro.setPrecio(rs.getFloat("precio"));
				//registro.setFoto(rs.getString("foto"));
				
				
				// con esta linea, usando el mapper construido abajo del todo, nos ahorramos las 6 lineas comentadas arriba
				registro = mapper(rs);

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
			pst.setString(2, pojo.getContrasenia());
			pst.setInt(3, pojo.getRol() .getId());
			pst.setFloat(4, pojo.getPrecio());
			pst.setString(5, pojo.getFoto());
			
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				
				try ( ResultSet rsKeys = pst.getGeneratedKeys() ){
					
					if ( rsKeys.next() ) {
						pojo.setId(rsKeys.getInt(1));
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
			
			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getContrasenia());
			pst.setInt(3, pojo.getRol() .getId());
			pst.setFloat(4, pojo.getPrecio());
			pst.setString(5, pojo.getFoto());
			pst.setInt(6, pojo.getId());
			
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
		
		ArrayList<Usuario> registros = new ArrayList<Usuario>();

		try (	Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_BY_NOMBRE);

			) {

			pst.setString(1, "%" + palabraBuscada + "%");
			
			try (ResultSet rs = pst.executeQuery();) {
				
				while ( rs.next() ) {
					registros.add(mapper(rs)); // gracias al mapper creado abajo, con esta linea hacemos lo mismo que con todas las comentadas abajo
					
					//int id = rs.getInt("id");
					//String nombre = rs.getString("nombre");
					//String contrasenia = rs.getString("contrasenia");
					//int idRol = rs.getInt("id_rol");
					//float precio = rs.getFloat("precio");
					//String foto = rs.getString("foto");
					
					//Usuario u = new Usuario();
					//u.setId(id);
					//u.setNombre(nombre);
					//u.setContrasenia(contrasenia);
					//u.setIdRol(idRol);
					//u.setPrecio(precio);
					//u.setFoto(foto);
					
					//registro.add(u);
				} // while
				
			} // try2
		
		} catch (Exception e) {
			
			e.printStackTrace();

		} // catch

		return registros;
		
	}

	
	//////////////////////////////////////////////   existe   ////////////////////////////////////////////////
	
	@Override
	public Usuario existe(String nombre, String password) {
		
		Usuario registro = null;

		try (	Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_EXISTE);
			) {

			pst.setString(1, nombre);
			pst.setString(2, password);
			
			try (ResultSet rs = pst.executeQuery()) {
				
				if (rs.next()) {
					registro = mapper(rs); // con el mapper nos ahorramos todas las lineas comentadas a continuacion
					
					//registro = new Usuario();
					//registro.setId(rs.getInt("id"));
					//registro.setNombre(rs.getString("nombre"));
					//registro.setContrasenia(rs.getString("contrasenia"));
					//registro.setIdRol(rs.getInt("id_rol"));
					//registro.setPrecio(rs.getFloat("precio"));
					//registro.setFoto(rs.getString("foto"));
				} // if
				
			} // try 2
	
		} catch (Exception e) {
			e.printStackTrace();
		} // try-catch 1

		return registro;
		
	}
	
	
	//////////////////////////////////////////////   mapper   ////////////////////////////////////////////////
	
	private Usuario mapper( ResultSet rs ) throws SQLException {
		
		Usuario registro = new Usuario();
		
		
		registro.setId(rs.getInt("id"));
		registro.setNombre(rs.getString("nombre"));
		registro.setContrasenia( rs.getString("contrasenia"));
		registro.setPrecio(rs.getFloat("precio"));
		registro.setFoto(rs.getString("foto"));
		
		//rol, para poder hacerlo, cogemos el "id_rol" de la tabla usuarios y lo seteamos a rol.setId, y con el alias "nombre_rol" que le hemos dado en la sql, cogemos el nombre de la tabla rol y lo seteamos a rol.setNombre
		Rol rol = new Rol();
		rol.setId(rs.getInt("id_rol"));
		rol.setNombre(rs.getString("nombre_rol"));
		
		// setear el rol al usuario
		registro.setRol(rol);
		
		return registro;
		
	}

}
