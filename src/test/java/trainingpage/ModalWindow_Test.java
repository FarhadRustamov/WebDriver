package trainingpage;

import factories.WebDriverFactory;
import factories.WebDriverManagerFactory;
import data.Mode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ModalWindow_Test {

    private WebDriver webDriver;
    private final String link = System.getProperty("base.url");
    private final By buttonSelector = By.id("openModalBtn");
    private final By modalWindowTitleSelector = By.cssSelector("div#myModal h2");
    private final static Logger logger = LogManager.getLogger(ModalWindow_Test.class);

    @BeforeAll
    static void beforeAll() {
        logger.trace("Invoke of the beforeAll method");
        new WebDriverManagerFactory().getWebDriverManager();
        logger.trace("Exiting the beforeAll method");
    }

    @BeforeEach
    void setUp() {
        logger.trace("Invoke of the setUp method");
        webDriver = new WebDriverFactory().getDriver(Mode.FULL_SCREEN);
        webDriver.get(link);
        logger.trace("Exiting the setUp method");
    }

    @AfterEach
    void tearDown() {
        logger.trace("Invoke of the tearDown method");
        if (webDriver != null) {
            webDriver.quit();
        }
        logger.trace("Exiting the tearDown method");
    }

    @Test
    void modalWindowTest() {
        logger.trace("Invoke of the modalWindowTest method");
        webDriver.findElement(buttonSelector).click();
        WebElement modalWindowTitle = webDriver.findElement(modalWindowTitleSelector);
        String actualText = modalWindowTitle.getText();
        Assertions.assertEquals("Это модальное окно", actualText);
        logger.trace("Exiting the modalWindowTest method");
    }
}
