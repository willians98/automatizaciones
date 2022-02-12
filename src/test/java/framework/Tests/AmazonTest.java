package framework.Tests;

import framework.WebElements.MainPage;
import framework.Config.WebActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import java.util.Scanner;

//busqueda en wikipedia del enlace mas correcto preguntandole al usuario al inici

public class AmazonTest extends WebActions{
//modificado para usarlo con wikipedia
    @Test(description = "Demo test")
    public void loginTest_Amazon() throws Exception {
        test = extent.createTest("Login Amazon.es");

        MainPage mainPage = new MainPage();
        //pedimos datos por teclado
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese dato a buscar en la wikipedia");
        String dato = scanner.nextLine();
        //abrimos wikipedia
        driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");


        try {



        } catch (Exception ex) {
            System.out.println(ex);
            throw ex;
        }
    }
}
