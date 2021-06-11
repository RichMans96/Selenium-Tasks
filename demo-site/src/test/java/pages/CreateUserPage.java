package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUserPage {

	@FindBy(name = "username")
	WebElement uName;

	@FindBy(name = "password")
	WebElement pWord;

	@FindBy(name = "FormsButton2")
	WebElement save;

	public void createUser(String username, String password) {
		uName.sendKeys(username);
		pWord.sendKeys(password);
		save.click();
	}
}
