package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.Conexion;

public class Mascota {

	public static int agregarMascota(String tipoMascota, Integer edad, String nombreMascota, String rutDueño) {
	    Connection con = null;  
	    Conexion cn = new Conexion();

	    PreparedStatement ps = null;
	    int filasAfectadas = 0;
	    String sql = "INSERT INTO petsmile.mascota (tipoMascota, edad, nombreMascota, rutDueño) VALUES (?, ?, ?, ?);";
	    
	    try {
	        con = cn.getConnection();

	        if (con != null) {  
	            ps = con.prepareStatement(sql);
	            ps.setString(1, tipoMascota);
	            ps.setInt(2, edad);
	            ps.setString(3, nombreMascota);
	            ps.setString(4, rutDueño);
	            
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
    
    public static int obtenerUltimoIdMascota() throws SQLException {
        int ultimoIdMascota = 0;

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
    	    Conexion cn = new Conexion();
        	con = cn.getConnection();

            String sql = "SELECT MAX(idMascota) AS ultimoId FROM petsmile.mascota";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            if (rs.next()) {
                ultimoIdMascota = rs.getInt("ultimoId");
            }
        } finally {
            closeResources(stmt, rs, con);
        }

        return ultimoIdMascota;
    }

    private static void closeResources(PreparedStatement ps, ResultSet rs, Connection con) {
        try {
            if (ps != null)
                ps.close();
            if (rs != null)
                rs.close();
            if (con != null)
                con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}