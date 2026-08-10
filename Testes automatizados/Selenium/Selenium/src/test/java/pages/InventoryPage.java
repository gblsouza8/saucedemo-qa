package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.stream.Collectors;


public class InventoryPage {
    private WebDriver driver;

    private By adicionarItem1 = By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']");
    private By adicionarItem2 = By.cssSelector("[data-test='add-to-cart-sauce-labs-bike-light']");
    private By iconeCarrinho = By.cssSelector("[data-test='shopping-cart-link']");
    private By badgeCarrinho = By.cssSelector("[data-test='shopping-cart-badge']");
    private By removerItem1 = By.cssSelector("[data-test='remove-sauce-labs-backpack']");
    private By filtro = By.cssSelector("[data-test='product-sort-container']");
    private By precoItem = By.cssSelector("[data-test='inventory-item-price']");
    private By nomeItem = By.cssSelector("[data-test='inventory-item-name']");

    public InventoryPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clicarAdicionar1()
    {
        driver.findElement(adicionarItem1).click();
    }

    public void navegarCarrinho()
    {
        driver.findElement(iconeCarrinho).click();
    }

    public void clicarAdicionar2()
    {
        driver.findElement(adicionarItem2).click();
    }

    public void clicarRemoverItem()
    {
        driver.findElement(removerItem1).click();
    }

    public boolean isBadgeCarrinhoVisivel()
    {
        return !driver.findElements(badgeCarrinho).isEmpty();
    }

    public void selecionarFiltroPorValor(String valor) {
        Select dropdown = new Select(driver.findElement(filtro));
        dropdown.selectByValue(valor);
    }

    public List<Double> obterListaDePrecos() {
        return driver.findElements(precoItem)
                .stream()
                .map(elemento -> Double.parseDouble(elemento.getText().replace("$", "").trim()))
                .collect(Collectors.toList());
    }

    public List<String> obterListaDeNomes() {
        return driver.findElements(nomeItem)
                .stream()
                .map(elemento -> elemento.getText().trim())
                .collect(Collectors.toList());
    }

}
