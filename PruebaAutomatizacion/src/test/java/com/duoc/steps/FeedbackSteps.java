package com.duoc.steps;

import org.openqa.selenium.By;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FeedbackSteps {
    @Given("el navegador esta abierto en pagina{string}")
    public void el_navegador_esta_abierto_en(String url) throws InterruptedException {
        Hooks.driver().get(url);
        Thread.sleep(2000);
    }

    @Given("el usuario realiza clic en {string} para dirigirse a la pagina de feedback")
    public void el_usuario_realiza_clic_en_para_dirigirse_a_la_pagina_de_suscripcion(String xpath) throws InterruptedException {
        Hooks.driver().findElement(By.xpath(xpath)).click();
        Thread.sleep(2000);
    }
    @Given("el usuario ingresa en {string} el {string} y en {string} la {string} tambien en {string} la {string} y en {string} la {string}")
        public void el_usuario_ingresa_en_el_y_en_la_tambien_en_la_y_en_la(String xpath_nombre, String nombre, String xpath_email, String email, String xpath_subject, String subject, String xpath_comments, String comments){
            Hooks.driver().findElement(By.xpath(xpath_nombre)).click();
            Hooks.driver().findElement(By.xpath(xpath_nombre)).clear();
            Hooks.driver().findElement(By.xpath(xpath_nombre)).sendKeys(nombre);
            Hooks.driver().findElement(By.xpath(xpath_email)).click();
            Hooks.driver().findElement(By.xpath(xpath_email)).clear();
            Hooks.driver().findElement(By.xpath(xpath_email)).sendKeys(email);
            Hooks.driver().findElement(By.xpath(xpath_subject)).click();
            Hooks.driver().findElement(By.xpath(xpath_subject)).clear();
            Hooks.driver().findElement(By.xpath(xpath_subject)).sendKeys(subject);
            Hooks.driver().findElement(By.xpath(xpath_comments)).click();
            Hooks.driver().findElement(By.xpath(xpath_comments)).clear();
            Hooks.driver().findElement(By.xpath(xpath_comments)).sendKeys(comments);
        }
    @When("hace clic en el boton de submit {string}")
    public void hace_clic_en_el_boton_de_submit(String xpath) throws InterruptedException {
        Hooks.driver().findElement(By.xpath(xpath)).click();
        Thread.sleep(2000);
    }
    @Then("Se deberia mostrar en el campo {string} con el mensaje {string}")
    public void se_deberia_mostrar_en_el_campo_con_el_mensaje(String xpath, String message) throws InterruptedException {
        String text = Hooks.driver().findElement(By.xpath(xpath)).getText();
        if (text.equals(message)) {
            System.out.println("El campo del mensaje se encuentra");
        }else{
            System.out.println("El campo del mensaje no se encuentra");
        }
    }
}

