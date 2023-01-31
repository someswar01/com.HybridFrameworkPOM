package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustPage extends BasePage{

	
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
	
	
	
	// Initializing the Page Objects:
	public AddCustPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyAddCustTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyAddCustLabel(){
		return AddCustLabel.isDisplayed();
	}
	
	public AddNewCustPage clickOnSaveBtn() {
		AddSaveBtn.click();
		return new AddNewCustPage();
	}
		public void enterDetailsToAddCust(String Semail,String pass,String Fname,String Lname) {
			AddcustEmail.sendKeys(Semail);
			AddpwdTextBox.sendKeys(pass);
			AddFNameTextBox.sendKeys(Fname);
			AddLNameTextBox.sendKeys(Lname);
			AddSaveBtn.click();
		}
	}	
