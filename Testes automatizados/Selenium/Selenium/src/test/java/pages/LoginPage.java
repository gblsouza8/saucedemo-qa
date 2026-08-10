package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // mapeamento dos elementos
    private By campoUsuario = By.cssSelector("[data-test='username']");
    private By campoSenha = By.cssSelector("[data-test='password']");
    private By botaoLogin = By.cssSelector("[data-test='login-button']");
    private By mensagemErro = By.cssSelector("[data-test='error']");


    // construtor
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void preencherUsuario(String usuario)
    {
        driver.findElement(campoUsuario).sendKeys(usuario);
    }

    public void preencherSenha(String senha)
    {
        driver.findElement(campoSenha).sendKeys(senha);
    }

    public void clicarLogin()
    {
        driver.findElement(botaoLogin).click();
    }

    public String obterTextoMensagemErro()
    {
        return driver.findElement(mensagemErro).getText();
    }

}
