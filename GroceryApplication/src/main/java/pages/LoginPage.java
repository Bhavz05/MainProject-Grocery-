package pages; 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	public WebDriver driver;
	WaitUtility wait= new WaitUtility();
public LoginPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}

@FindBy(name="username")WebElement username;
@FindBy(name="password")WebElement password;
@FindBy(xpath= "//button[text()='Sign In']")WebElement loginBtn; // or @FindBy(tagName="button")WebElement loginBtn; 

@FindBy(xpath="//p[text()='Dashboard']")WebElement dashBoard;//Assert True
@FindBy(xpath="//b[text()='7rmart supermarket']")WebElement loginTitle;//AssertEquals
@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement alertbox;// Assert False(WE of Invalid alert)

public void enterUserNameOnUserNameField(String userNameValue) {
	username.sendKeys(userNameValue);
}

public void enterPasswordOnPasswordField(String passwordValue) {
	password.sendKeys(passwordValue);
}

public void loginButtonClick() {
	wait.waitUntilElementToBeClickable(driver, loginBtn);//wait applied
	loginBtn.click();
}

public boolean isDashboardDisplayed() { //Assert True
	
	return dashBoard.isDisplayed();
}

public String isTitleDisplayed() { //Assert Equals
	return loginTitle.getText();
}

public boolean isAlertboxDisplayed() { //Assert False
	return alertbox.isDisplayed();
}

public String actualURL()    // AssertEquals using URL check
{
	return driver.getCurrentUrl(); 
}
}
