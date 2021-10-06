package edu.framework.Factory.DataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadExcelDataUsingDataProvider {
	WebDriver driver;

	@BeforeTest
	public void setup() {
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("debuggerAddress", "localhost:2214");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	}

	/*@Test(dataProvider = "ExcelData")
	public void Test(String FirstName, String lastName, String Address1, String Address2, String City) throws InterruptedException {
		
		driver.get("http://a.testaddressbook.com/addresses/new");

		WebElement firstName = driver.findElement(By.id("address_first_name"));
		firstName.sendKeys(FirstName);
		firstName.clear();
		
		Thread.sleep(5000);

		WebElement lastname = driver.findElement(By.id("address_last_name"));
		lastname.sendKeys(lastName);
		lastname.clear();
		Thread.sleep(5000);
		
		WebElement address1 = driver.findElement(By.id("address_street_address"));
		address1.sendKeys(Address1);
		address1.clear();
		Thread.sleep(5000);
		
		WebElement address2 = driver.findElement(By.id("address_secondary_address"));
		address2.sendKeys(Address2);
		address1.clear();
		Thread.sleep(5000);
		
		
		WebElement city = driver.findElement(By.id("address_city"));
		city.sendKeys(City);
		city.clear();
		Thread.sleep(5000);
		

	}
*/
//	@DataProvider(name = "ExcelData")
	
	public Object[][] dataProvider() throws IOException {
		Object[][] arrdata = getExcelProvider();

		return arrdata;

	}

	public String[][] getExcelProvider() throws IOException {
		String data[][] = null;

		File FileLocation = new File("C:\\Users\\MANSOOR...KHAN\\eclipse-workspace\\SeleniumFrameWork\\src\\test\\resources\\TestData\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(FileLocation);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("FormData");
		int row_count = sheet.getPhysicalNumberOfRows();
		int col_count = sheet.getRow(0).getLastCellNum();
		data = new String[row_count - 1][col_count];
		for (int i = 1; i < row_count; i++) {
			XSSFRow current_row = sheet.getRow(i);
			for (int j = 0; j < col_count; j++) {
				String cell_value = current_row.getCell(j).getStringCellValue();
				data[i - 1][j] = cell_value;
			}

		}

		return data;

	}

	public static void main(String[] args) throws IOException {
		ReadExcelDataUsingDataProvider obj = new ReadExcelDataUsingDataProvider();
		String [][] exceldata = (String[][])obj.getExcelProvider();
		System.out.println(Arrays.toString(exceldata));
//		for (Object[] arr : exceldata) {
//			String [] str = (String[]) arr;
//			System.out.println(Arrays.toString(str));
		
//	};
	}
	
	@AfterTest
	public void AfterTest() {
//		driver.close();
//		driver.quit();

	}

}
