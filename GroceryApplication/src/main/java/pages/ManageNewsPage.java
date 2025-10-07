package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ManageNewsPage {
public WebDriver driver;
public ManageNewsPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newButton; 
@FindBy(id="news")WebElement newsTextBox; 
@FindBy(xpath="//button[@type='submit']")WebElement saveBtn;
@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement searchBtn;
@FindBy(xpath="//input[@type='text']")WebElement searchText;
@FindBy(xpath="//button[@type='submit']")WebElement searchSubmitBtn;

//Assertion
@FindBy(xpath = "//div[contains(@class, 'alert-success')]")WebElement newsCreationSuccessMsg;
@FindBy(xpath = "//tr[1]/td[1]")WebElement searchResultTable;


public void newBtnClick() {
	newButton.click();
}

public void newsTextBoxMsg() {
	newsTextBox.sendKeys("News Today");
}
public void saveBtnClick() {
	saveBtn.click();
}

public void searchBtnClick() {
	searchBtn.click();
}

public void searchNewsText() {
	searchText.sendKeys("News Today");
}

public void searchSubmitBtnClick() {
	searchSubmitBtn.click();
}

//Assertion
public boolean isNewsCreationSuccessAlertDisplayed() {
	return newsCreationSuccessMsg.isDisplayed();
}
public String isUserListed() {
	return searchResultTable.getText();
}

}