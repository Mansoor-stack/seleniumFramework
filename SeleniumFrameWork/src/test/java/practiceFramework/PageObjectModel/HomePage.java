package practiceFramework.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
	this.driver = driver;
	}

	By AddressesLink = By.linkText("Addresses");
	
	public void AdddressesLink() {
		
		driver.findElement(AddressesLink).click();;
	}
}
