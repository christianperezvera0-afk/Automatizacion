Feature: Escoger lenguaje pagina web

  Background:
    Given el navegador se encuentra en pagina "https://demo.testfire.net/"
    And el usuario realiza un clic en "//a[@id='AccountLink']" para dirigirse a la pagina de login
    And el usuario ingresa en campo "//input[@id='uid']" el "jsmith" y en "//input[@id='passw']" la "Demo1234"
    And hace clic en boton de login "//input[@value='Login']"

  Scenario: Cambio de idioma
    When el usuario ingresa a "//a[@id='MenuHyperLink5']"
    And el usuario hace clic en "//a[@href='./customize.jsp?content=customize.jsp&lang=english']"
    Then se deberia mostrar en el campo "//p" el texto "  Current Language: english	    "