package trainingpage;

import factories.WebDriverFactory;
import factories.WebDriverManagerFactory;
import enums.Mode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class Form_Test {

    private WebDriver webDriver;
    private final String link = System.getProperty("base.url");
    private final By inputFieldsSelector = By.cssSelector("form>input");
    private final By submitButtonSelector = By.cssSelector("button[type='submit']");
    private final By messageSelector = By.id("messageBox");
    private final static Logger logger = LogManager.getLogger(Form_Test.class);

    @BeforeAll
    public static void beforeAll() {
        logger.trace("Invoke of the beforeAll method");
        new WebDriverManagerFactory().getWebDriverManager();
        logger.trace("Exiting the beforeAll method");
    }

    @BeforeEach
    public void setUp() {
        logger.trace("Invoke of the setUp method");
        webDriver = new WebDriverFactory().getDriver(Mode.MAXIMIZED);
        webDriver.get(link);
        logger.trace("Exiting the setUp method");
    }

    @AfterEach
    public void tearDown() {
        logger.trace("Invoke of the tearDown method");
        if (webDriver != null) {
            webDriver.quit();
        }
        logger.trace("Exiting the tearDown method");
    }

    @Test
    public void formTest() {
        logger.trace("Invoke of the formTest method");
        String name = "фыв";
        String email = "asdf@sdfg.rt";
        List<WebElement> inputFields = webDriver.findElements(inputFieldsSelector); // Сразу нахожу оба инпут-поля, чтобы лишний раз не использовать findElement(), т.к. это дорогостоящая операция с т.з. скорости
        inputFields.get(0).sendKeys(name);
        inputFields.get(1).sendKeys(email);
        webDriver.findElement(submitButtonSelector).click();
        WebElement message = webDriver.findElement(messageSelector);
        Assertions.assertEquals(String.format("Форма отправлена с именем: %s и email: %s", name, email), message.getText());
        logger.trace("Exiting the formTest method");
    }
}
