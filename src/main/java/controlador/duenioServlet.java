package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Dueno;

public class duenioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public duenioServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rut, nombre, apellido, direccion, correo, nombreMascota, msg = "";
        int telefono = 0;

        rut = request.getParameter("rut");
        nombre = request.getParameter("nombre");
        apellido = request.getParameter("apellido");
        direccion = request.getParameter("direccion");
        correo = request.getParameter("correo");

        try {
            telefono = Integer.parseInt(request.getParameter("telefono"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            msg = "Error en el formato del teléfono.";
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            request.setAttribute("mensaje", msg);
            dispatcher.forward(request, response);
            return; 
        }

        nombreMascota = request.getParameter("nombreMascota");

        try {
            System.out.println("Antes de agregar dueño");
            int resultado = Dueno.agregarDueno(rut, nombre, apellido, direccion, correo, telefono, nombreMascota);
            System.out.println("Después de agregar dueño, resultado: " + resultado);
            

            if (resultado == 1) {
                msg = "Agregar dueñ@, " + rut;
                HttpSession session = request.getSession();
                session.setAttribute("rutDueño", rut);
                
            } else {
                msg = "Error al agregar el dueño.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Error al agregar el dueñ@: " + e.getMessage();
        }

        System.out.println("Resultado de validar: " + msg);
        

        RequestDispatcher dispatcher = request.getRequestDispatcher("/mascotaForm.jsp");
        request.setAttribute("mensaje", msg);
        dispatcher.forward(request, response);
    }
}
