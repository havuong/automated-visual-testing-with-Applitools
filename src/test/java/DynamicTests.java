import com.applitools.eyes.MatchLevel;
import org.junit.Test;
import pages.SearchPage;

public class DynamicTests extends BaseTests {
    private SearchPage page = new SearchPage(driver);

    @Test
    public void testDynamicContent(){
        eyes.open(driver, "The Internet", Thread.currentThread().getStackTrace()[2].getMethodName());
        eyes.setMatchLevel(MatchLevel.LAYOUT); // use to verify dynamic content
        eyes.checkWindow(); // instructs Eyes to take a screenshot of the current page
        eyes.close();
    }
}
