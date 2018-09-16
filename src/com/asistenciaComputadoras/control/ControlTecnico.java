package com.asistenciaComputadoras.control;


import java.sql.ResultSet;
import java.util.ArrayList;



import com.asistenciaComputadoras.entity.Tecnico;





public class ControlTecnico implements Control<Tecnico>
{
	private Conexion conexion; 
	public ControlTecnico(Conexion conexion)
	{
		this.conexion = conexion;
	}
    public ArrayList<Tecnico> list() throws Throwable{
		ArrayList<Tecnico> lista_tecnicos = new ArrayList<>();
		ResultSet rs;
		conexion.SQL("Select * from tecnico");
		rs = conexion.resultSet();
		
		while(rs.next()){
			int codigo = rs.getInt("Codigo Tecnico");
			String nombreTe = rs.getString(" Nombre ");
			String apellidoTe = rs.getString("Apellido");
			String usuarioTe = rs.getString(" Usuario");
			String contrase�aTe = rs.getString(" Contrase�a");
			lista_tecnicos.add(new Tecnico(codigo, nombreTe, apellidoTe, usuarioTe, contrase�aTe ));
			
		}
		return lista_tecnicos;
	}
    
    public void search (Tecnico tecnico) throws Throwable {
    	ResultSet rs;
    	conexion.SQL("Select * from tecnico where CodigoTecnico");
    	conexion.preparedStatement().setInt(1, tecnico.getCodigo());
    	rs = conexion.resultSet();
    	while (rs.next())
    	{
    		tecnico.setNombreTe(rs.getString("Nombre"));
    		tecnico.setApellidoTe(rs.getString("Apellido"));
    		tecnico.setUsuarioTe(rs.getString("Usuario"));
    		tecnico.setContrase�aTe(rs.getString("Contrase�a"));
    		
    	}
    	rs.close();
    }
    
    public void update(Tecnico tecnico) throws Throwable {
    	if (tecnico != null)
    	{
    		int codigo = tecnico.getCodigo();
    		String apellidoTe = tecnico.getApellidoTe();
    		String nombreTe = tecnico.getNombreTe();
    		String usuarioTe = tecnico.getUsuarioTe();
    		String contrase�aTe = tecnico.getContrase�aTe();
    		
    		
    		conexion.SQL(" Update tecnico set Nombre,Apellido,Usuario,Contrase�a where Codigo_Tecnico");
    		conexion.preparedStatement().setString(1, nombreTe);
    		conexion.preparedStatement().setString(2, apellidoTe);
    		conexion.preparedStatement().setString(3, usuarioTe);
    		conexion.preparedStatement().setString(4, contrase�aTe);
    		conexion.preparedStatement().setInt(5, codigo);
    		conexion.CUD();
    	}
    }
    
    
}
