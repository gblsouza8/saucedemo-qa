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
import utils.ScreenshotUtils;

public class CartTest {
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
    public void logarNoSite()
    {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(ConfigManager.getProperty("url.base"));
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);

        loginPage.preencherUsuario("standard_user");
        loginPage.preencherSenha(ConfigManager.getProperty("senha.padrao"));
        loginPage.clicarLogin();

    }

    @Test
    public void adicionarProduto()
    {
        test = extent.createTest("Adicionar primeiro produto ao carrinho");

        //act
        inventoryPage.clicarAdicionar1();

        inventoryPage.navegarCarrinho();

        //assert
        Assertions.assertTrue(inventoryPage.isBadgeCarrinhoVisivel(),"O badge do carrinho deveria estar visível após adicionar o item.");
        Assertions.assertTrue(cartPage.itemContemTexto("Backpack"), "O item 'Backpack' não foi encontrado.");

        String screenshotBase64 = ScreenshotUtils.capturarBase64(driver);
        test.pass(
                "Produto foi adicionado com sucesso no carrinho",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        screenshotBase64, "Tela final na tentativa de adicionar um produto ao carrinho"
                ).build()
        );
    }

    @Test
    public void adicionarMaisProdutos()
    {
        test = extent.createTest("Adicionar vários produtos ao carrinho");


        inventoryPage.clicarAdicionar1();
        inventoryPage.clicarAdicionar2();

        inventoryPage.navegarCarrinho();

        Assertions.assertTrue(inventoryPage.isBadgeCarrinhoVisivel(),"O badge do carrinho deveria estar visível após adicionar o item.");
        Assertions.assertTrue(cartPage.itemContemTexto("Backpack"), "O item 'Backpack' não foi encontrado.");
        Assertions.assertTrue(cartPage.itemContemTexto("Light"), "O item 'Light' não foi encontrado.");

        String screenshotBase64 = ScreenshotUtils.capturarBase64(driver);
        test.pass(
                "Produtos foram adicionados com sucesso",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        screenshotBase64, "Tela final na tentativa de adicionar vários produtos ao carrinho"
                ).build()
        );
    }

    @Test
    public void removerProdutoViaInventory()
    {
        test = extent.createTest("Remover um produto do carrinho pela página inventory");
        inventoryPage.clicarAdicionar1();

        inventoryPage.clicarRemoverItem();

        inventoryPage.navegarCarrinho();
        Assertions.assertFalse(cartPage.itemContemTexto("Backpack"), "O item 'Backpack' foi encontrado.");

        String screenshotBase64 = ScreenshotUtils.capturarBase64(driver);
        test.pass(
                "Produto foi removido com sucesso",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        screenshotBase64, "Tela final na tentativa de remover um produto do carrinho pelo Inventory"
                ).build()
        );
    }

    @Test
    public void removerProdutoViaCart()
    {
        test = extent.createTest("Remover um produto do carrinho pela página carrinho");
        inventoryPage.clicarAdicionar1();
        inventoryPage.navegarCarrinho();


        cartPage.clicarRemoverItem();
        Assertions.assertFalse(cartPage.itemContemTexto("Backpack"), "O item 'Backpack' foi encontrado.");
        String screenshotBase64 = ScreenshotUtils.capturarBase64(driver);
        test.pass(
                "Produto foi removido com sucesso",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        screenshotBase64, "Tela final na tentativa de remover um produto pelo carrinho"
                ).build()
        );


    }



}
