package framework.WebElements;


import com.gargoylesoftware.htmlunit.WebWindow;
import org.openqa.selenium.By;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.Config.WebActions;

import javax.xml.xpath.XPath;
import java.security.cert.X509Certificate;


public class MainPage extends WebActions {

    public  MainPage() {
        PageFactory.initElements(driver, this);
    }

    //Amazon
    @FindBy(xpath = "//*[@id=\"nav-link-accountList-nav-line-1\"]")
    public WebElement Login_Amazon;
    @FindBy(xpath = "//*[@id=\"ap_email\"]")
    public WebElement User_Amazon;


    @FindBy(xpath = "//*[@id=\"continue\"]")
    public WebElement User_Continue;
    @FindBy(xpath = "//*[@id=\"ap_password\"]")
    public WebElement Pass_Amazon;
    @FindBy(xpath = "//*[@id=\"signInSubmit\"]")
    public WebElement Pass_Continue;

    //Chess
    @FindBy(xpath = "//*[@id=\"sb\"]/div[3]/a[9]/span[2]")
    public WebElement Login_Chess;
    @FindBy(xpath = "//*[@id=\"username\"]")
    public WebElement User_Chess;
    @FindBy(xpath = "//*[@id=\"password\"]")
    public WebElement Pass_Chess;
    @FindBy (xpath = "//*[@id=\"login\"]")
    public WebElement Login2_Chess;

    //Facebook
    @FindBy(xpath = "*[@id=\"u_0_r_dP\"]")
    public WebElement Cookies_Facebook;
    @FindBy(xpath = "//*[@class=\"_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy\"]")
    public WebElement Register_Facebook;
    @FindBy (xpath = "//*[@name=\"birthday_day\"]")
    public WebElement Day_Facebook;
    @FindBy (xpath = "//*[@id=\"day\"]")
    public WebElement Day_Facebook2;

    @FindBy (xpath = "//*[@name=\"birthday_month\"]")
    public WebElement Month_Facebook;
    @FindBy (xpath = "//*[@name=\"birthday_year\"]")
    public WebElement Year_Facebook;
    @FindBy (xpath = "//*[text()=\"Hombre\"]")
    public WebElement Hombre;
    //*[@id="u_3_o_k3"]/span[2]/label





    //Goodreads
    @FindBy (xpath = "//*[@id=\"signInUsingContent\"]/a[1]")
    public WebElement Login_Goodreads;
    @FindBy(xpath = "//*[@id=\"email\"]")
    public WebElement User_Goodreads;
    @FindBy(xpath = "//*[@id=\"pass\"]")
    public WebElement Pass_Goodreads;
    @FindBy(xpath = "//*[@id=\"loginbutton\"]")
    public WebElement Login2_Goodreads;
    @FindBy(xpath = "//*[@class=\"searchBox__input searchBox__input--navbar\"]")
    public WebElement Search_box;
    @FindBy(xpath = "//*[text()=\"Steelheart (The Reckoners, #1)\"]")
    public WebElement Libro1;

    //Auto
    @FindBy (xpath = "//*[@class=\"wtrShelfButton\"]")
    public WebElement Desplegable_Libro1;
    @FindBy (xpath = "//*[text()=\"Read\"]")
    public WebElement Categoria_Libro1;


    @FindBy (xpath = "//*[@href=\"https://www.goodreads.com/review/edit/17182126\"]")
    public WebElement Review;
    //Manual
    @FindBy(xpath = "//*[@class=\"Button Button--wtr Button--medium Button--rounded\"]")
    public WebElement Desplegable_Libro;
    @FindBy(xpath = "//*[text()=\"Read\"]")
    public WebElement Categoria_Libro;
    @FindBy(xpath = "//*[text()=\"Done\"]")
    public WebElement Done_libro;
//    @FindBy(xpath= "//*[@href= \"https://www.goodreads.com/review/edit/17182126\"]")
//    public WebElement Review;


    //Review
    @FindBy (xpath ="//*[text()=\"3 of 5 stars\"]")
    public WebElement Tres_Estrellas;


    //Fecha libro inicio
    @FindBy(xpath = "//*[@class=\"rereadDatePicker smallPicker startYear\"]")
    public WebElement Sel_Anyo_Inicio;
    @FindBy(xpath = "//*[@class=\"rereadDatePicker largePicker startMonth\"]")
    public WebElement Sel_Mes_Inicio;
    @FindBy(xpath = "//*[@class=\"rereadDatePicker smallPicker startDay\"]")
    public WebElement Sel_Dia_Inicio;

    //Fecha Libro Final
    @FindBy(xpath = "//*[@class=\"rereadDatePicker smallPicker endYear\"]")
    public WebElement Sel_Anyo_Final;
    @FindBy(xpath = "//*[@class=\"rereadDatePicker largePicker endMonth\"]")
    public WebElement Sel_Mes_Final;
    @FindBy(xpath = "//*[@class=\"rereadDatePicker smallPicker endDay\"]")
    public WebElement Sel_Dia_Final;


    @FindBy(xpath = "//*[@id=\"review_submit_for_17182126\"]")
    public WebElement Submit;

    //nuevas pruebas youtube
    @FindBy (xpath = "//*[text()=\"Acepto\"]")
    public WebElement Cookies_Youtube;
    @FindBy(xpath = "//*[@id=\"buttons\"]/ytd-button-renderer/a")
    public WebElement Login_Youtube;
    //inicio de sesion datos
    @FindBy(xpath = "//*[@id=\"identifierId\"]")
    public WebElement Mail_youtube;
    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[1]/div/div/div/div/div[1]/div/div[1]/input")
    public WebElement Password_youtube;
    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button")
    public WebElement Siguiente_youtube;
    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button")
    public WebElement Siguiente2_youtube;
    //buscar y reproducir video en youtube
    @FindBy(xpath = "/html/body/ytd-app/div/div/ytd-masthead/div[3]/div[2]/ytd-searchbox/form/div[1]/div[1]/input")
    public WebElement Buscador_Youtube;
    @FindBy(xpath = "//*[@id=\"video-title\"]")
    public WebElement Video_Youtube;
    @FindBy(xpath = "/html/body/ytd-app/div/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[1]/div/div/div/ytd-player/div/div/div[26]/div[2]/div[2]/button[10]")
    public WebElement Pantalla_Completa_Youtube;



}

    /* Ejemplos
    @FindBy (xpath = "xpathvalue") public WebElement labelvalue;
    @FindBy (xpath = "//*[@name=\"birthday_day\"]")
    @FindBy (xpath = "//*[@id=\"ap_email\"]")
    @FindBy (xpath = "//*[text()=\"Steelheart (The Reckoners, #1)\"]")
    @FindBy (xpath= "//*[@href= \"/wiki/El_imperio_final\"]")
    @FindBy (xpath = "//*[@class=\"select span12 saveInput\"]")
     */

//}

