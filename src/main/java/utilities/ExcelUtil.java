package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public static Workbook book;
	public static Sheet sheet;

	public static String TESTDATA_SHEET_PATH = "path to excel";

	public static Object[][] getTestData(String sheetName) {

		try {
			FileInputStream ip = new FileInputStream(TESTDATA_SHEET_PATH);
			book = WorkbookFactory.create(ip);
			sheet = book.getSheet(sheetName);

			Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				}
			}
			return data;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
//DataDriven Code by pavan sir by using xutils refer
//	@DataProvider(name="LoginData")
//	String [][] getData() throws IOException
//	{
//		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
//		
//		int rownum=XLUtils.getRowCount(path, "Sheet1");
//		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
//		
//		String logindata[][]=new String[rownum][colcount];
//		
//		for(int i=1;i<=rownum;i++)
//		{
//			for(int j=0;j<colcount;j++)
//			{
//				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
//			}
//				
//		}
//	return logindata;
//	}

}
