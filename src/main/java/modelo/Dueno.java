package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utils.Conexion;

public class Dueno {
	
	public static int agregarDueno(String rut, String nombre, String apellido, String direccion, String correo, Integer telefono, String nombreMascota) {
	    Connection con = null;  
	    Conexion cn = new Conexion();

	    PreparedStatement ps = null;
	    int filasAfectadas = 0;
	    String sql = "INSERT INTO petsmile.dueño (rut, nombre, apellido, direccion, correo, telefono, nombreMascota) VALUES (?, ?, ?, ?, ?, ?, ?);";
	    
	    try {
	        con = cn.getConnection();

	        if (con != null) {  
	            ps = con.prepareStatement(sql);
	            ps.setString(1, rut);
	            ps.setString(2, nombre);
	            ps.setString(3, apellido);
	            ps.setString(4, direccion);
	            ps.setString(5, correo);
	            ps.setInt(6, telefono);
	            ps.setString(7, nombreMascota);
	            
	            filasAfectadas = ps.executeUpdate();

	            System.out.println("Filas afectadas: " + filasAfectadas);
	            System.out.println("Inserción exitosa");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error SQL: " + e.getMessage());
        } finally {
            closeResources(ps, con);
        }

        return filasAfectadas;
    }

    private static void closeResources(PreparedStatement ps, Connection con) {
        try {
            if (ps != null)
                ps.close();
            if (con != null)
                con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}