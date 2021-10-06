package practiceFramework.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import practiceFramework.Driver.DriverFactory;
import practiceFramework.Listeners.MyTestListener;

@Listeners(MyTestListener.class)
public class PageObjectModelTest {

	WebDriver driver;

	@BeforeMethod
	public void beforeTest() {
		driver = DriverFactory.initDriver();

	}

	@Test(priority =1)
	public void LoginPageTest() {

		driver.get("http://a.testaddressbook.com/");
		

		LoginPage loginPage = new LoginPage(driver);
		loginPage.HomeSignIn();
		loginPage.Email("mansoorahmed2214@gmail.com");
		loginPage.Password("Ma@1998.");
		loginPage.SignIn();

	}

	@Test(priority =2)
	public void HomePage() {
		driver.get("http://a.testaddressbook.com/");
		HomePage homePage = new HomePage(driver);
		homePage.AdddressesLink();

	}

	@AfterTest
	public void afterTest() {
//		driver.close();
//		driver.quit();
	}

}
