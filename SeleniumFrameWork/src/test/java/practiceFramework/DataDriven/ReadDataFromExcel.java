package practiceFramework.DataDriven;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import practiceFramework.Driver.DriverFactory;

public class ReadDataFromExcel {
	static WebDriver driver;

	@BeforeTest
	public static void beforeTest() {
		driver = DriverFactory.initDriver();
	}

	@Test
	public static void ReadData() throws Exception {

//		driver.get("http://a.testaddressbook.com/addresses/new");

		FileInputStream file = new FileInputStream(
				"C:\\Users\\MANSOOR...KHAN\\eclipse-workspace\\SeleniumFrameWork\\src\\test\\resources\\TestData\\TestData.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("FormData");
		int rowcount = sheet.getPhysicalNumberOfRows();
		int colcount = sheet.getRow(0).getLastCellNum();

		String[][] data = new String[rowcount - 1][colcount];

		for (int row = 1; row < rowcount; row++) {

			for (int col = 0; col < colcount; col++) {

				String cellvalue = sheet.getRow(row).getCell(col).toString();

				String FirstName = sheet.getRow(row).getCell(col = 0).toString();
				String LastName = sheet.getRow(row).getCell(col = 1).toString();
				String Address1 = sheet.getRow(row).getCell(col = 2).toString();
				String Address2 = sheet.getRow(row).getCell(col = 3).toString();
				String City = sheet.getRow(row).getCell(col = 4).toString();

				System.out.println(FirstName + " " + LastName + " " + Address1 + " " + Address2 + " " + City);
				data[row - 1][col] = cellvalue;

				driver.get("http://a.testaddressbook.com/addresses/new");

				WebElement firstName = driver.findElement(By.id("address_first_name"));
				firstName.sendKeys(FirstName);
				firstName.clear();

				Thread.sleep(5000);

				WebElement lastname = driver.findElement(By.id("address_last_name"));
				lastname.sendKeys(LastName);
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

		}

	}

	@AfterTest
	public static void afterTest() {
//		driver.close();
//		driver.quit();
	}
}
