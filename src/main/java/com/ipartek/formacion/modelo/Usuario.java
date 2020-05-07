package com.ipartek.formacion.modelo;

public class Usuario {

	private int id;
	private String nombre;
	private String contrasenia;
	private int id_rol;

	public Usuario() {
		super();

		this.id = 0;
		this.nombre = "";
		this.contrasenia = "";
		this.id_rol = 0;

	}

	public Usuario(String nombre) {
		this();
		this.nombre = nombre;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public int getId_rol() {
		return id_rol;
	}

	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", contrasenia=" + contrasenia + ", id_rol=" + id_rol + "]";
	}
	
	
}
