<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Iniciar Sesi�n</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>

<nav>
    <h1>PetSmile</h1>
</nav>

<div class="div-container">
    <div class="div-form">
        <h2>Bienvenid@, Inicia sesi�n</h2>
        <form action="ValidadorServlett" method="POST" class="form">
            Usuario: <input type="text" name="nombreUsuario" id="nombreUsuario" required="required">
            Contrase�a: <input type="password" name="password" id="password" required="required">
                    
            <div class="button-container">
                <input type="submit" value="Iniciar Sesi�n" id="loginbtn" class="loginbtn">
            </div>
        </form>
        <div class="error-message">
		    <% String mensaje = (String)request.getAttribute("error"); %>
		    <% if (mensaje != null && !mensaje.isEmpty()) { %>
		        <p><%= mensaje %></p>
		    <% } %>
		</div>

	<button onclick="window.location.href='registro.jsp'" class="registerbtn">Registrarse</button>
    </div>
</div>

</body>
</html>
