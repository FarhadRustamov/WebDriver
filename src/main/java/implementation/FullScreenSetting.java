package implementation;

import enums.Browser;
import exceptions.ModeNotConfiguredException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;


public class FullScreenSetting implements WebDriverSetting {

    private final String browserName = System.getProperty("browser");
    private final Logger logger = LogManager.getLogger(FullScreenSetting.class);

    @Override
    public AbstractDriverOptions configureMode() {
        logger.trace("Invoke of the configureMode method");
        AbstractDriverOptions options;
        String argument = "--start-fullscreen";
        switch (Browser.valueOf(browserName.toUpperCase())) {
            case CHROME:
                options = new ChromeOptions().addArguments(argument);
                break;
            case EDGE:
                options = new EdgeOptions().addArguments(argument);
                break;
            case FIREFOX:
                options = new FirefoxOptions().addArguments(argument);
                break;
            default:
                logger.trace("Exiting the configureMode method");
                throw new ModeNotConfiguredException();
        }
        logger.trace("Exiting the configureMode method");
        return options;
    }
}
