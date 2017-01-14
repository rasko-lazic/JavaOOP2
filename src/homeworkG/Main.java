package homeworkG;

import homeworkG.graphics.WeatherWindow;

public class Main {
    public static void main(String[] args) {
        System.setProperty("http.proxyHost", "proxy.viser.edu.rs");
        System.setProperty("http.proxyPort", "3128");
        WeatherWindow w = new WeatherWindow();
    }
}
