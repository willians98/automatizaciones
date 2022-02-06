/*package framework.Tests;

import framework.WebElements.MainPage;
import framework.Config.WebActions;
import org.testng.annotations.Test;

public class ChessTest extends WebActions {

    @Test(description = "Demo test")
    public void loginTest_Chess() throws Exception {
        test = extent.createTest("Login Chess.com");

        MainPage mainPage = new MainPage();
        driver.get("https://www.google.es");
//        driver.get(datos.getProperty("url2"));


        //				datos.load(new FileInputStream("datos/datos.properties"));
        //				config.load(new FileInputStream("config/config.properties"));
        //              driver.get(datos.getProperty("url"));
        try {
            waitForVisibility(mainPage.Login_Chess);
            click(mainPage.Login_Chess);
            waitForVisibility(mainPage.User_Chess);
            sendKeys(mainPage.User_Chess, "sergio_lg91@hotmail.com");
            sendKeys(mainPage.Pass_Chess, "");
            //click(mainPage.Login2_Chess);

        } catch (Exception ex) {
            System.out.println(ex);
            throw ex;
        }
    }

}
*/