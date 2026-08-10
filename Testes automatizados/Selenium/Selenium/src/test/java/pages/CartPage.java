package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CartPage {
    private WebDriver driver;

    private By removerItem = By.cssSelector("[data-test='remove-sauce-labs-backpack']");
    private By itemNoCarrinho = By.cssSelector("[data-test='inventory-item-name']");
    private By nomeItem = By.cssSelector("[data-test='inventory-item-name']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clicarRemoverItem()
    {
        driver.findElement(removerItem).click();
    }

    public boolean itemContemTexto(String textoEsperado) {
        return driver.findElements(nomeItem)
                .stream()
                .anyMatch(elemento -> elemento.getText().contains(textoEsperado));
    }

}



