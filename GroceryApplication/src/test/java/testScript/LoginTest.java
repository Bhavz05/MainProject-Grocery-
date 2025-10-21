package testScript;

import java.io.IOException;
import java.lang.invoke.ConstantBootstraps;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import automationCore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	HomePage homePage;

	@Test(priority = 1, description = "User is try to login with valid credentials", groups = { "smoke" })
	public void verifyWetherUserIsAbleToLoginWithValidCredentials() throws IOException {
		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameValue).enterPasswordOnPasswordField(passwordValue);
		homePage = loginpage.loginButtonClick();

		Boolean dashBoardDisplay = loginpage.isDashboardDisplayed(); // Assert True
		Assert.assertTrue(dashBoardDisplay, Constant.VALIDCREDENTIALERROR); // AssertTrue
	}

	@Test(priority = 2, description = "user is try to login with invalid credentilas", retryAnalyzer = retrymechanism.Retry.class)
	public void verifyWetherUserIsAbleToLoginWithValidUsernameAndInvalidPassword() throws IOException {
		String userNameValue = ExcelUtility.getStringData(11, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameValue).enterPasswordOnPasswordField(passwordValue)
				.loginButtonClick();
		String expected = "7rmart supermarket"; // Assert Equals
		String actual = loginpage.isTitleDisplayed();// A E
		Assert.assertEquals(actual, expected, Constant.VALIDUSERNAMEINVALIDPASSWORDERROR);// A E

	}

	@Test(priority = 3)
	public void verifyWetherUserIsAbleToLoginWithInvalidUsernameAndValidPassword() throws IOException {
		String userNameValue = ExcelUtility.getStringData(2, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameValue).enterPasswordOnPasswordField(passwordValue)
				.loginButtonClick();

		boolean alertBoxDisplayed = loginpage.isAlertboxDisplayed();
		Assert.assertTrue(alertBoxDisplayed, Constant.INVALIDUSERNAMEVALIDPASSWORD);

		/*
		 * String expected ="https://groceryapp.uniqassosiates.com/admin/login";
		 * //Assert Equals with URL check String actual=loginpage.actualURL();
		 * Assert.assertEquals(actual,
		 * expected,"user is able to login with invalid credentials");
		 */
	}

	@Test(priority = 4, groups = { "smoke" }, dataProvider = "loginProvider")
	public void verifyWetherUserIsAbleToLoginWithInvalidUsernameAndInvalidPassword(String userNameValue,
			String passwordValue) throws IOException {
		// String userNameValue = ExcelUtility.getStringData(3, 0, "LoginPage");
		// String passwordValue = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameValue).enterPasswordOnPasswordField(passwordValue)
				.loginButtonClick();

		Boolean alertboxDisplay = loginpage.isAlertboxDisplayed(); // assertFalse
		System.out.println(alertboxDisplay);
		Assert.assertFalse(!alertboxDisplay, Constant.INUSERNAMEINPASSWORD); // ! = NOT, here false
	}

	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
				// new Object[] {ExcelUtility.getStringData(3,
				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};
	}
}
