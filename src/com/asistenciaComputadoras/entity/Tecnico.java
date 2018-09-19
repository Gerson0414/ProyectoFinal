package com.asistenciaComputadoras.entity;

public class Tecnico 
{
	private int codigo;
	private String nombreTe;
	private String apellidoTe;
	private String usuarioTe;
	private String contraseñaTe;
	
	public Tecnico (int codigo, String nombreTe,String  apellidoTe, String usuarioTe, String contraseñaTe )
	{
		this.codigo = codigo;
		this.nombreTe = nombreTe;
		this.apellidoTe = apellidoTe;
		this.usuarioTe = usuarioTe;
		this.contraseñaTe = contraseñaTe;
	}

	public Tecnico(String nombreTe, String apellidoTe, String usuarioTe, String contraseñaTe) {
		this.nombreTe = nombreTe;
		this.apellidoTe = apellidoTe;
		this.usuarioTe = usuarioTe;
		this.contraseñaTe = contraseñaTe;
	}

	public Tecnico(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombreTe() {
		return nombreTe;
	}

	public void setNombreTe(String nombreTe) {
		this.nombreTe = nombreTe;
	}

	public String getApellidoTe() {
		return apellidoTe;
	}

	public void setApellidoTe(String apellidoTe) {
		this.apellidoTe = apellidoTe;
	}

	public String getUsuarioTe() {
		return usuarioTe;
	}

	public void setUsuarioTe(String usuarioTe) {
		this.usuarioTe = usuarioTe;
	}

	public String getContraseñaTe() {
		return contraseñaTe;
	}

	public void setContraseñaTe(String contraseñaTe) {
		this.contraseñaTe = contraseñaTe;
	}

	@Override
	public String toString() {
		return "Tecnico [codigo=" + codigo + ", nombreTe=" + nombreTe + ", apellidoTe=" + apellidoTe + ", usuarioTe="
				+ usuarioTe + ", contraseñaTe=" + contraseñaTe + "]";
	}
	
	

}
