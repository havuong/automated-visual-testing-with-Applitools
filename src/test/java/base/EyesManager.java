package base;

import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EyesManager {
    private Eyes eyes;
    private String appName;
    private WebDriver driver;

    public EyesManager(WebDriver driver, String appName) {
        this.driver = driver;
        this.appName = appName;

        eyes = new Eyes();
        eyes.setApiKey(System.getProperty("applitools.api.key"));
    }

    public void validateWindow() {
        // lets Eyes know that you are ready to begin visual checks
        eyes.open(driver, appName, Thread.currentThread().getStackTrace()[2].getMethodName());
//        eyes.setMatchLevel(MatchLevel.EXACT); // pixel by pixel comparison of the images. It's highly flaky and unreliable.
//        eyes.setMatchLevel(MatchLevel.STRICT); // by default. Using AI to compare the images and only detect things that the human eye would
//        eyes.setMatchLevel(MatchLevel.CONTENT); // similar to this Strict match level except that it also ignores color differences
        eyes.checkWindow(); // instructs Eyes to take a screenshot of the current page
        eyes.close(); // instructs Eyes to aggregate all visual checks and end the session
    }

    public void validateElement(By locator) {
        eyes.open(driver, appName, Thread.currentThread().getStackTrace()[2].getMethodName());
        eyes.checkElement(locator);
        eyes.close();
    }

    public void abort() {
        eyes.abort(); // command serves as a backup plan just in case a test does not shut down the session properly
    }

    public Eyes getEyes() {
        return eyes;
    }
}
