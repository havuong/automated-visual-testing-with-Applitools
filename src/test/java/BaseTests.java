import com.applitools.eyes.selenium.Eyes;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SearchPage;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class BaseTests {

    protected static WebDriver driver;
    protected static SearchPage page;
    protected static Eyes eyes;

    @BeforeClass
    public static void setUp() {
        Properties props = System.getProperties();
        try {
            props.load(new FileInputStream(new File("./src/main/resources/test.properties")));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        initiateEyes();

        driver.get(System.getProperty("site.url"));
        page = new SearchPage(driver);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
        eyes.abort();
    }

    private static void initiateEyes() {
        eyes = new Eyes();
        eyes.setApiKey(System.getProperty("applitools.api.key"));
    }

    public void validateWindow() {
        eyes.open(driver, "Automation Bookstore",
                Thread.currentThread().getStackTrace()[2].getMethodName());
        eyes.checkWindow();
        eyes.close();
    }
}