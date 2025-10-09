package automationCore;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ScreenshotUtility;

public class Base {
	public WebDriver driver;
	@BeforeMethod(alwaysRun=true)
	@Parameters("browsers")
	public void initialiZEBrowser(String browsers)
	{
		if(browsers.equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(browsers.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
		}
		else if(browsers.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver()
			.clearResolutionCache()
		    .forceDownload()
		    .setup();
			driver=new EdgeDriver();
		}
		
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		}
	@AfterMethod(alwaysRun=true)
	public void driverQuit(ITestResult iTestResult) throws IOException {

		if (iTestResult.getStatus() == ITestResult.FAILURE) {

		ScreenshotUtility screenShot = new ScreenshotUtility();
		screenShot.getScreenshot(driver, iTestResult.getName());
		}
		//driver.quit();

		} 

}
 
