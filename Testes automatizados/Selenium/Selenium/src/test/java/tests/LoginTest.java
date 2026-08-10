package tests;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import utils.ConfigManager;
import utils.ReportManager;
import utils.ScreenshotUtils;



public class LoginTest
{
    private WebDriver driver;
    private LoginPage loginPage;

    // atributos estáticos para controlar o relatório
    private static ExtentReports extent;
    private ExtentTest test;

    // roda uma unica vez antes de todos os testes
    @BeforeAll
    public static void iniciarRelatorio() {
        extent = ReportManager.getInstance();
    }

    @AfterAll
    public static void finalizarRelatorio() {
        ReportManager.finalizarRelatorio();
    }

    // roda depois de cada teste para fechar a janela do navegador
    @AfterEach
    public void fecharNavegador()
    {
        if (driver != null)
        {
            driver.quit();
        }
    }


    @BeforeEach
    public void abrirNavegador()
    {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(ConfigManager.getProperty("url.base"));

        loginPage = new LoginPage(driver);
    }

    // primeiro teste
    @Test
    public void loginComUsuarioNaoCadastrado()
    {
        // cria a aba desse teste no relatório
        test = extent.createTest("Login com usuário não cadastrado");

        // act
        loginPage.preencherUsuario("usuarioquenaoexiste");
        // pega a senha da variavel de ambiente, caso nao tenha nenhuma será senha_qualquer
        loginPage.preencherSenha(ConfigManager.getProperty("senha.padrao"));

        // clica no botão de login
        loginPage.clicarLogin();

        // obtém o texto da mensagem de erro e armazena em textoMensagem
        String textoMensagem = loginPage.obterTextoMensagemErro();
        // verifica se o texto contém o erro esperado
        Assertions.assertTrue(
                textoMensagem.contains("Username and password do not match any user in this service")
        );

        // verifica se a atual url do driver é igual a url base definida no config.properties
        Assertions.assertEquals(ConfigManager.getProperty("url.base"), driver.getCurrentUrl());

        String screenshotBase64 = ScreenshotUtils.capturarBase64(driver);

        test.pass(
                "Tentativa de login fracassou com sucesso",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        screenshotBase64, "Tela final na tentativa de login com usuário não cadastrado"
                ).build()
        );
    }



    @Test
    public void loginComSenhaEmBranco()
    {
        test = extent.createTest("Login com senha em branco");

        // act
        loginPage.preencherUsuario("standard_user");
        loginPage.clicarLogin();

        // assert
        String textoMensagem = loginPage.obterTextoMensagemErro();
        Assertions.assertTrue(textoMensagem.contains("Password is required"));
        Assertions.assertEquals(ConfigManager.getProperty("url.base"), driver.getCurrentUrl());

        // screenshot
        String screenshotBase64 = ScreenshotUtils.capturarBase64(driver);
        test.pass(
                "Tentativa de login fracassou com sucesso",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        screenshotBase64, "Tela final na tentativa de login com senha em branco"
                ).build()
        );
    }

    @Test
    public void loginComUsuarioEmBranco()
    {
        test = extent.createTest("Login com usuario em branco");

        // act
        loginPage.preencherSenha(ConfigManager.getProperty("senha.padrao"));
        loginPage.clicarLogin();

        // assert
        String textoMensagem = loginPage.obterTextoMensagemErro();
        Assertions.assertTrue(textoMensagem.contains("Username is required"));
        Assertions.assertEquals(ConfigManager.getProperty("url.base"), driver.getCurrentUrl());

        // screenshot
        String screenshotBase64 = ScreenshotUtils.capturarBase64(driver);
        test.pass(
                "Tentativa de login fracassou com sucesso",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        screenshotBase64, "Tela final na tentativa de login com usuário em branco"
                ).build()
        );
    }

    @Test
    public void loginComUsuarioCadastradoESenhaInvalida()
    {
        test = extent.createTest("Login com usuário válido e senha inválida");

        // act
        loginPage.preencherUsuario("standard_user");
        loginPage.preencherSenha("senhaaleatoria8");
        loginPage.clicarLogin();

        // assert
        String textoMensagem = loginPage.obterTextoMensagemErro();
        Assertions.assertTrue(textoMensagem.contains("Username and password do not match any user in this service"));
        Assertions.assertEquals(ConfigManager.getProperty("url.base"), driver.getCurrentUrl());

        // screenshot
        String screenshotBase64 = ScreenshotUtils.capturarBase64(driver);
        test.pass(
                "Tentativa de login fracassou com sucesso",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        screenshotBase64, "Tela final na tentativa de login com usuário cadastrado e senha inválida"
                ).build()
        );
    }

    @Test
    public void loginComAmbosCamposEmBranco()
    {
        test = extent.createTest("Login com usuário e senha em branco");

        // act
        loginPage.preencherUsuario("");
        loginPage.preencherSenha("");
        loginPage.clicarLogin();

        // assert
        String textoMensagem = loginPage.obterTextoMensagemErro();
        Assertions.assertTrue(textoMensagem.contains("Username is required"));
        Assertions.assertEquals(ConfigManager.getProperty("url.base"), driver.getCurrentUrl());

        // screenshot
        String screenshotBase64 = ScreenshotUtils.capturarBase64(driver);
        test.pass(
                "Tentativa de login fracassou com sucesso",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        screenshotBase64, "Tela final na tentativa de login com ambos os campos em branco"
                ).build()
        );
    }

    @Test
    public void loginValido()
    {
        test = extent.createTest("Login válido");

        // act
        loginPage.preencherUsuario("standard_user");
        loginPage.preencherSenha(ConfigManager.getProperty("senha.padrao"));
        loginPage.clicarLogin();

        // assert
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("/inventory.html"), "A URL atual não termina com /inventory.html");

        // screenshot
        String screenshotBase64 = ScreenshotUtils.capturarBase64(driver);
        test.pass(
                "Login realizado com sucesso",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        screenshotBase64, "Tela final na tentativa de login válida"
                ).build()
        );
    }

}