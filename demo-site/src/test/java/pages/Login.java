package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {

	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")
	WebElement uName;

	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")
	WebElement pWord;

	@FindBy(name = "FormsButton2")
	WebElement login;


	public void loginInfo(String username, String password) {
		uName.sendKeys(username);
		pWord.sendKeys(password);
		login.click();
	}
}
