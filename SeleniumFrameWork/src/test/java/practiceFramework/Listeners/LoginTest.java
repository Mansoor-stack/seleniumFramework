package practiceFramework.Listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyTestListener.class)
public class LoginTest {
	
	@Test
	public void loginByEmail(){
		System.out.println("login By Email");
		Assert.assertEquals("Mansoor", "Mansoor");
	}
	@Test
	public void loginByFaceBook() {
		System.out.println("login By FaceBook");
		Assert.assertEquals("Mansoor", "Ahmed");
	}

}
