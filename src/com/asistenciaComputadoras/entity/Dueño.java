package com.asistenciaComputadoras.entity;

public class Due�o {
	private int codigo;
	
	private String nombre;
	private String apellidos;
	private String usuario;
	private String contrase�a;
	
	public Due�o(int codigo, String nombre, String apellidos, String usuario, String contrase�a){
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.usuario = usuario;
		this.contrase�a = contrase�a;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	@Override
	public String toString() {
		return "Due�o [codigo=" + codigo + ", nombre=" + nombre + ", apellidos=" + apellidos + ", usuario=" + usuario
				+ ", contrase�a=" + contrase�a + "]";
	}

}
