package com.asistenciaComputadoras.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.asistenciaComputadoras.entity.Dueño;

public class DueñoControl implements Control<Dueño>{
	private Conexion conexion;

	public DueñoControl(Conexion conexion) {
		this.conexion = conexion;
	}

	@Override
	public ArrayList<Dueño> list() throws Throwable {
		ArrayList<Dueño> lista_dueños = new ArrayList<>();
		ResultSet rs; 
		conexion.SQL("Select * from dueño");

		rs = conexion.resultSet();

		while (rs.next()) {
			int codigo = rs.getInt("Codigo");
			String nombre = rs.getString("nombre");
			String apellido = rs.getString("apellido");
			String usuario = rs.getString("usuario");
			String contraseña = rs.getString("contraseña");

			lista_dueños.add(new Dueño(codigo, nombre, apellido, usuario, contraseña));
		}

		return lista_dueños;
	}

	@Override
	public void insert(Dueño dueño) throws Throwable {
		conexion.SQL("Insert into dueño(nombre,apellido,usuario,contraseña) VALUES(?,?,?,?)");
		conexion.preparedStatement().setString(1, dueño.getNombre());
		conexion.preparedStatement().setString(2, dueño.getApellidos());
		conexion.preparedStatement().setString(3, dueño.getUsuario());
		conexion.preparedStatement().setString(4, dueño.getContraseña());
		conexion.CUD();
	}

	@Override
	public void search(Dueño dueño) throws Throwable {
		ResultSet rs;

		conexion.SQL("Select * from dueño where Codigo=?");
		conexion.preparedStatement().setInt(1, dueño.getCodigo());
		rs = conexion.resultSet();

		while (rs.next()) {
			dueño.setNombre(rs.getString("nombre"));
			dueño.setApellidos(rs.getString("apellido"));
			dueño.setUsuario(rs.getString("usuario"));
			dueño.setContraseña(rs.getString("contraseña"));
		}

		rs.close();
	}

	@Override
	public void update(Dueño dueño) throws Throwable {
		if (dueño != null) {
			int codigo = dueño.getCodigo();
			String nombre = dueño.getNombre();
			String apellido = dueño.getApellidos();
			String usuario = dueño.getUsuario();
			String contraseña = dueño.getContraseña();

			conexion.SQL("Update dueño set nombre=?,apellido=?,usuario=?,contraseña=? where Codigo=?");
			conexion.preparedStatement().setString(1, nombre);
			conexion.preparedStatement().setString(2, apellido);
			conexion.preparedStatement().setString(3, usuario);
			conexion.preparedStatement().setString(4, contraseña);
			conexion.preparedStatement().setInt(5, codigo);
			conexion.CUD();
		}
	}

	

}
