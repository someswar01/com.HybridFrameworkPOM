package pages;
	import java.io.File;
import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class BasePage {
		
		public static WebDriver driver;
		public static Properties configProp;
		public static Logger logger;
		
		public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
		
		
		public static synchronized WebDriver getDriver() {
			return tldriver.get();
		}

//		public  static EventFiringWebDriver e_driver;
//		public static WebEventListener eventListener;
		
		public BasePage(){
			
			//Logging
			logger=Logger.getLogger("nopCommerce Application Hybrid FrameWork");
			PropertyConfigurator.configure("log4j.properties");
			logger.setLevel(Level.DEBUG);
			
			configProp = new Properties();
			 try {
		            FileInputStream ip = new FileInputStream("C:\\Users\\someswar\\Music\\Ayn rand\\Software Center\\My projects\\com.HybridFrameworkPOM\\src\\main\\java\\Configuration\\config.properties");
		            configProp.load(ip);

		        }
		        catch(FileNotFoundException e) {
		            e.printStackTrace();
		        }
		        catch(IOException e) {
		            e.printStackTrace();
		        }
		}
		
		
		public static void initialization() throws IOException{
			
			String browserName = configProp.getProperty("browser");
			
			if(browserName.equals("chrome")){
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(); 
			}
			else if(browserName.equals("FF")){
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(); 
			}
			
			
//			e_driver = new EventFiringWebDriver(driver);
			// Now create object of EventListerHandler to register it with EventFiringWebDriver
//			eventListener = new WebEventListener();
//			e_driver.register(eventListener);
//			driver = e_driver;
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();		
			driver.get(configProp.getProperty("url"));
			logger.info("************* Launching Browser *****************");
			
			
		}

		public String getScreenshot() {
			File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
			File destination = new File(path);
			try {
				FileUtils.copyFile(src, destination);
			} catch (IOException e) {
				System.out.println("Capture Failed " + e.getMessage());
			}
			return path;
		}
		

	}


