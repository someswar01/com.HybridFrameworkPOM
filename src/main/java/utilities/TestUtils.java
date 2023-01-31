package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import pages.BasePage;

public class TestUtils extends BasePage{


		public static long PAGE_LOAD_TIMEOUT = 20;
		public static long IMPLICIT_WAIT = 20;
		
		@DataProvider(name= "loginData")
		public String[][] getData() throws Exception {
			
			File excelFile = new File("C:\\Users\\someswar\\Desktop\\logindata.xlsx");
			System.out.println(excelFile.exists());
			FileInputStream fis=new FileInputStream(excelFile);
			
			
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet= workbook.getSheet("Sheet1");
			int noOfRows=sheet.getPhysicalNumberOfRows();
			int noOfCols=sheet.getLastRowNum();
			
			String[][] data = new String[noOfRows-1][noOfCols];
			for(int i =0;i<noOfRows-1;i++) {
				for(int j=0;j<noOfCols;j++) {
					DataFormatter df= new DataFormatter();
					data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
				}
				System.out.println();
			}
				

			
			workbook.close();
			fis.close();
			
			return data;
			}
		
		public void switchToAlert() {
			driver.switchTo().alert();
		}
		
		

		public static void takeScreenshotAtFaild() throws IOException {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String currentDir = System.getProperty("user.dir");
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		}

		public static String randomestring(){
			String generatedString1 = RandomStringUtils.randomAlphabetic(5);
			return (generatedString1);
		}
}
