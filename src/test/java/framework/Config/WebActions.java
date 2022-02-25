package framework.Config;


import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;


public class WebActions extends  GridConfig{

    public void waitForVisibility(WebElement elm) {
        String msg;
        try {
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.visibilityOf(elm));
            msg = ("[OK]: Espera OK. Elemento " + JavaHTML.elementToStringHTML(elm.toString()) +" visible");
            logExtentReport(msg, Status.PASS, false);
        } catch (Exception ex) {
            msg = ("[ERROR]: El elemento " + JavaHTML.elementToStringHTML(elm.toString()) +" no aparece");
            assertTrue(elm.isDisplayed());
            logExtentReport(msg, Status.FAIL, false);
        }
        Log.register(msg);
    }

    public void waitForVisibilityClick(WebElement elm)   {
        String msg;
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.click();
            msg = ("[OK] : Espera OK. Elemento " + JavaHTML.elementToStringHTML(elm.toString())
                    + " visible y pulsado");
            logExtentReport(msg, Status.PASS, false);
        } catch (Exception ex) {
            msg = ("[ERROR] : Error al realizar la espera.");
            logExtentReport(msg, Status.FAIL, false);
        }
        Log.register(msg);
    }

    public void waitForVisibilitySendKeys(WebElement elm, String texto)   {
        String msg;
        try {
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.sendKeys(texto);
            msg = "[OK] : \"" + texto + "\" enviado correcto en: "
                    + JavaHTML.elementToStringHTML(elm.toString());
            logExtentReport(msg, Status.PASS, false);
        } catch (Exception ex) {
            msg = "[ERROR] : No se ha podido enviar \"" + texto
                    + "\" al elemento " + JavaHTML.elementToStringHTML(elm.toString());
            logExtentReport(msg, Status.FAIL, false);
        }
        Log.register(msg);;
    }

    public void sendKeys(WebElement elm, String texto) {
        String msg;
        try {
            elm.sendKeys(texto);
            msg = "[OK] : \"" + texto + "\" enviado correcto en: "
                    + JavaHTML.elementToStringHTML(elm.toString());
            logExtentReport(msg, Status.PASS, false);
        } catch (Exception ex) {
            msg = "[ERROR] : No se ha podido enviar \"" + texto
                    + "\" al elemento " + JavaHTML.elementToStringHTML(elm.toString());
            logExtentReport(msg, Status.FAIL, false);
        }
        Log.register(msg);;
    }

    public void click(WebElement elm) {
        String msg;
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(elm).click().perform();
            msg = "[OK]: Click correcto en: " + JavaHTML.elementToStringHTML(elm.toString());
            logExtentReport(msg, Status.PASS, false);
        } catch (Exception ex) {
            msg = "[ERROR]: Fallo al dar click: " + ex.getMessage();
            logExtentReport(msg, Status.FAIL, false);
        }
        Log.register(msg);
    }

    // Presiona una tecla del teclado en un elemento
    public void pressKey(WebElement elm, Keys key)   {
        String msg;
        try {
            elm.sendKeys(Keys.RETURN);
            msg = "[OK] : tecla " + JavaHTML.elementToStringHTML(key.toString()) + "presionada correcto en: " + JavaHTML.elementToStringHTML(elm.toString());
            logExtentReport(msg, Status.PASS, false);
        } catch (Exception ex) {
            msg = "[ERROR] : error al pulsar la tecla " + JavaHTML.elementToStringHTML(key.toString());
            logExtentReport(msg, Status.FAIL, false);
        }
        Log.register(msg);
    }


    // Método para seleccionar de un desplegable pasandole el id y el index
    /*public void selectByIndex(String id, int index)   {
        String msg;
        try {
            WebElement testDropDown = driver.findElement(By.id(id));
            Select dropdown = new Select(testDropDown);
            dropdown.selectByIndex(index);
            msg = "[OK] : Select: " + index + " in " + testDropDown.toString();
            logExtentReport(msg, Status.PASS, false);
        } catch (Exception ex) {
            msg = "[ERROR] : Fail Select: " + index + " in " + ex.getMessage();
            logExtentReport(msg, Status.FAIL, false);
        }
        Log.register(msg);
    }*/

    public void selectByIndex (WebElement elm, int index) {
        String msg;
        try {
            Select sel = new Select(elm);
            sel.selectByIndex(index);
            msg = "[OK] : Select: " + index + " in " + JavaHTML.elementToStringHTML(elm.toString());
            logExtentReport(msg, Status.PASS, false);
        } catch (Exception ex) {            msg = "[ERROR] : Fail Select: " + index + " in " + ex.getMessage();
            logExtentReport(msg, Status.FAIL, false);
        }
        Log.register(msg);
    }

    // Método para seleccionar una opcion de un desplegable con texto visible
    public void selectSamples(WebElement elm, String txtvisible)   {
        String msg;
        try {
            Select sel = new Select(elm);
            sel.selectByVisibleText(txtvisible);
            msg = "[OK] : Select: " + txtvisible + " in " + JavaHTML.elementToStringHTML(elm.toString());
            logExtentReport(msg, Status.PASS, false);
        } catch (Exception ex) {
            msg = "[ERROR] : Fail Select: " + txtvisible + " in " + ex.getMessage();
            logExtentReport(msg, Status.FAIL, false);
        }
        Log.register(msg);
    }


    // Realiza un scroll hasta abajo de la pantalla
    public void scrollBottom()   {
        String msg;
        try {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
            msg = ("[OK] " + ": Scroll hacia abajo correcto.");
            logExtentReport(msg, Status.PASS, false);
        } catch (Exception ex) {
            msg = ("[ERROR] " + ": Error al realizar un scroll hacia abajo");
            logExtentReport(msg, Status.FAIL, false);
        }
        Log.register(msg);
    }

    // Realiza un scroll hasta arriba de la pantalla
    public void scrollTop()   {
        String msg;
        try {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollTop)");
            msg = ("[OK] " + ": Scroll hacia arriba correcto.");
            logExtentReport(msg, Status.PASS, false);
        } catch (Exception ex) {
            msg = ("[ERROR] " + ": Error al realizar un scroll hacia arriba.");
            logExtentReport(msg, Status.FAIL, false);
        }
        Log.register(msg);
    }

    // Realiza un scroll un número de pixeles que se pasan como parámetro
    public void scrollDown(int puntos)   {
        String msg;
        try {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + puntos + ")");
            msg = ("[OK] " + ": Scroll hacia abajo correcto, " + puntos
                    + " pixeles");
            logExtentReport(msg, Status.PASS, false);
        } catch (Exception ex) {
            msg = ("[ERROR] "
                    + ": Error al realizar un scroll hacia abajo en " + puntos + " píxeles");
            logExtentReport(msg, Status.FAIL, false);
        }
        Log.register(msg);
    }

    public void scrollUp(int puntos)   {
        String msg;
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("scroll(0, " + puntos + ");");
            msg = ("[OK] " + ": Scroll hacia arriba correcto, " + puntos
                    + " pixeles");
            logExtentReport(msg, Status.PASS, false);
        } catch (Exception ex) {
            msg = ("[ERROR] "
                    + ": Error al realizar un scroll hacia arriba en " + puntos + " píxeles");
            logExtentReport(msg, Status.FAIL, false);
        }
        Log.register(msg);
    }

    // Método para hacer un scroll hacia abajo hasta que un elemento es visible
    public void scrollDownTo(WebElement elm)   {
        String msg;
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", elm);
            msg = ("[OK] " + ": Scroll hacia abajo correcto, "
                    + JavaHTML.elementToStringHTML(elm.toString()) + "visible");
            logExtentReport(msg, Status.PASS, false);
        } catch (Exception ex) {
            msg = ("[ERROR] "
                    + ": Error al realizar un scroll hacia abajo en busca de " + JavaHTML.elementToStringHTML(elm.toString()));
            logExtentReport(msg, Status.FAIL, false);
        }
        Log.register(msg);
    }


    public void logExtentReport(String texto, Status status, boolean captura) {
        String reporteHTML = "";
        if (texto.contains("[OK]")) {
            reporteHTML = texto.replace("[OK]", "<span style=\"color:limegreen; font-weight: bold;\"\\>[OK]</span>");
        } else if (texto.contains("[ERROR]")) {
            reporteHTML = texto.replace("[ERROR]", "<span style=\"color:red; font-weight: bold;\"\\>[ERROR]</span>");
        } else if (texto.contains("[WARNING]")) {
            reporteHTML = texto.replace("[WARNING]", "<span style=\"color:orange; font-weight: bold;\"\\>[WARNING]</span>");
        }
    }
    // Este método espera un nçumero de segundos determinado
    public void wait(int secs) {
        try {
            Thread.sleep(secs * 1000);
            Log.register("[OK][" + this.getClass().getSimpleName() + "]" + ": Espera de " + secs + " realizada.");
        } catch (Exception ex) {
            Log.register("[ERROR][" + this.getClass().getSimpleName() + "]" + ": Error al realizar la espera.");
        }
    }

}
