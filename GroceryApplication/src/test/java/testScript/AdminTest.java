package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constant;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminTest extends Base {
	HomePage homepage;
	AdminPage adminPage;

	@Test
	public void verifyUserIsAbleToAddNewUser() throws IOException {
		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver).enterUserNameOnUserNameField(userNameValue)
				.enterPasswordOnPasswordField(passwordValue);
		homepage = login.loginButtonClick();

		adminPage = homepage.moreInfoLinkClick();

		// AdminPage admin = new AdminPage(driver);

		RandomDataUtility random = new RandomDataUtility();
		String usernameVal = random.createRandomUserName();
		String passwordVal = random.createRandomPassword();

		adminPage.newBtnClick();
		adminPage.enterUsernameOnUsernameField(usernameVal).enterPasswordOnPasswordField(passwordVal).selectDrpDwn()
				.saveBtnClick();

		// Assertion

		// String expected= "×\r\n"+ "Alert!\r\n"+ "User Created Successfully";
		String actual = adminPage.AlertDisplayed();
		// System.out.println(admin.AlertDisplayed());
		Assert.assertTrue(actual.contains("User Created Successfully"), "Constant.ADMINTESTADDNEWUSER");

	}

	@Test
	public void verifyUserIsAbleToSearchUser() throws IOException {
		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(userNameValue).enterPasswordOnPasswordField(passwordValue);
		homepage = login.loginButtonClick();

		adminPage = homepage.moreInfoLinkClick();

		// AdminPage admin = new AdminPage(driver);

		adminPage.searchBtnClick().enterUsernameOnSearchUsernameField().searchDrpDwn().searchUserBtnClick();

		// Assertion
		// String
		// expected="https://groceryapp.uniqassosiates.com/admin/user/index?un=&ut=&Search=sr";
		String actual = adminPage.actualURL();
		System.out.println(actual);
		boolean val = actual.contains("Search=sr");
		System.out.println(val);
		Assert.assertTrue(val, Constant.USERABLETOSEARCH);
	}

	@Test
	public void verifyUserIsAbleToReset() throws IOException {
		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(userNameValue).enterPasswordOnPasswordField(passwordValue);
		homepage = login.loginButtonClick();

		adminPage = homepage.moreInfoLinkClick();

		// AdminPage admin = new AdminPage(driver);

		adminPage.searchBtnClick().enterUsernameOnSearchUsernameField().resetBtnClick();

		// Assertion

		Boolean resetHappened = adminPage.IsresetHappen();
		System.out.println(resetHappened);
		Assert.assertFalse(resetHappened, Constant.USERISABLETORESET);
	}

}
