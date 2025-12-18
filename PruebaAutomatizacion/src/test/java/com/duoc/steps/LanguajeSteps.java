package com.duoc.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class LanguajeSteps {
    @Given("el navegador se encuentra en pagina {string}")
    public void el_navegador_se_encuentra_en_pagina(String url) throws InterruptedException {
        Hooks.driver().get(url);
        Thread.sleep(2000);
    }

    @Given("el usuario realiza un clic en {string} para dirigirse a la pagina de login")
    public void el_usuario_realiza_un_clic_en_para_dirigirse_a_la_pagina_de_login(String xpath) throws InterruptedException {
        Hooks.driver().findElement(By.xpath(xpath)).click();
        Thread.sleep(2000);
    }
    @Given("el usuario ingresa en campo {string} el {string} y en {string} la {string}")
    public void el_usuario_ingresa_en_campo_el_y_en_la(String xpath_username, String username, String xpath_password, String password) {
        Hooks.driver().findElement(By.xpath(xpath_username)).click();
        Hooks.driver().findElement(By.xpath(xpath_username)).clear();
        Hooks.driver().findElement(By.xpath(xpath_username)).sendKeys(username);
        Hooks.driver().findElement(By.xpath(xpath_password)).click();
        Hooks.driver().findElement(By.xpath(xpath_password)).clear();
        Hooks.driver().findElement(By.xpath(xpath_password)).sendKeys(password);
    }
    @Given("hace clic en boton de login {string}")
    public void hace_clic_en_boton_de_login(String xpath) throws InterruptedException {
        Hooks.driver().findElement(By.xpath(xpath)).click();
        Thread.sleep(2000);
    }
    @When("el usuario ingresa a {string}")
    public void el_usuario_ingresa_a(String xpath) throws InterruptedException {
        Hooks.driver().findElement(By.xpath(xpath)).click();
        Thread.sleep(2000);
    }
    @Then("se deberia mostrar en el campo {string} el texto {string}")
    public void se_deberia_mostrar_en_el_campo_el_texto(String xpath, String message) throws InterruptedException {
        String text = Hooks.driver().findElement(By.xpath(xpath)).getText();
        if (text.equals(message)) {
            System.out.println("El campo del mensaje se encuentra");
        }else {
            System.out.println("El campo del mensaje no se encuentra");
        }
    }
}