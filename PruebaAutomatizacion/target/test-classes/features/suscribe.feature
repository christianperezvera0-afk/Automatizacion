Feature: Suscripcion de correo en aplicacion

  Background:
    Given el navegador esta abierto en"https://demo.testfire.net/"
    And el usuario realiza clic en "//a[@id='MenuHyperLink19']" para dirigirse a la pagina de suscripcion

  Scenario Outline: Suscripcion fallida
    When el usuario ingresa en "//input[@id='txtEmail']" el "<correo>"
    And hace clic en el boton de suscribe "//input[@name='btnSubmit']"
    Then Se deberia mostrar una alerta con el mensaje "<mensaje>"

    Examples:

      | correo      | mensaje  |
      | mailjsmith  |Your email address does not appear to be valid. Please try again.|
      | pruebamail  |Your email address does not appear to be valid. Please try again.|