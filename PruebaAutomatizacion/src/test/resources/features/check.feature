Feature: Comprobacion check status

  Background:
    Given el navegador se encuentra abierto en "https://demo.testfire.net/"
    And el usuario realiza clic en "//a[@href='/status_check.jsp']" para dirigirse a la pagina de server status check

  Scenario: status exitoso
    When el usuario hace clic en "//input[@value='Check Status']" para verificar el servidor
    Then Se deberia mostrar el mensaje "//div[@id='FetchHostStatus']" con el mensaje "OK"