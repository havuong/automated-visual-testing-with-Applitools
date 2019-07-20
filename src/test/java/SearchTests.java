import base.BaseTests;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.SearchPage;

public class SearchTests extends BaseTests {
    private SearchPage page = new SearchPage(driver);

    @BeforeClass
    public static void launchApp(){
        driver.get(System.getProperty("site.bookstore.url"));
    }

    @Test
    public void testSearchByFullTitle(){
        String title = "Agile Testing";
        page.search(title);
        eyesManager.validateWindow();
    }
}
