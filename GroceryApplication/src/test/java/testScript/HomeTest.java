package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.Base;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base{
	@Test
	public void verifyLoginWithValidCredential() throws IOException
	{
		
		String userNameValue=ExcelUtility.getStringData(0, 0, "LoginPage");
		String PasswordValue=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameValue);
		loginpage.enterPasswordOnPasswordField(PasswordValue);
		loginpage.loginButtonClick();
		 HomePage homePage= new HomePage(driver);
		 homePage.adminIconClick();
		 homePage.LogOutClick();
}
}