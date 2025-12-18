package com.duoc.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class SuscribeSteps {

    @Given("el navegador esta abierto en{string}")
    public void el_navegador_esta_abierto_en(String url) throws InterruptedException {
        Hooks.driver().get(url);
        Thread.sleep(2000);
    }

    @Given("el usuario realiza clic en {string} para dirigirse a la pagina de suscripcion")
    public void el_usuario_realiza_clic_en_para_dirigirse_a_la_pagina_de_suscripcion(String xpath) throws InterruptedException {
        Hooks.driver().findElement(By.xpath(xpath)).click();
        Thread.sleep(2000);
    }

    @When("el usuario ingresa en {string} el {string}")
    public void el_usuario_ingresa_en_el(String xpath, String mail) {
        Hooks.driver().findElement(By.xpath(xpath)).click();
        Hooks.driver().findElement(By.xpath(xpath)).clear();
        Hooks.driver().findElement(By.xpath(xpath)).sendKeys(mail);
    }

    @When("hace clic en el boton de suscribe {string}")
    public void hace_clic_en_el_boton_de_suscribe(String xpath) {
        Hooks.driver().findElement(By.xpath(xpath)).click();
    }

    @Then("Se deberia mostrar una alerta con el mensaje {string}")
    public void se_deberia_mostrar_una_alerta_con_el_mensaje(String expectedMessage) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(Hooks.driver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = Hooks.driver().switchTo().alert();
        String actualMessage = alert.getText();
        Thread.sleep(2000);
        System.out.println("Mensaje de la Alerta: " + actualMessage);
        if (actualMessage.equals(expectedMessage)) {
            System.out.println("El mensaje de la alerta coincide con lo esperado.");
        }
        alert.accept();

    }
}
