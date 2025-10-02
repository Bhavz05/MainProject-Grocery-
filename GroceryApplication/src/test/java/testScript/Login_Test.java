package testScript;

import java.io.IOException;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import utilities.ExcelUtility;

public class Login_Test extends Base{
	@Test
	public void verifyLoginWithValidCredential() throws IOException
	{
		
		String userNameValue=ExcelUtility.getStringData(0, 0, "LoginPage");
		String PasswordValue=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsername(userNameValue);
		loginpage.enterPasswordOnPassword(PasswordValue);
		loginpage.enterLoginButtonCLick();
	}
	@Test
	public void verifyLoginWithvalidUsernameInvalidPassword() throws IOException
	{
		
		String userNameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String PasswordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsername(userNameValue);
		loginpage.enterPasswordOnPassword(PasswordValue);
		loginpage.enterLoginButtonCLick();
		
	}
	@Test
	public void verifyInvalidUsernameValidPassword() throws IOException
	{
		
		String userNameValue=ExcelUtility.getStringData(2, 0, "LoginPage");
		String PasswordValue=ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsername(userNameValue);
		loginpage.enterPasswordOnPassword(PasswordValue);
		loginpage.enterLoginButtonCLick();
		
	}
	@Test
	public void verifyLoginWithInvalidCredentials() throws IOException {
	
		String userNameValue=ExcelUtility.getStringData(3, 0, "LoginPage");
		String PasswordValue=ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsername(userNameValue);
		loginpage.enterPasswordOnPassword(PasswordValue);
		loginpage.enterLoginButtonCLick();
}
}
