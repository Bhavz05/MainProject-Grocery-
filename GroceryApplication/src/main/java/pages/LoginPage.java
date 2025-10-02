package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
public LoginPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
@FindBy(name="username")WebElement username;
@FindBy(name="password")WebElement password;
@FindBy(tagName="button")WebElement login;

public void enterUsernameOnUsername(String userNameValue)
{
	username.sendKeys(userNameValue);
}
public void enterPasswordOnPassword(String PasswordValue)
{
	password.sendKeys(PasswordValue);
}
public void enterLoginButtonCLick()
{
	login.click();

}
}
