package framework.Tests;

import framework.WebElements.MainPage;
import framework.Config.WebActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import javax.swing.*;

import static javax.swing.JOptionPane.showMessageDialog;

//busqueda en wikipedia del enlace mas correcto preguntandole al usuario al inici

public class AmazonTest extends WebActions{
//modificado para usarlo con wikipedia
    @Test(description = "Demo test")
    public void loginTest_Amazon() throws Exception {
        test = extent.createTest("Login Amazon.es");

        String respuesta = JOptionPane.showInputDialog("Escribe lo que quieres buscar");
        MainPage mainPage = new MainPage();
        driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");


        try {
            waitForVisibilitySendKeys(mainPage.Texto_Busqueda,respuesta);
            waitForVisibilityClick(mainPage.Lupa_Wikipedia);



            //pregunta si quiere buscar en bucle si es que
            //si le pregunta el que si es que no se para

            String answer = JOptionPane.showInputDialog ("Si quiere buscar otra cosa escriba si,(si no escriba no)");
            while(answer.equals("si") ) {
                //por si quiere buscar otra cosa
                String respuesta2 = JOptionPane.showInputDialog("Escribe lo nuevo que quieres buscar");
                waitForVisibilitySendKeys(mainPage.Texto_Busqueda,respuesta2);
                waitForVisibilityClick(mainPage.Lupa_Wikipedia);
                answer = JOptionPane.showInputDialog ("Si quiere buscar otra cosa escriba si,(si no escriba no)");
            }





        } catch (Exception ex) {
            System.out.println(ex);
            throw ex;
        }
    }

}

