package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	@FindBy(xpath = "//*[@id=\"navbarText\"]/ul/li[2]/a")
	@CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath = " //p[contains(text(),'Customers')]")
	@CacheLookup
	WebElement CustoumersMenueLnk;

	@FindBy(xpath = "/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p")
	@CacheLookup
	WebElement CustoumersSubMenueLnk;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}

//	public void clickOnCustMenue() {
//		CustoumersMenueLnk.click();
//	}

	public SearchCustomersPage clickOnSubCustMenue() {
		CustoumersMenueLnk.click();
		CustoumersSubMenueLnk.click();
		return new SearchCustomersPage();
	}

}
