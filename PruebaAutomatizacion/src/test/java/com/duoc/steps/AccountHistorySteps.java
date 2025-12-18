package com.duoc.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class AccountHistorySteps {

    @Given("el navegador esta abierto en la pagina {string}")
    public void el_navegador_esta_abierto_en_la_pagina(String url) throws InterruptedException {
        Hooks.driver().get(url);
        Thread.sleep(3000);
    }

    @Given("el usuario realiza clic en {string} para dirigirse a la pagina de login")
    public void el_usuario_realiza_clic_en_para_dirigirse_a_la_pagina_de_login(String xpath) throws InterruptedException {
        Hooks.driver().findElement(By.xpath(xpath)).click();
        Thread.sleep(1000);
    }
    @When("el usuario ingresa en {string} el {string} y en {string} la {string}")
    public void el_usuario_ingresa_en_el_y_en_la(String xpath_username, String username, String xpath_password, String password) {
        Hooks.driver().findElement(By.xpath(xpath_username)).click();
        Hooks.driver().findElement(By.xpath(xpath_username)).clear();
        Hooks.driver().findElement(By.xpath(xpath_username)).sendKeys(username);
        Hooks.driver().findElement(By.xpath(xpath_password)).click();
        Hooks.driver().findElement(By.xpath(xpath_password)).clear();
        Hooks.driver().findElement(By.xpath(xpath_password)).sendKeys(password);
    }

    @When("hace clic en el boton de login {string}")
    public void hace_clic_en_el_boton_de_login(String xpath) throws InterruptedException {
        Hooks.driver().findElement(By.xpath(xpath)).click();
        Thread.sleep(2000);
    }

    @When("el usuario hace clic en {string}")
    public void el_usuario_hace_clic_en(String xpath) throws InterruptedException {
        Hooks.driver().findElement(By.xpath(xpath)).click();
        Thread.sleep(2000);
    }
    @Then("deberia mostrar el campo {string} con el mensaje {string}")
    public void deberia_mostar_el_campo_con_el_mensaje(String xpath, String message) throws InterruptedException {
        String text = Hooks.driver().findElement(By.xpath(xpath)).getText();
        if (text.equals(message)) {
            System.out.println("El campo del mensaje se encuentra");
        }else {
            System.out.println("El campo del mensaje no se encuentra");
        }
    }
}
