package factories;

import data.Browser;
import exceptions.BrowserNotFoundException;
import implementation.FullScreenSetting;
import implementation.HeadlessSetting;
import implementation.MaximizedSetting;
import data.Mode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebDriverFactory {

    private final String browserName = System.getProperty("browser");
    private final Logger logger = LogManager.getLogger(WebDriverFactory.class);

    public WebDriver getDriver(Mode mode) {
        logger.trace("Invoke of the getDriver method");
        WebDriver webDriver = null;
        switch (Browser.valueOf(browserName.toUpperCase())) {
            case CHROME: {
                switch (mode) {
                    case HEADLESS:
                        webDriver = new ChromeDriver(new HeadlessSetting().setUpChrome());
                        break;
                    case FULL_SCREEN:
                        webDriver = new ChromeDriver(new FullScreenSetting().setUpChrome());
                        break;
                    case MAXIMIZED:
                        webDriver = new ChromeDriver(new MaximizedSetting().setUpChrome());
                        break;
                }
            }
            break;
            case EDGE: {
                switch (mode) {
                    case HEADLESS:
                        webDriver = new EdgeDriver(new HeadlessSetting().setUpEdge());
                        break;
                    case FULL_SCREEN:
                        webDriver = new EdgeDriver(new FullScreenSetting().setUpEdge());
                        break;
                    case MAXIMIZED:
                        webDriver = new EdgeDriver(new MaximizedSetting().setUpEdge());
                        break;
                }
            }
            break;
            case FIREFOX: {
                switch (mode) {
                    case HEADLESS:
                        webDriver = new FirefoxDriver(new HeadlessSetting().setUpFireFox());
                        break;
                    case FULL_SCREEN:
                        webDriver = new FirefoxDriver(new FullScreenSetting().setUpFireFox());
                        break;
                    case MAXIMIZED:
                        webDriver = new FirefoxDriver(new MaximizedSetting().setUpFireFox());
                        break;
                }
            }
            break;
            default:
                logger.trace("Exiting the getDriver method");
                throw new BrowserNotFoundException(browserName);
        }
        logger.trace("Exiting the getDriver method");
        return webDriver;
    }
}
