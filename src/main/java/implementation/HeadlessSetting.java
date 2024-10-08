package implementation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;


public class HeadlessSetting implements WebDriverSetting {

    private final Logger logger = LogManager.getLogger(HeadlessSetting.class);
    private final String argument = "--headless";

    @Override
    public ChromeOptions setUpChrome() {
        logger.trace("Invoke of the setUpChrome method");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(argument);
        logger.trace("Exiting the setUpChrome method");
        return chromeOptions;
    }

    @Override
    public EdgeOptions setUpEdge() {
        logger.trace("Invoke of the setUpEdge method");
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments(argument);
        logger.trace("Exiting the setUpEdge method");
        return edgeOptions;
    }

    @Override
    public FirefoxOptions setUpFireFox() {
        logger.trace("Invoke of the setUpFireFox method");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments(argument);
        logger.trace("Exiting the setUpFireFox method");
        return firefoxOptions;
    }
}
