package framework.Config;

import static org.testng.Assert.assertTrue;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.Reporter;

public class Log extends WebActions{

    static BufferedWriter bw = null;
    static FileWriter fw = null;
    static String ruta = null;
    static boolean debuging;

    public static String dateTime = null;

    // Extent Report
    static String rutaReports = "reportsFolder";

    public Log() throws IOException {
        createFolderExtents();
        String rrpp = "outputs-" + dateTime;
        String rutaOutputs = "reportsFolder\\" + rrpp;
        Path p = Paths.get(rutaOutputs);

        String rutaLogs = rutaOutputs + File.separator + "logs";
        File file = new File(rutaLogs);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                System.out.println("Creando padre");
                file.getParentFile().mkdir();
            }
            file.mkdir();
        }

        //ruta = rutaOutputs + "\\logs\\log-" + dateTime + ".txt";
        ruta = System.getProperty("user.dir") + File.separator + "reportsFolder" + File.separator + rrpp + File.separator + "logs" + File.separator + "log-" + dateTime + ".txt";
        System.out.println(ruta);
    }

    public void createFolderExtents() {
        Path p = Paths.get(rutaReports);
        File firstFolder = new File(rutaReports);
        if (!firstFolder.exists()) {
            firstFolder.mkdir();
        }
    }

    public static String systemDate() {
        Date date = new Date();
        String strDateFormat = "dd_MM"; // El formato de fecha esta especificado
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); // La cadena de formato de fecha se pasa como un
        // argumento al objeto
        String dt = objSDF.format(date);
        return dt;
    }

    public static String systemHour() {
        Date hour = new Date();
        String strDateFormat = "HH_mm_ss"; // El formato de fecha esta especificado
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); // La cadena de formato de fecha se pasa como un
        // argumento al objeto
        String time = objSDF.format(hour);
        return time;
    }

    public static void register(String msg) {
        // Con este método se mostrará en el Log (un archivo guardado en una carpeta) el
        // resultado del caso
        // También se mostrará por consola y en un reporte de TestNG
        String log;
        log = "[" + systemHour() + "] - " + msg;
        System.out.println(log);
        writeLog(log);

    }

	/*public static void addScreenShot(File screenShot) {

		File compressedImageFile = compressImage(screenShot);
		String codedScrennshot = encodeImageToBase64(screenShot);
		String height = "500";
		String padding = "50";

		Reporter.log("<br> <img src=data:image/gif;base64," + codedScrennshot + " style=\"height: " + height
				+ "px; padding: " + padding + "px; \"> <br/> ");
	}*/

    public static void registerFinal() {
        String log;
        log = "/**********************************************************************************/ \n" + "["
                + systemHour() + "] - [Cerrando driver de Appium]";
        System.out.println(log);
        Reporter.log(log);
        writeLog(log);
    }

    public static void writeLog(String log) {
        //Este método será el encargado de escribir en el log
        try {
            File fl = new File(ruta);
            if (!fl.exists()) {
                fl.createNewFile();
            }
            fw = new FileWriter(fl.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(log);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            assertTrue(1 == 2);
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}