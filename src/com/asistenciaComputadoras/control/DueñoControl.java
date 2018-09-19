package com.asistenciaComputadoras.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.asistenciaComputadoras.entity.Due�o;

public class Due�oControl implements Control<Due�o>{
	private Conexion conexion;

	public Due�oControl(Conexion conexion) {
		this.conexion = conexion;
	}

	@Override
	public ArrayList<Due�o> list() throws Throwable {
		ArrayList<Due�o> lista_due�os = new ArrayList<>();
		ResultSet rs; 
		conexion.SQL("Select * from due�o");

		rs = conexion.resultSet();

		while (rs.next()) {
			int codigo = rs.getInt("Codigo");
			String nombre = rs.getString("nombre");
			String apellido = rs.getString("apellido");
			String usuario = rs.getString("usuario");
			String contrase�a = rs.getString("contrase�a");

			lista_due�os.add(new Due�o(codigo, nombre, apellido, usuario, contrase�a));
		}

		return lista_due�os;
	}

	@Override
	public void insert(Due�o due�o) throws Throwable {
		conexion.SQL("Insert into due�o(nombre,apellido,usuario,contrase�a) VALUES(?,?,?,?)");
		conexion.preparedStatement().setString(1, due�o.getNombre());
		conexion.preparedStatement().setString(2, due�o.getApellidos());
		conexion.preparedStatement().setString(3, due�o.getUsuario());
		conexion.preparedStatement().setString(4, due�o.getContrase�a());
		conexion.CUD();
	}

	@Override
	public void search(Due�o due�o) throws Throwable {
		ResultSet rs;

		conexion.SQL("Select * from due�o where Codigo=?");
		conexion.preparedStatement().setInt(1, due�o.getCodigo());
		rs = conexion.resultSet();

		while (rs.next()) {
			due�o.setNombre(rs.getString("nombre"));
			due�o.setApellidos(rs.getString("apellido"));
			due�o.setUsuario(rs.getString("usuario"));
			due�o.setContrase�a(rs.getString("contrase�a"));
		}

		rs.close();
	}

	@Override
	public void update(Due�o due�o) throws Throwable {
		if (due�o != null) {
			int codigo = due�o.getCodigo();
			String nombre = due�o.getNombre();
			String apellido = due�o.getApellidos();
			String usuario = due�o.getUsuario();
			String contrase�a = due�o.getContrase�a();

			conexion.SQL("Update due�o set nombre=?,apellido=?,usuario=?,contrase�a=? where Codigo=?");
			conexion.preparedStatement().setString(1, nombre);
			conexion.preparedStatement().setString(2, apellido);
			conexion.preparedStatement().setString(3, usuario);
			conexion.preparedStatement().setString(4, contrase�a);
			conexion.preparedStatement().setInt(5, codigo);
			conexion.CUD();
		}
	}

	

}
