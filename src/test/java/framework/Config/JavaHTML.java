package framework.Config;

public class JavaHTML {
    public JavaHTML() {
        // TODO Auto-generated constructor stub
    }

    public static String elementToStringHTML(String txt) {
        return "<span style=\"font-style: italic; color: gray;\">" + txt + "</span>]";
    }

    public static String imgInicialHTML(String rutaImg, int width, int marginLeft) {
        return "<img src=\""+ rutaImg + "\" alt=\"Reporte Extents\" height=\"50\" width=\"" + width + "\" ><img style=\"margin-left: "+ marginLeft +"%; \" src=\"" + ".\\images\\scalefast.png\" height=\"50\" width=\"150\">";
    }

}