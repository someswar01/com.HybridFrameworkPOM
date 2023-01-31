package testPages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchCustomersPage;

public class TestSearchCustPage extends BasePage{

	public LoginPage loginPage;
	public HomePage homePage;
	public SearchCustomersPage ScustPage;
	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginPage = new LoginPage();
		homePage=new HomePage();
		ScustPage=new SearchCustomersPage();
		
		homePage=loginPage.login(configProp.getProperty("username"), configProp.getProperty("password"));
		ScustPage=homePage.clickOnSubCustMenue();
	}
	
	@Test(priority=1)
	public void verifySearchCustPageTitle() {
		String title = ScustPage.verifySCustTitle();
		Assert.assertEquals(title, "Customers / nopCommerce administration");
		
	}
	@Test(priority=2)
	public void verifySearchCustPageLabel() {
	 ScustPage.verifySCustLabel();
	}
	
	
	@Test(priority=3,dataProvider = "data")
	public void enterDetailsToSearchCust(String email,String FName,String LName) {
		ScustPage.enterDetailsToSearch(email,FName,LName);
	}
	
	@DataProvider(name="data")
	public Object[][] getData(){
		Object[][] a=new Object[3][3];
		a[0][0] ="kiyjcycyhjc676008@gmail.com";
		a[0][1]="Virat";
		a[0][2]="Kohli";
		
		a[1][0] ="victoria_victoria@nopCommerce.com";
		a[1][1]="Victoria";
		a[1][2]="Terces";
		
		a[2][0] ="brenda_lindgren@nopCommerce.com";
		a[2][1]="Brenda";
		a[2][2]="Lindgren";
		
		return a;
				
	}
}

