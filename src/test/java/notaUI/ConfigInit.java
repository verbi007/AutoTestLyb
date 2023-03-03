package notaUI;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import java.io.IOException;

public abstract class ConfigInit {

    public static void config(String fileName, String urlFileName) throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream(fileName));
        Configuration.browser = "chrome";
        Configuration.browserSize = "2560x1600";
        Selenide.open(System.getProperty(urlFileName));
    }
}
