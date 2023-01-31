package testPages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.SearchCustomersPage;
import pages.HomePage;
import pages.LoginPage;

public class TestHomePage extends BasePage {
	LoginPage loginPage;
	HomePage homePage;
	SearchCustomersPage ScustPage;
	

	public TestHomePage() {
		super();
	}

	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case -- close the browser

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		// testUtil = new TestUtil();
		ScustPage = new SearchCustomersPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(configProp.getProperty("username"),configProp.getProperty("password"));
//		custPage=homePage.clickOnSubCustMenue();
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Dashboard / nopCommerce administration");
		logger.info("*** HomePage Title Verified ***");

	}

	@Test(priority = 2)
	public void verifyHPUserNameTest() {
		
		Assert.assertTrue(homePage.verifyCorrectUserName());
		logger.info("*** HomePage username Verified ***");

	}

	@Test(priority = 3)
	public void ClickOnContaactsLinkAnnEnter() {
		
		ScustPage=homePage.clickOnSubCustMenue();
		String title =driver.getTitle();
		Assert.assertEquals(title, "Customers / nopCommerce administration");
		logger.info("*** shift from HomePage to search contact page ***");

		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
