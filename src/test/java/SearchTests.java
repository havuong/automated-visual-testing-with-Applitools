import org.junit.Test;
import pages.SearchPage;

public class SearchTests extends BaseTests {
    private SearchPage page = new SearchPage(driver);

    @Test
    public void testSearchByFullTitle() {
        String title = "Agile Testing";
        page.search(title);
        validateWindow();
    }
}
