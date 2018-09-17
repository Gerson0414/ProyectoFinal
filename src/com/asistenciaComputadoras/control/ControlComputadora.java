package com.asistenciaComputadoras.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.asistenciaComputadoras.entity.Computadora;

public class ControlComputadora 
{
	private Conexion conexion;
	

	public  ComputadoraControl (Conexion cconexion)
	{
		this.conexion = conexion;
	}
	@Override
	public ArrayList<Computadora> list() throws Throwable {
		ArrayList<Computadora>lista_computadoras = new ArrayList<Computadora>();
		ResultSet rs;
		conexion.SQL("Selec * from computadora");
		rs.conexion.resultSet();
		
		while (rs.next()) {
			int codigo = rs.getInt("codigo");
			String modelo = rs.getString("modelo");
			String marca = rs.getString("marca");
			
			lista_computadoras.add(new Computadora(codigo, modelo, marca));
		}
		return lista_computadoras;
	}
	@Override
	public void insert(Computadora computadora) throws Throwable {
		conexion.SQL("Insert into computadora(marca,modelo)VALUES(?,?,?)");
		conexion.preparedStatement().setString(1, computadora.getMarca());
		conexion.preparedStatement().setString(2, computadora.getModelo());
		conexion.CUD();
	}
	@Override
	public void search(Computadora computadora) throws Throwable 
	{
		ResultSet rs;
		conexion.SQL("Select * from computadora where codigo=?");
		conexion.preparedStatement().setInt(1, computadora.getCodigo());
        rs = conexion.resultSet();
        
        while(rs.next()) {
        	computadora.setMarca(rs.getString("marca"));
        	computadora.setModelo(rs.getString("modelo"));
        	
        }
        rs.close();
		
	}
	@Override
	public void update (Computadora computadora) throws Throwable
	{
		if (computadora !=null) {
			int codigo = computadora.getCodigo();
			String marca = computadora.getMarca();
			String modelo = computadora.getModelo();
			conexion.SQL("Update computadora set marca=?,modelo=? where codigo=?");
			conexion.preparedStatement().setString(1, marca);
			conexion.preparedStatement().setString(2, modelo);
			conexion.preparedStatement().setInt(3, codigo);
			conexion.CUD();
		}
	}

}
