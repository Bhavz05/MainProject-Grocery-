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

import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminPage {
	public WebDriver driver;
	WaitUtility wait = new WaitUtility();
	PageUtility pageutilty = new PageUtility();

	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newBtn;
	@FindBy(id = "username")
	WebElement username;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "user_type")
	WebElement userTypeDrpDwn;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveBtn;
//@FindBy(xpath="//div[contains(@class,'alert-success') and contains(text(),'User Created Successfully')]") WebElement alertmsg;

	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchBtn;
	@FindBy(id = "un")
	WebElement searchUserName;
	@FindBy(id = "ut")
	WebElement searchDrpDwn;
	@FindBy(xpath = "//button[@value='sr']")
	WebElement srchBtn;

	@FindBy(xpath = "//i[@class='ace-icon fa fa-sync-alt']")
	WebElement resetBtn;

	// Assertion
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement newAlert;
	@FindBy(xpath = "//tr[1]/td[1]")
	WebElement searchUser;
	// @FindBy(xpath="//table[@class='table table-bordered table-hover
	// table-sm']/tbody/tr[1]/td[1]") WebElement searchUser;

	public AdminPage newBtnClick() {
		newBtn.click();
		return this;
	}

	public AdminPage enterUsernameOnUsernameField(String usernameVal) {
		username.sendKeys(usernameVal);
		return this;
	}

	public AdminPage enterPasswordOnPasswordField(String passwordVal) {
		password.sendKeys(passwordVal);
		return this;
	}

	public AdminPage selectDrpDwn() {
		Select select = new Select(userTypeDrpDwn);
		select.selectByValue("partner");
		pageutilty.selectDropdownWithValue(userTypeDrpDwn, "partner");// pageutility used here
		return this;
	}

	public AdminPage saveBtnClick() {
		saveBtn.click();
		return this;
	}

//Assertion method
	public String AlertDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement alertBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@class,'alert') and contains(@class,'alert-dismissible')]")));
		return alertBox.getText();
	}

	public AdminPage searchBtnClick() {
		searchBtn.click();
		return this;
	}

	public AdminPage enterUsernameOnSearchUsernameField() {
		searchUserName.sendKeys("pla");
		return this;
	}

	public AdminPage searchDrpDwn() {
		Select select = new Select(searchDrpDwn);
		select.selectByValue("staff");
		pageutilty.selectDropdownWithValue(searchDrpDwn, "staff");// pageutility used here
		return this;
	}

	public AdminPage searchUserBtnClick() {
		srchBtn.click();
		return this;
	}

	public AdminPage resetBtnClick() {
		resetBtn.click();
		return this;
	}

//Assertion method
	public boolean IsresetHappen() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(searchUserName));
		return searchUserName.isDisplayed();
	}

	public String actualURL() {
		return driver.getCurrentUrl();// Assertion method
	}

	// Assertion methods
	public String alertDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement alertBox = wait.until(ExpectedConditions.visibilityOfElementLocated( // visibility .. here element?
				By.xpath("//div[contains(@class,'alert') and contains(@class,'alert-dismissible')]") // bcoz alert can
																										// be 'added
																										// successfully'
																										// or 'already
																										// registered'
		));
		return alertBox.getText();

	}

	public String searchTable() {

		wait.waitUntilElementVisible(driver, searchUser); // To avoid assertion failure due to invisiblity of searchUser
															// element
		return searchUser.getText();
	}

}
