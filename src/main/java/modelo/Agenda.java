package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

import utils.Conexion;

public class Agenda {

	public static int agregarHora(Integer idMascota, String rutDueño, String nombreMascota, Time hora, Date fecha) {
	    Connection con = null;  
	    Conexion cn = new Conexion();

	    PreparedStatement ps = null;
	    int filasAfectadas = 0;
	    String sql = "INSERT INTO petsmile.agenda (idMascota, rutDueño, nombreMascota, hora, fecha) VALUES (?, ?, ?, ?, ?);";
	    
	    try {
	        con = cn.getConnection();

	        if (con != null) {  
	            ps = con.prepareStatement(sql);
	            ps.setInt(1, idMascota);
	            ps.setString(2, rutDueño);
	            ps.setString(3, nombreMascota);
	            ps.setTime(4, hora);
	            ps.setDate(5, fecha);

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
