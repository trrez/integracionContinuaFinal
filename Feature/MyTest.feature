Feature: Reallizacion de casos ingresando nombre de usuario y contraseña

  Scenario: Verificacion de ingreso de sesion
    Given Abrir Chrome
    When ingresar nombreUsuario "administrador" y password "12345"
    Then inicia sesion

  Scenario: Verificacion de ingreso de sesion con contraseña y username mal escrita
    Given Abrir Chrome
    When ingresar nombreUsuario "userr" y password "12345"
    Then inicia sesion

  Scenario: Registro de hora medica veterinaria.
    Given Abrir Chrome
    When ingresar nombreUsuario "administrador" y password "12345"
    And inicia sesion
    And ingresar a formulario
    And ingresa rut "20337075-k", nombre "Tatiana", apellido "Gutierrez", direccion "Lizardo Montereo 651", correo "tatiana@gutierrez.com", telefono 12345678, nombreMascota "Medusa"
    And ingresa tipoMascota "Gata", edad 2, nombreMascota "Medusa", rutDueño "20337075-k"
		And ingresa nombreMascota "Medusa", rutDueño "20337075-k", hora "03:02", fecha '2024-01-11'
    Then se registra la hora médica exitosamente
