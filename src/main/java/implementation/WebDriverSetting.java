package implementation;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;


public interface WebDriverSetting {
    ChromeOptions setUpChrome();

    EdgeOptions setUpEdge();

    FirefoxOptions setUpFireFox();
}
