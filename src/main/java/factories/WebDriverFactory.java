package factories;

import enums.Browser;
import exceptions.BrowserNotFoundException;
import exceptions.ModeNotSetException;
import implementation.FullScreenSetting;
import implementation.HeadlessSetting;
import implementation.MaximizedSetting;
import enums.Mode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;


public class WebDriverFactory {

    private final String browserName = System.getProperty("browser");
    private final Logger logger = LogManager.getLogger(WebDriverFactory.class);

    public WebDriver getDriver(Mode mode) {
        logger.trace("Invoke of the getDriver method");
        WebDriver webDriver;
        switch (Browser.valueOf(browserName.toUpperCase())) {
            case CHROME:
                webDriver = new ChromeDriver((ChromeOptions) setModeForBrowser(mode));
                break;
            case EDGE:
                webDriver = new EdgeDriver((EdgeOptions) setModeForBrowser(mode));
                break;
            case FIREFOX:
                webDriver = new FirefoxDriver((FirefoxOptions) setModeForBrowser(mode));
                break;
            default:
                logger.trace("Exiting the getDriver method");
                throw new BrowserNotFoundException(browserName);
        }
        logger.trace("Exiting the getDriver method");
        return webDriver;
    }

    private AbstractDriverOptions setModeForBrowser(Mode mode) {
        logger.trace("Invoke of the setModeForBrowser method");
        AbstractDriverOptions options;
        switch (mode) {
            case HEADLESS:
                options = new HeadlessSetting().configureMode();
                break;
            case MAXIMIZED:
                options = new MaximizedSetting().configureMode();
                break;
            case FULL_SCREEN:
                options = new FullScreenSetting().configureMode();
                break;
            default:
                logger.trace("Exiting the setModeForBrowser method");
                throw new ModeNotSetException(mode);
        }
        logger.trace("Exiting the setModeForBrowser method");
        return options;
    }
}
