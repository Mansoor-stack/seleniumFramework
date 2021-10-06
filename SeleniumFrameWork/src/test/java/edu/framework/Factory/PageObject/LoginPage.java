package edu.framework.Factory.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	By HomeSignIn = By.id("sign-in");
	By EmailId = By.name("session[email]");
	By Passowrd = By.id("session_password");
	By Sign_In_Click = By.name("commit");

	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	public void HomeSignIn() {

		driver.findElement(HomeSignIn).click();
	}

	public void enterEmailId(String UserEmailId) {
		driver.findElement(EmailId).sendKeys(UserEmailId);

	}

	public void enterPassword(String userPassword) {

		driver.findElement(Passowrd).sendKeys(userPassword);

	}

	public void clickSignIn() {
		driver.findElement(Sign_In_Click).click();

	}



}
