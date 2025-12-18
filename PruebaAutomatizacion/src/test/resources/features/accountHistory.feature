Feature: Ingresar a Account History

  Background:
    Given el navegador esta abierto en la pagina "https://demo.testfire.net/"
    And el usuario realiza clic en "//a[@id='AccountLink']" para dirigirse a la pagina de login

  Scenario: Ingreso a account history
    When el usuario ingresa en "//input[@id='uid']" el "jsmith" y en "//input[@id='passw']" la "Demo1234"
    And hace clic en el boton de login "//input[@value='Login']"
    And el usuario hace clic en "//input[@value='   GO   ']"
    Then deberia mostrar el campo "//h1" con el mensaje "Account History - 800002 Savings"