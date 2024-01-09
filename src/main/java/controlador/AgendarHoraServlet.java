package controlador;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Agenda;

/**
 * Servlet implementation class AgendarHoraServlet
 */
public class AgendarHoraServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreMascota, rutDueño, horaStr, msg = "";
        Time hora = null; 

        int idMascota = 0;
        String fechaStr = request.getParameter("fecha");
        Date fecha = Date.valueOf(fechaStr);

        nombreMascota = request.getParameter("nombreMascota");
        
        horaStr = request.getParameter("hora");

        System.out.println("Hora recibida: " + horaStr);

        if (horaStr != null && !horaStr.isEmpty()) {
            LocalTime localTime = LocalTime.parse(horaStr);
            hora = Time.valueOf(localTime);
        }

        HttpSession session = request.getSession();
        rutDueño = (String) session.getAttribute("rutDueño");
        idMascota = (int) session.getAttribute("idMascota");

        try {
            System.out.println("Antes de agregar hora");
            int resultado = Agenda.agregarHora(idMascota, rutDueño, nombreMascota, hora, fecha);
            System.out.println("Después de agregar mascota, resultado: " + resultado);

            if (resultado == 1) {
                msg = "Agregar hora, " + nombreMascota;
            } else {
                msg = "Error al agregar la hora.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Error al agregar la hora: " + e.getMessage();
        }

        System.out.println("Resultado de validar: " + msg);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/inicio.jsp");
        request.setAttribute("mensaje", msg);
        dispatcher.forward(request, response);
    }
}
