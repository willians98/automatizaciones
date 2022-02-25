package framework.Config;


import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import jdk.nashorn.internal.scripts.JO;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class GridConfig {

    public static WebDriver driver = null;
    public static Properties config = null;
    public static Properties datos = null;
    public static Log log;



    // Reporte
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeTest
    public void beforeTest() {
        try {
            Log.dateTime = Log.systemDate();
            log = new Log();
        } catch (IOException ex) {
            //todo Auto-generated catch block
            ex.printStackTrace();
        }
        //Parte del reporte extendido
        setupReport();
    }

    @BeforeTest (alwaysRun = true)
    public void setupDrive() {
        System.out.println("SetupDrive()");
        config = new Properties();
        datos = new Properties();
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            try {
                config.load(new FileInputStream("config/config.properties"));
                datos.load(new FileInputStream("datos/datos.properties"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            caps.setPlatform(Platform.WINDOWS);
            System.setProperty("webdriver.gecko.driver", config.getProperty("firefoxPath"));
            //ProfilesIni profile = new ProfilesIni();
            //FirefoxProfile fxProfile = profile.getProfile("profileToolsQA");
            //FirefoxOptions options = new FirefoxOptions();
            //options.setProfile(fxProfile);
            driver = new FirefoxDriver(); //(options)
            driver.manage().window().maximize();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Operación fallida, no se ha podido configurar el entorno");
        }
    }

    public static void setupReport() {
        String titulo = JavaHTML.imgInicialHTML(".\\images\\mtp.jpg", 150, 30);
        System.out.println("la ruta final es: " + titulo);
        htmlReporter = new ExtentHtmlReporter("reportsFolder\\outputs\\reporteHTML\\testReport-" + Log.dateTime + ".html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setReportUsesManualConfiguration(true);
        extent.setAnalysisStrategy(AnalysisStrategy.SUITE);
        // configuration items to change the look and feel add content, manage tests etc
        htmlReporter.config().setDocumentTitle("ChessTest Report");
        htmlReporter.config().setReportName(titulo);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setTimeStampFormat("EEEE, MMM dd, yyyy, hh:mm a '('zzz')'");
    }

    @AfterMethod
    public void getResult (ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " ha fallado ", ExtentColor.RED));
            test.fail(result.getThrowable());
        } else if ( result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " ha sido exitoso ", ExtentColor.GREEN));
        } else {
            test.log(Status.SKIP, MarkupHelper.createLabel (result.getName() + " saltado ", ExtentColor.YELLOW));
            test.skip(result.getThrowable());
        }
    }

    @AfterTest
    public void tearDown() {
        extent.flush();
    }

    @AfterSuite
    public void afterSuite() {
        try {
            wait(3000);
            driver.close();
            driver.quit();
            System.out.println("Ok al desconectar");
        } catch (Exception ex) {
            System.out.println("Error al desconectar");
        }
    }

}