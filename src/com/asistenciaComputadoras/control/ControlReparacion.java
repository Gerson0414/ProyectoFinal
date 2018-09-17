package com.asistenciaComputadoras.control;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.asistenciaComputadoras.entity.Reparacion;

public class ControlReparacion implements Control<Reparacion>
{
	private Conexion conexion;
	
	public ControlReparacion(Conexion conexion) {
		this.conexion = conexion;
	}
@Override	
public ArrayList<Reparacion> list() throws Throwable {
	ArrayList<Reparacion> lista_reparacion = new ArrayList<>();
	ResultSet rs;
	conexion.SQL("Select * from reparacion");
	
	rs = conexion.resultSet();
	while (rs.next()){
		int codigo = rs.getInt("codigo");
		int codComputadora = rs.getInt("codComputadora");
		int codTecnico = rs.getInt("codTecnico");
		int codCliente = rs.getInt("codCliente");
		String problema = rs.getString("problema");
		String solucion = rs.getString("solucion");
		Date fechaIngreso = rs.getDate("fechaIngreso");
		Date fechaSalida = rs.getDate("fechaSalida");
		
		lista_reparacion.add(new Reparacion(codigo, codComputadora, codTecnico, codCliente, problema, solucion, fechaIngreso, fechaSalida));
	}
	return lista_reparacion;
	
   }
@Override
public void insert (Reparacion reparacion) throws Throwable {
	conexion.SQL("Insert into reparacion(problema,solucion,codComputadora,codTecnico,codCliente,fechaIngreso,fechaSalida) VALUES(?,?,?,?,?,?,?)");
	conexion.preparedStatement().setString(1, reparacion.getProblema());
	conexion.preparedStatement().setString(2, reparacion.getSolucion());
	conexion.preparedStatement().setInt(3, reparacion.getCodComputadora());
	conexion.preparedStatement().setInt(4, reparacion.getCodTecnico());
	conexion.preparedStatement().setInt(5, reparacion.getCodCliente());
	conexion.preparedStatement().setDate(6, reparacion.getFechaIngreso());
	conexion.preparedStatement().setDate(7, reparacion.getFechaSalida());
	conexion.CUD();
}
@Override
public void search(Reparacion reparacion) throws Throwable {
	ResultSet rs;
	
	conexion.SQL("Select * from reparacion where codigo=?");
	conexion.preparedStatement().setInt(1, reparacion.getCodigo());
	rs = conexion.resultSet();
	
	while (rs.next()) {
		reparacion.setProblema(rs.getString("problema"));
		reparacion.setSolucion(rs.getString("solucion"));
		reparacion.setCodComputadora(rs.getInt("codComputadora"));
		reparacion.setCodTecnico(rs.getInt("codTecnico"));
		reparacion.setCodCliente(rs.getInt("codCliente"));
		reparacion.setFechaIngreso(rs.getDate("fechaIngreso"));
		reparacion.setFechaSalida(rs.getDate("fechaSalida"));
		
	}
	rs.close();
}
@Override
public void update(Reparacion reparacion) throws Throwable {
	if (reparacion != null)
	{
		int codigo = reparacion.getCodigo();
		int codComputadora = reparacion.getCodComputadora();
		int codTecnico = reparacion.getCodTecnico();
		int codCliente = reparacion.getCodCliente();
		String problema = reparacion.getProblema();
		String solucion = reparacion.getSolucion();
		Date fechaIngreso = reparacion.getFechaIngreso();
		Date fechaSalida = reparacion.getFechaSalida();
		
		
		conexion.SQL("Update reparacion set problema=?, solucion=?,codComputadora=?,codTecnico=?,codCliente=?,fechaIngreso=?,fechaSalida=? where Codigo=?");
		conexion.preparedStatement().setString(1, problema);
		conexion.preparedStatement().setString(2, solucion);
		conexion.preparedStatement().setInt(3, codComputadora);
		conexion.preparedStatement().setInt(4, codTecnico);
		conexion.preparedStatement().setInt(5, codCliente);
		conexion.preparedStatement().setDate(6, fechaIngreso);
		conexion.preparedStatement().setDate(7, fechaSalida);
		conexion.preparedStatement().setInt(8, codigo);
		conexion.CUD();
				
	}
	
	
}
	
}
