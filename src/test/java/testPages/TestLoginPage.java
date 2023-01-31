package testPages;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import utilities.TestUtils;

public class TestLoginPage extends BasePage {
	LoginPage loginPage;
	HomePage homePage;
	TestUtils tu;
//	Logger logger;

	public TestLoginPage() {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginPage = new LoginPage();

	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Your store. Login");
		logger.info("************* LoginPage Title Verified *****************");

	}

//	@Test(priority = 2, dataProvider = "loginData", dataProviderClass = TestUtils.class)
//	public void loginTest(String email, String password) throws Exception {
//		homePage = loginPage.login(email, password);
//		String title = homePage.verifyHomePageTitle();
//		// Assert.assertEquals(title, "Dashboard / nopCommerce administration");
//
//		if (title.contains("Dashboard / nopCommerce administration")) {
//			System.out.println("pass");
//			logger.info("*** HomePage Title Verified when entered correct login credentials passed ***");
//		} else {
//
//			TestUtils.takeScreenshotAtFaild();
//			logger.info("*** Take screen shots captured when entered correct login credentials faild ***");
//		}
//	}
	
	@Test(priority=2,dataProvider="data")
	public void loginTest(String email, String password) throws Exception {
		homePage = loginPage.login(email, password);
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title,"Dashboard / nopCommerce administration");
	}
	
	@DataProvider(name="data")
	public Object[][] getData(){
		Object[][] a=new Object[3][2];
		a[0][0] ="admin@yourstore.com";
		a[0][1]="admin";
		
		a[1][0] ="somesh@yourstore.com";
		a[1][1]="admin2";
		
		a[2][0] ="admin@yourstore.com";
		a[2][1]="admin2";
		return a;
				
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
