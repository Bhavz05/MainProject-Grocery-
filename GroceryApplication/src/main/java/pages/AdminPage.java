package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {
	public WebDriver driver;
public AdminPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newBtn;
@FindBy(id="username") WebElement username;
@FindBy(id="password") WebElement password;
@FindBy(id="user_type") WebElement userTypeDrpDwn;
@FindBy(xpath="//button[@name='Create']") WebElement saveBtn;
//@FindBy(xpath="//div[contains(@class,'alert-success') and contains(text(),'User Created Successfully')]") WebElement alertmsg;

@FindBy(xpath="//a[@onclick='click_button(2)']") WebElement searchBtn;
@FindBy(id="un") WebElement searchUserName;
@FindBy(id="ut") WebElement searchDrpDwn;
@FindBy(xpath="//button[@value='sr']") WebElement srchBtn;

@FindBy(xpath="//i[@class='ace-icon fa fa-sync-alt']") WebElement resetBtn;

public void newBtnClick()
{
	newBtn.click();
}
public void enterUsernameOnUsernameField()
{
	username.sendKeys("Adminaaaaaa");
}
public void enterPasswordOnPasswordField()
{
	password.sendKeys("johndoe");
}
public void selectDrpDwn()
{
	Select select = new Select(userTypeDrpDwn);
	select.selectByValue("partner");
}
public void saveBtnClick()
{
	saveBtn.click();
}
public String AlertDisplayed()
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement alertBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
	    By.xpath("//div[contains(@class,'alert') and contains(@class,'alert-dismissible')]")
	));
	return alertBox.getText();
}

public void searchBtnClick()
{
	searchBtn.click();
}
public void enterUsernameOnSearchUsernameField()
{
	searchUserName.sendKeys("pla");
}
public void searchDrpDwn()
{
	Select select = new Select(searchDrpDwn);
	select.selectByValue("staff");
}
public void searchUserBtnClick()
{
	srchBtn.click();
}

public void resetBtnClick()
{
	resetBtn.click();
}

public boolean IsresetHappen() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.invisibilityOf(searchUserName));
	return searchUserName.isDisplayed();
}

public String actualURL()
{
	return driver.getCurrentUrl();
}
}
