Feature: Navegacion hacia feedback

  Background:
    Given el navegador esta abierto en pagina"https://demo.testfire.net/"
    And el usuario realiza clic en "//a[@id='HyperLink4']" para dirigirse a la pagina de feedback

  Scenario: feedback fallido
    When el usuario ingresa en "//input[@name='name']" el "Christian Perez" y en "//input[@name='email_addr']" la "Demo1234" tambien en "//input[@name='subject']" la "confirmacion" y en "//textarea[@name='comments']" la "revisar envio confirmacion"
    And hace clic en el boton de submit "//input[@name='submit']"
    Then Se deberia mostrar en el campo "//h1" con el mensaje "Thank you"

  Scenario Outline: feedback exitoso
    When el usuario ingresa en "//input[@name='name']" el "<nombre>" y en "//input[@name='email_addr']" la "<email>" tambien en "//input[@name='subject']" la "<subject>" y en "//textarea[@name='comments']" la "<question>"
    And hace clic en el boton de submit "//input[@name='submit']"
    Then Se deberia mostrar en el campo "//h1" con el mensaje "Thank you"


    Examples:

      | nombre          | email           | subject          | question                         |
      | Kevin Henriquez | prueba@mail.com | transferencia    | como puedo realizar transferencia|
      | Diego lopez     | email@prueba.cl | factura          | como puedo visualizar factura    |