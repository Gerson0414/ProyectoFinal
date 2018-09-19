package com.asistenciaComputadoras.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.asistenciaComputadoras.entity.Accesorios;
public class AccesoriosControl implements Control<Accesorios>{
	

	private Conexion conexion;

	public AccesoriosControl(Conexion conexion) {
		this.conexion = conexion;
	}

	@Override
	public ArrayList<Accesorios> list() throws Throwable {
		ArrayList<Accesorios> lista_accesorios = new ArrayList<Accesorios>();
		ResultSet rs;
		conexion.SQL("Select * from accesorios");
 
		rs = conexion.resultSet();

		while (rs.next()) {
			int codigo = rs.getInt("codigo");
			String nombre = rs.getString("nombre");
			int precio = rs.getInt("precio");
			String modelo = rs.getString("modelo");

			lista_accesorios.add(new Accesorios(codigo, nombre, precio, modelo));
		}

		return lista_accesorios;
	}

	@Override
	public void insert(Accesorios accesorios) throws Throwable {
		conexion.SQL("Insert into accesorios(nombre,precio,modelo) VALUES(?,?,?)");
		conexion.preparedStatement().setString(1, accesorios.getNombre());
		conexion.preparedStatement().setInt(2, accesorios.getPrecio());
		conexion.preparedStatement().setString(3, accesorios.getModelo());
		conexion.CUD();
	}

	@Override
	public void search(Accesorios accesorios) throws Throwable {
		ResultSet rs;

		conexion.SQL("Select * from accesorios where codigo=?");
		conexion.preparedStatement().setInt(1, accesorios.getCodigo());
		rs = conexion.resultSet();

		while (rs.next()) {
			accesorios.setNombre(rs.getString("nombre"));
			accesorios.setPrecio(rs.getInt("precio"));
			accesorios.setModelo(rs.getString("modelo"));
		}

		rs.close();
	}

	@Override
	public void update(Accesorios accesorios) throws Throwable {
		if (accesorios != null) {
			int codigo = accesorios.getCodigo();
			String nombre = accesorios.getNombre();
			int precio = accesorios.getPrecio();
			String modelo = accesorios.getModelo();

			conexion.SQL("Update accesorios set nombre=?,precio=?,modelo=? where codigo=?");
			conexion.preparedStatement().setString(1, nombre);
			conexion.preparedStatement().setInt(2, precio);
			conexion.preparedStatement().setString(3, modelo);
			conexion.preparedStatement().setInt(4, codigo);
			conexion.CUD();
		}
	}

}
	


