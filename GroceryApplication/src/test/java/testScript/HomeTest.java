package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	HomePage homePage;
	@Test
	public void verifyLoginWithValidCredential() throws IOException {

		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String PasswordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameValue).enterPasswordOnPasswordField(PasswordValue);
		homePage= loginpage.loginButtonClick();
		
		homePage.adminIconClick();
		loginpage=homePage.LogOutClick();
		
		String expected= "https://groceryapp.uniqassosiates.com/admin/login"; //Assertion
		String actual= loginpage.actualURL();
		System.out.println(actual);
		Assert.assertEquals(actual, expected, Constant.HOMEVALIDCREDENTIAL);
	}
}