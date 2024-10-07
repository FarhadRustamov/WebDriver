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


public class InputField_Test {

    private WebDriver webDriver;
    private final String link = System.getProperty("base.url");
    private final By inputFieldSelector = By.id("textInput");
    private final static Logger logger = LogManager.getLogger(InputField_Test.class);

    @BeforeAll
    static void beforeAll() {
        logger.trace("Invoke of the beforeAll method");
        new WebDriverManagerFactory().getWebDriverManager();
        logger.trace("Exiting the beforeAll method");
    }

    @BeforeEach
    void setUp() {
        logger.trace("Invoke of the setUp method");
        webDriver = new WebDriverFactory().getDriver(Mode.HEADLESS);
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
    void inputFieldTest() {
        logger.trace("Invoke of the inputFieldTest method");
        String expectedResult = "ОТУС";
        WebElement inputField = webDriver.findElement(inputFieldSelector);
        inputField.sendKeys(expectedResult);
        Assertions.assertEquals(expectedResult, inputField.getAttribute("value"));
        logger.trace("Exiting the inputFieldTest method");
    }
}
