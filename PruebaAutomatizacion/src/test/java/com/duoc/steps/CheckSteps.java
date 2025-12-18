package com.duoc.steps;

import org.openqa.selenium.By;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckSteps {
    @Given("el navegador se encuentra abierto en {string}")
    public void el_navegador_se_encuentra_abierto_en(String url) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Hooks.driver().get(url);
        Thread.sleep(2000);
    }
    @Given("el usuario realiza clic en {string} para dirigirse a la pagina de server status check")
    public void el_usuario_realiza_clic_en_para_dirigirse_a_la_pagina_de_server_status_check(String xpath) throws InterruptedException {
        Hooks.driver().findElement(By.xpath(xpath)).click();
        Thread.sleep(2000);
    }
    @When("el usuario hace clic en {string} para verificar el servidor")
    public void el_usuario_hace_clic_en_para_verificar_el_servidor(String xpath) throws InterruptedException {
        Hooks.driver().findElement(By.xpath(xpath)).click();
        Thread.sleep(2000);
    }
    @Then("Se deberia mostrar el mensaje {string} con el mensaje {string}")
    public void se_deberia_mostrar_el_mensaje_con_el_mensaje(String xpath, String message) throws InterruptedException {
        String text = Hooks.driver().findElement(By.xpath(xpath)).getText();
        if (text.equals(message)) {
            System.out.println("El campo del mensaje se encuentra");
        }else{
            System.out.println("El campo del mensaje no se encuentra");
        }
    }
}
