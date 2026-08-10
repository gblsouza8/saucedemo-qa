package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    // Método que tira o print e devolve em formato Base64 (texto da imagem)
    public static String capturarBase64(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }
}