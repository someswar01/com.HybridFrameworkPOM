package testPages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.AddNewCustPage;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchCustomersPage;

public class TestAddCustPage extends BasePage{


	public LoginPage loginPage;
	public HomePage homePage;
	public SearchCustomersPage ScustPage;
	public AddNewCustPage AcustPage;
	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginPage = new LoginPage();
		homePage=new HomePage();
		ScustPage=new SearchCustomersPage();
		AcustPage=new AddNewCustPage();
		
		homePage=loginPage.login(configProp.getProperty("username"), configProp.getProperty("password"));
		ScustPage=homePage.clickOnSubCustMenue();
		AcustPage=ScustPage.clickOnAddNewBtn();
		
	}
	
	@Test(priority=1)
	public void verifyAddCustPageTitle() {
		String title = ScustPage.verifySCustTitle();
		Assert.assertEquals(title, "Customers / nopCommerce administration");
		
	}
	@Test(priority=2)
	public void verifyAddCustPageLabel() {
	 ScustPage.verifySCustLabel();
	}
	
	
	@Test(priority=3)
	@Parameters({"Paemail","Papwd","PaFName","PaLName"})
	public SearchCustomersPage enterDetailsToAddCust(String mail,String pass,String fName,String Lname) {
		AcustPage.enterDetailsToAddNewCust(mail, pass, fName, Lname);
		return new SearchCustomersPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
