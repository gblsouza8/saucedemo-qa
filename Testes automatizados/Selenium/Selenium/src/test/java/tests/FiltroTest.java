package tests;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.InventoryPage;
import pages.CartPage;
import utils.ConfigManager;
import utils.ReportManager;
import org.junit.jupiter.api.TestInfo;
import utils.ScreenshotUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FiltroTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private CartPage cartPage;
    private InventoryPage inventoryPage;
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
    public void logarNoSite(TestInfo testInfo)
    {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(ConfigManager.getProperty("url.base"));
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);

        // Captura o nome do método de teste atual
        String nomeDoMetodo = testInfo.getTestMethod().get().getName();

        // Condicional para definir qual usuário utilizar
        if (nomeDoMetodo.equals("filtroZA")) {
            loginPage.preencherUsuario("error_user");
        } else {
            loginPage.preencherUsuario("standard_user");
        }
        loginPage.preencherSenha(ConfigManager.getProperty("senha.padrao"));
        loginPage.clicarLogin();

        test = extent.createTest(testInfo.getDisplayName());
    }


    @Test
    public void filtroLoHi()
    {
        // act
        test = extent.createTest("Filtragem de menor para o maior");
        inventoryPage.selecionarFiltroPorValor("lohi");
        // assert

        // pega a lista dos preços na tela
        List<Double> precosAtuais = inventoryPage.obterListaDePrecos();
        // cria uma lista com os preços ordenados
        List<Double> precosOrdenadosEsperados = new ArrayList<>(precosAtuais);
        Collections.sort(precosOrdenadosEsperados);

        // verifica se as listas estão iguais
        Assertions.assertEquals(precosOrdenadosEsperados, precosAtuais, "A lista de preços exibida na tela não está ordenada do menor para o maior");
        String screenshotBase64 = ScreenshotUtils.capturarBase64(driver);
        test.pass(
                "Produtos foram ordenados com sucesso",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        screenshotBase64, "Tela final na tentativa de ordenar em ordem crescente."
                ).build()
        );


    }

    @Test
    public void filtroHiLo()
    {
        // act
        test = extent.createTest("Filtragem de maior para o menor");
        inventoryPage.selecionarFiltroPorValor("hilo");
        // assert

        // pega a lista dos preços na tela
        List<Double> precosAtuais = inventoryPage.obterListaDePrecos();
        // cria uma lista com os preços ordenados
        List<Double> precosOrdenadosEsperados = new ArrayList<>(precosAtuais);
        Collections.sort(precosOrdenadosEsperados, Collections.reverseOrder());

        // verifica se as listas estão iguais
        Assertions.assertEquals(precosOrdenadosEsperados, precosAtuais, "A lista de preços exibida na tela não está ordenada do maior para o menor");
        String screenshotBase64 = ScreenshotUtils.capturarBase64(driver);
        test.pass(
                "Produtos foram ordenados com sucesso",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        screenshotBase64, "Tela final na tentativa de ordenar em ordem decrescente."
                ).build()
        );
    }

    @Test
    public void filtroAZ()
    {
        test = extent.createTest("Filtragem de A para Z");

        inventoryPage.selecionarFiltroPorValor("az");

        List<String> nomesAtuais = inventoryPage.obterListaDeNomes();
        List<String> nomesOrdenadosEsperados = new ArrayList<>(nomesAtuais);
        Collections.sort(nomesOrdenadosEsperados);

        Assertions.assertEquals(nomesOrdenadosEsperados, nomesAtuais, "A lista não está ordenada de A para Z.");
        String screenshotBase64 = ScreenshotUtils.capturarBase64(driver);
        test.pass(
                "Produtos foram ordenados com sucesso",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        screenshotBase64, "Tela final na tentativa de ordenar em ordem alfabética."
                ).build()
        );
    }

    @Test
    public void filtroZA() {
        test = extent.createTest("Filtragem de Z para A");

        try {
            inventoryPage.selecionarFiltroPorValor("za");

            List<String> nomesAtuais = inventoryPage.obterListaDeNomes();
            List<String> nomesOrdenadosEsperados = new ArrayList<>(nomesAtuais);
            Collections.sort(nomesOrdenadosEsperados, Collections.reverseOrder());


            Assertions.assertEquals(nomesOrdenadosEsperados, nomesAtuais, "A lista não está ordenada de Z para A.");
            String screenshotBase64 = ScreenshotUtils.capturarBase64(driver);
            test.pass(
                    "Produtos foram ordenados com sucesso",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(
                            screenshotBase64, "Tela final na tentativa de ordenar em ordem alfabética inversa."
                    ).build()
            );
        } catch(Throwable e)
        {
            String screenshotBase64 = ScreenshotUtils.capturarBase64(driver);
            test.fail(
                    "Produtos NÃO foram ordenados com sucesso",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(
                            screenshotBase64, "Tela final na tentativa de ordenar em ordem alfabética inversa."
                    ).build()
            );

            throw e;
        }
    }

}


