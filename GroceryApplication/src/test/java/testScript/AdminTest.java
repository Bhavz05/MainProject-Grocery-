package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminTest extends Base {
	@Test
	public void verifyUserIsAbleToAddNewUser() throws IOException
	{
		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login= new LoginPage(driver);
		login.enterUserNameOnUserNameField(userNameValue);
		login.enterPasswordOnPasswordField(passwordValue);
		login.loginButtonClick();
		HomePage home= new HomePage(driver);
		home.moreInfoLinkClick();
		AdminPage admin= new AdminPage(driver);
		admin.newBtnClick();
		admin.enterUsernameOnUsernameField();
		admin.enterPasswordOnPasswordField();
		admin.selectDrpDwn();
		admin.saveBtnClick();
		//String expected= "×\r\n"+ "Alert!\r\n"+ "User Created Successfully";
		String actual= admin.AlertDisplayed();
		//System.out.println(admin.AlertDisplayed());
		Assert.assertTrue(actual.contains("User Created Successfully"),"User not added successfully");
		
	}
	@Test
	public void verifyUserIsAbleToSearchUser() throws IOException
	{
		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login= new LoginPage(driver);
		login.enterUserNameOnUserNameField(userNameValue);
		login.enterPasswordOnPasswordField(passwordValue);
		login.loginButtonClick();
		HomePage home= new HomePage(driver);
		home.moreInfoLinkClick();
		AdminPage admin= new AdminPage(driver);
		admin.searchBtnClick();
		admin.enterUsernameOnSearchUsernameField();
		admin.searchDrpDwn();
		admin.searchUserBtnClick();
		//String expected="https://groceryapp.uniqassosiates.com/admin/user/index?un=&ut=&Search=sr";
		String actual= admin.actualURL();
		System.out.println(actual);
		boolean val= actual.contains("Search=sr");
		System.out.println(val);
		Assert.assertTrue(val,"search not happened");
	}
	@Test
	public void verifyUserIsAbleToReset() throws IOException
	{
		String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login= new LoginPage(driver);
		login.enterUserNameOnUserNameField(userNameValue);
		login.enterPasswordOnPasswordField(passwordValue);
		login.loginButtonClick();
		HomePage home= new HomePage(driver);
		home.moreInfoLinkClick();
		AdminPage admin= new AdminPage(driver);
		admin.searchBtnClick();
		admin.enterUsernameOnSearchUsernameField();
		admin.resetBtnClick();
		Boolean resetHappened= admin.IsresetHappen();
		System.out.println(resetHappened);
		Assert.assertFalse(resetHappened,"reset has not happened");
	}

}


