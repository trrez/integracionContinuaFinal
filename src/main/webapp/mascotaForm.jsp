<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulario de Mascotas</title>
	<link rel="stylesheet" type="text/css" href="css/styles-agendaDueño.css">
</head>
<body>
<nav>
        <h1>PetSmile</h1>
        <h2>Bienvenid@, <%= session.getAttribute("nombreUsuario") %></h2>
    </nav>
    
    <div class="div-container">
        <div class="div-form">
            <h2>Agendar Mascota</h2>
            <form action="MascotaServlet" method="POST" class="form">
                Tipo Mascota: <input type="text" name="tipoMascota" id="tipoMascota" required="required">
                Edad: <input type="number" name="edad" id="edad" required="required">
                Nombre Mascota: <input type="text" name="nombreMascota" id="nombreMascota" required="required">
	            <% String rutDueno = request.getParameter("rut"); %>
	            RUT del Dueño: <input type="text" name="rutDueño" id="rutDueño" value="<%= rutDueno %>" readonly="readonly">

            
                <div class="button-container">
                    <input type="submit" value="Siguiente" id="siguienterbtn" class="siguienterbtn">
                </div>
            </form>
        </div>
    </div>
</body>
</html>
