package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage extends BasePage{
	
	//Page Factory - OR:
	@FindBy(xpath="//input[@id='Email']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Log in')]")
	WebElement loginBtn;
	

	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
//	public boolean validateCRMImage(){
//		return crmLogo.isDisplayed();
//	}
	
	public HomePage login(String un, String pwd){
		username.clear();
		username.sendKeys(un);
		password.clear();
		password.sendKeys(pwd);
		loginBtn.click();
		//loginBtn.click();
//		    	JavascriptExecutor js = (JavascriptExecutor)driver;
//		    	js.executeScript("arguments[0].click();", loginBtn);
		    	
		return new HomePage();
	}
	
}

