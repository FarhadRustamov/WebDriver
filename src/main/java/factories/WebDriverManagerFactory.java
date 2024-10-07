package factories;

import exceptions.BrowserNotFoundException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class WebDriverManagerFactory {

    private final String browserName = System.getProperty("browser");
    private final Logger logger = LogManager.getLogger(WebDriverManagerFactory.class);

    public void getWebDriverManager() {
        logger.trace("Invoke of the getWebDriverManager method");
        switch (browserName) {
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                break;
            }
            case "edge": {
                WebDriverManager.edgedriver().setup();
                break;
            }
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                break;
            }
            default:
                logger.trace("Exiting the getWebDriverManager method");
                throw new BrowserNotFoundException(browserName);
        }
        logger.trace("Exiting the getWebDriverManager method");
    }
}
