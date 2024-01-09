<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
            <h2>Agendar Mascota</h2>
            <form action="AgendarHoraServlet" method="POST" class="form">
                Nombre Mascota: <input type="text" name="nombreMascota" id="nombreMascota" required="required">
	            <%String rutDueno = (String) session.getAttribute("rutDueño");%>
	            RUT del Dueño: <input type="text" name="rutDueño" id="rutDueño" value="<%= rutDueno %>" readonly="readonly">
               Hora: <input type="text" name="hora" id="hora" required>

	            Fecha: <input type="date" name="fecha" id="fecha" required>

            
                <div class="button-container">
                    <input type="submit" value="Siguiente" id="siguienterbtn" class="siguienterbtn">
                </div>
            </form>
        </div>
    </div>

</body>
</html>