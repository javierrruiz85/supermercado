package com.ipartek.formacion.modelo;

public class Usuario {

	private int id;
	private String nombre;
	private String contrasenia;
	private int idRol;
	private float precio;
	private String foto;
	

	public Usuario() {
		super();

		this.id = 0;
		this.nombre = "";
		this.contrasenia = "";
		this.idRol = 0;
		this.precio = 0;
		this.foto = "https://picsum.photos/50/75";

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

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int id_rol) {
		this.idRol = id_rol;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", contrasenia=" + contrasenia + ", idRol=" + idRol
				+ ", precio=" + precio + ", foto=" + foto + "]";
	}

	
	
}
