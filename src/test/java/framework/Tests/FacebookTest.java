/*package framework.Tests;

import framework.WebElements.MainPage;
import framework.Config.WebActions;
import org.testng.annotations.Test;

public class FacebookTest extends WebActions{

    @Test(description = "Demo test")
    public void loginTest_Facebook() throws Exception {
        test = extent.createTest("Login Facebook.es");

        MainPage mainPage = new MainPage();
        driver.get("https://es-es.facebook.com/");

        try {
            waitForVisibilityClick(mainPage.Cookies_Facebook);
            click(mainPage.Register_Facebook);
            waitForVisibility(mainPage.Day_Facebook);
            //selectSamples(mainPage.Day_Facebook, "23");
            selectSamples(mainPage.Day_Facebook2,"15");
            selectByIndex(mainPage.Day_Facebook,28);
            selectByIndex(mainPage.Day_Facebook2, 13);
            selectSamples(mainPage.Month_Facebook,"ago");
            selectByIndex(mainPage.Month_Facebook,3);
            selectSamples(mainPage.Year_Facebook,"1905");
            click(mainPage.Hombre);
        } catch (Exception ex) {
            System.out.println(ex);
            throw ex;
        }
    }
}*/