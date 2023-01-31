package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class SearchCustomersPage extends BasePage{

	
//	@FindBy(name="client_lookup")
//	WebElement company;
	
	@FindBy(xpath = "/html/body/div[3]/div[1]/form[1]/div/h1")
	WebElement CustLabel;
	
	@FindBy(xpath = "/html/body/div[3]/div[1]/form[1]/div/div/a")
	WebElement AddNewBtn;
	
	@FindBy(id="SearchEmail")
	WebElement searchcustEmail;
	
	@FindBy(id="SearchFirstName")
	WebElement searchFName;
	
	@FindBy(id="SearchLastName")
	WebElement searchLName;
	
	
	@FindBy(xpath="//*[@id=\"search-customers\"]")
	WebElement searchBtn;
	
	
	
	// Initializing the Page Objects:
	public SearchCustomersPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifySCustTitle() {
		return driver.getTitle();
	}
	
	public boolean verifySCustLabel(){
		return CustLabel.isDisplayed();
	}
	
	public AddNewCustPage clickOnAddNewBtn() {
		AddNewBtn.click();
		return new AddNewCustPage();
	}
		public void enterDetailsToSearch(String Semail,String Fname,String Lname) {
			searchcustEmail.sendKeys(Semail);
			searchFName.sendKeys(Fname);
			searchLName.sendKeys(Lname);
			searchBtn.click();
		}
		
		public AddNewCustPage clickOnSubCustMenue() {
			AddNewBtn.click();
			return new AddNewCustPage();
		}
	}	

