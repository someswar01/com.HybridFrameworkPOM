package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

public class AddNewCustPage extends BasePage{

//	@FindBy(name="client_lookup")
//	WebElement company;
	
	@FindBy(xpath = "/html/body/div[3]/div[1]/form/div[1]/h1/text()")
	WebElement AddCustLabel;
	
	@FindBy(xpath = "/html/body/div[3]/div[1]/form/div[1]/div/button[1]")
	WebElement AddSaveBtn;
	
	@FindBy(id="Email")
	WebElement AddcustEmail;
	
	@FindBy(id="Password")
	WebElement AddpwdTextBox;
	
	@FindBy(id="FirstName")
	WebElement AddFNameTextBox;
	
	@FindBy(id="LastName")
	WebElement AddLNameTextBox;
	
	//Actions
	// Initializing the Page Objects:
	public AddNewCustPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyAddNewCustPageTitle() {
		return driver.getTitle();
	}
	
	public boolean VerifyAddNewCustPageLabel() {
		return AddCustLabel.isDisplayed();
	}
	
//	public AddNewCustPage clickOnSaveBtn() {
//		AddSaveBtn.click();
//		return new AddNewCustPage();
//	}
	
	
	public void enterDetailsToAddNewCust(String Aemail, String psw,String AFname,String ALname) {
		AddcustEmail.sendKeys(Aemail);
		AddpwdTextBox.sendKeys(psw);
		AddFNameTextBox.sendKeys(AFname);
		AddLNameTextBox.sendKeys(ALname);

		AddSaveBtn.click();
	
}
}