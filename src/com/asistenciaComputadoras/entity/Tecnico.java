package com.asistenciaComputadoras.entity;

public class Tecnico 
{
	private int codigo;
	private String nombreTe;
	private String apellidoTe;
	private String usuarioTe;
	private String contrase�aTe;
	
	public Tecnico (int codigo, String nombreTe,String  apellidoTe, String usuarioTe, String contrase�aTe )
	{
		this.codigo = codigo;
		this.nombreTe = nombreTe;
		this.apellidoTe = apellidoTe;
		this.usuarioTe = usuarioTe;
		this.contrase�aTe = contrase�aTe;
	}

	public Tecnico(String nombreTe, String apellidoTe, String usuarioTe, String contrase�aTe) {
		this.nombreTe = nombreTe;
		this.apellidoTe = apellidoTe;
		this.usuarioTe = usuarioTe;
		this.contrase�aTe = contrase�aTe;
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

	public String getContrase�aTe() {
		return contrase�aTe;
	}

	public void setContrase�aTe(String contrase�aTe) {
		this.contrase�aTe = contrase�aTe;
	}

	@Override
	public String toString() {
		return "Tecnico [codigo=" + codigo + ", nombreTe=" + nombreTe + ", apellidoTe=" + apellidoTe + ", usuarioTe="
				+ usuarioTe + ", contrase�aTe=" + contrase�aTe + "]";
	}
	
	

}
