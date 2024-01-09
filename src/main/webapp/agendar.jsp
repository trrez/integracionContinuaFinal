<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Agendar Hora</title>
    <link rel="stylesheet" type="text/css" href="css/styles-agendaDueño.css">
</head>
<body>
    <nav>
        <h1>PetSmile</h1>
        <h2>Bienvenid@, <%= session.getAttribute("nombreUsuario") %></h2>
    </nav>
    
    <div class="div-container">
        <div class="div-form">
            <h2>Agendar Hora</h2>
            <form action="duenioServlet" method="POST" class="form">
                Rut dueño: <input type="text" name="rut" id="rut" required="required">
                Nombre dueño: <input type="text" name="nombre" id="nombre" required="required">
                Apellido dueño: <input type="text" name="apellido" id="apellido" required="required">
                Dirección: <input type="text" name="direccion" id="direccion" required="required">
                Correo Electrónico: <input type="email" name="correo" id="correo" required="required">
                Teléfono: <input type="number" name="telefono" id="telefono" required="required">
                Nombre Mascota: <input type="text" name="nombreMascota" id="nombreMascota" required="required">
            
                <div class="button-container">
                    <input type="submit" value="Siguiente" id="siguienterbtn" class="siguienterbtn">
                </div>
            </form>
        </div>
    </div>
</body>
</html>
