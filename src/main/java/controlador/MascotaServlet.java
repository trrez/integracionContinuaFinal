package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Mascota;

/**
 * Servlet implementation class RegistroServlet
 */
public class MascotaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MascotaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipoMascota, nombreMascota, rutDueño, msg = "";
        int edad = 0;
        int idMascota = 0;

        tipoMascota = request.getParameter("tipoMascota");

        try {
            edad = Integer.parseInt(request.getParameter("edad"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            msg = "Error en el formato de la edad.";
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            request.setAttribute("mensaje", msg);
            dispatcher.forward(request, response);
            return;
        }

        nombreMascota = request.getParameter("nombreMascota");

        HttpSession session = request.getSession();
        rutDueño = (String) session.getAttribute("rutDueño");

        try {
            System.out.println("Antes de agregar mascota");
            int resultado = Mascota.agregarMascota(tipoMascota, edad, nombreMascota, rutDueño);
            System.out.println("Después de agregar mascota, resultado: " + resultado);

            if (resultado == 1) {
                idMascota = Mascota.obtenerUltimoIdMascota();
                msg = "Agregar mascota, " + nombreMascota;
            } else {
                msg = "Error al agregar la mascota.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Error al agregar la mascota: " + e.getMessage();
        }

        
        session.setAttribute("idMascota", idMascota);

        System.out.println("Resultado de validar: " + msg);
        System.out.println("idMascota" + idMascota);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/agendarHora.jsp");
        request.setAttribute("mensaje", msg);
        dispatcher.forward(request, response);
    }
}