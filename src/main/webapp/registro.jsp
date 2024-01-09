<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registro</title>
    <link rel="stylesheet" type="text/css" href="css/styles-registro.css">
</head>
<body>

<nav>
    <h1>PetSmile</h1>
</nav>

<div class="div-container">
    <div class="div-form">
        <h2>Registro</h2>
        <form action="RegistroServlet" method="POST" class="form">
            Usuario: <input type="text" name="nombreUsuario" id="nombreUsuario" required="required">
            Contraseña: <input type="password" name="Password" id="password" required="required">
                    
            <div class="button-container">
                <input type="submit" value="Registrar" id="registrarbtn" class="registrarbtn">
            </div>
        </form>
    </div>
</div>

</body>
</html>
