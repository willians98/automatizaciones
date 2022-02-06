package framework.Tests;

import framework.WebElements.MainPage;
import framework.Config.WebActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class AmazonTest extends WebActions{
//modificado para usarlo con youtube
    @Test(description = "Demo test")
    public void loginTest_Amazon() throws Exception {
        test = extent.createTest("Login Amazon.es");

        MainPage mainPage = new MainPage();
        driver.get("https://www.youtube.com");
        scrollDownTo(mainPage.Cookies_Youtube);
        click(mainPage.Cookies_Youtube);

        try {
            waitForVisibility(mainPage.Login_Youtube);
            click(mainPage.Login_Youtube);
            //inicio de sesion
            waitForVisibilitySendKeys(mainPage.Mail_youtube,datos.getProperty("user"));
            click(mainPage.Siguiente_youtube);
            waitForVisibilitySendKeys(mainPage.Password_youtube,datos.getProperty("password"));
            waitForVisibility(mainPage.Siguiente2_youtube);
            click(mainPage.Siguiente2_youtube);
            waitForVisibilityClick(mainPage.Buscador_Youtube);
            sendKeys(mainPage.Buscador_Youtube,datos.getProperty("videotitle"));
            pressKey(mainPage.Buscador_Youtube, Keys.ENTER);
            waitForVisibility(mainPage.Video_Youtube);
            click(mainPage.Video_Youtube);
            //poner video en pantalla completa
            waitForVisibility(mainPage.Pantalla_Completa_Youtube);
            click(mainPage.Pantalla_Completa_Youtube);


        } catch (Exception ex) {
            System.out.println(ex);
            throw ex;
        }
    }
}
