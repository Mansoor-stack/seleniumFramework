package practiceFramework.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	 WebDriver driver;

	By HomeSignIn = By.xpath("/html/body/nav/div/div[1]/a[2]");
	By Email = By.id("session_email");
	By Password = By.id("session_password");
	By SignIn = By.name("commit");
	
	public LoginPage(WebDriver driver) { // whenever the test class tries to create object of login page class constructor is called and driver is passed to local variable 
		this.driver=driver;
	}

	public  void HomeSignIn() {
		driver.findElement(HomeSignIn).click();
	}

	public  void Email(String mail) {
		driver.findElement(Email).sendKeys(mail);

	}

	public  void Password(String Pswrd) {
		driver.findElement(Password).sendKeys(Pswrd);

	}

	public  void SignIn() {
		driver.findElement(SignIn).click();

	}

}
