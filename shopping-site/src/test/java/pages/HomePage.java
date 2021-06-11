package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    public static String URL = "http://automationpractice.com/index.php";

    @FindBy(id = "search_query_top")
    WebElement search;

    public void searchFor(String str) {
        search.sendKeys(str);
        search.submit();
    }

}
