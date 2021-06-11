package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage {

	public static final String URL = "http://thedemosite.co.uk/";

	@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")
	private WebElement addUserLink;

	@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
	private WebElement loginLink;

	@FindBy(xpath = "/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]/big[1]/blockquote[1]/blockquote[1]/font[1]/center[1]/b[1]")
	private WebElement loginStatus;

	public void navUserPage() {
		addUserLink.click();
	}

	public void navLoginPage() {
		loginLink.click();
	}

	public String showLoginStatus() { return loginStatus.getText(); }

}
