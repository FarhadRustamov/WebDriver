package factories;

import data.Browser;
import exceptions.BrowserNotFoundException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class WebDriverManagerFactory {

    private final String browserName = System.getProperty("browser");
    private final Logger logger = LogManager.getLogger(WebDriverManagerFactory.class);

    public void getWebDriverManager() {
        logger.trace("Invoke of the getWebDriverManager method");
        switch (Browser.valueOf(browserName.toUpperCase())) {
            case CHROME: {
                WebDriverManager.chromedriver().setup();
                break;
            }
            case EDGE: {
                WebDriverManager.edgedriver().setup();
                break;
            }
            case FIREFOX: {
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
