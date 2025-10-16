
package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageTest extends Base{

     @Test	
     public void verifyWhetherUserIsAbleToAddNewNews() throws IOException {
    	String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
 		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
 		LoginPage loginpage = new LoginPage(driver);
 		loginpage.enterUserNameOnUserNameField(userNameValue);
 		loginpage.enterPasswordOnPasswordField(passwordValue);
 		loginpage.loginButtonClick();
 		
 		HomePage homePage = new HomePage(driver);
 		homePage.moreInfoManage();
 		
 		ManageNewsPage mnt = new ManageNewsPage(driver);
 		mnt.newBtnClick();
 		mnt.newsTextBoxMsg();
 		mnt.saveBtnClick();
 		
 		boolean newscreatedSuccess =mnt.isNewsCreationSuccessAlertDisplayed();
  		System.out.println(newscreatedSuccess);
  		Assert.assertTrue(newscreatedSuccess,Constant.UnabletoAddNewsError);
    	
  		//boolean successNews = mnt.checkNewsCreationSuccessAlertDisplayed();
		//Assert.assertTrue(successNews, "Unable to add new News");
     }
     
     @Test
     public void verifyWhetherUserIsAbleToSearchAddedNews() throws IOException {
    	String userNameValue = ExcelUtility.getStringData(0, 0, "LoginPage");
  		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
  		LoginPage loginpage = new LoginPage(driver);
  		loginpage.enterUserNameOnUserNameField(userNameValue);
  		loginpage.enterPasswordOnPasswordField(passwordValue);
  		loginpage.loginButtonClick();
  		
  		HomePage homePage = new HomePage(driver);
  		homePage.moreInfoManage();
  		
  		ManageNewsPage mnt = new ManageNewsPage(driver);
  		mnt.searchBtnClick();
  		mnt.searchNewsText();
  		mnt.searchSubmitBtnClick();
  		
  		String expected= "News Today";
  		String actual = mnt.isUserListed();
		Assert.assertEquals(actual,expected,Constant.UnabletoSearchNewsError);
  		
     }
	
	
}
