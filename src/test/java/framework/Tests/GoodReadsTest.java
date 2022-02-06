/*package framework.Tests;

import framework.WebElements.MainPage;
import framework.Config.WebActions;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class GoodReadsTest extends WebActions {

    @Test(description = "Demo test")
    public void loginTest_GoodReads() throws Exception {
        test = extent.createTest("Login GoodReads.es");

        MainPage mainPage = new MainPage();
        driver.get("https://www.goodreads.com/");

        try {
            waitForVisibilityClick(mainPage.Login_Goodreads);
            waitForVisibilityClick(mainPage.Cookies_Facebook);
            sendKeys(mainPage.User_Goodreads, "sergio_lg91@hotmail.com");

            click(mainPage.Login2_Goodreads);

            //Busqueda del libro
            waitForVisibilitySendKeys(mainPage.Search_box, "The reckoners 1");
            pressKey(mainPage.Search_box, Keys.ENTER);
            waitForVisibility(mainPage.Libro1);
            click(mainPage.Libro1);

            //Inicio reseña
            waitForVisibilityClick(mainPage.Desplegable_Libro1);
            click(mainPage.Categoria_Libro1);

            //waitForVisibilityClick(mainPage.Tres_Estrellas);

            //Inicio

            selectSamples(mainPage.Sel_Anyo_Inicio, "1970");

            selectSamples(mainPage.Sel_Mes_Inicio, "August");
            selectSamples(mainPage.Sel_Dia_Inicio, "23");
            //Final
            selectSamples(mainPage.Sel_Anyo_Final, "2020");
            selectSamples(mainPage.Sel_Mes_Final, "December");
            selectSamples(mainPage.Sel_Dia_Final, "1");

            click(mainPage.Submit);

        } catch (Exception ex) {
            System.out.println(ex);
            throw ex;
        }
    }
}*/