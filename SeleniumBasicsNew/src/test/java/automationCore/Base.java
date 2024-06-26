package automationCore;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Base 
{
	public WebDriver driver;  
	public void initializeBrowser(String browser)  
	{
		if(browser.equals("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equals("Edge"))
		{
			driver = new EdgeDriver();
		}
		else if(browser.equals("Firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			throw new RuntimeException("Invalid browser received");
		}
		driver.manage().window().maximize();
	}
	
	@BeforeMethod(alwaysRun = true)
	@Parameters({"browser", "baseurl"})
	public void setUp(String browsername, String url)
	//public void setUp()
	{
		initializeBrowser(browsername);
		driver.get(url);
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			takeScreenShot(result);
		}
		
		driver.close();
	}
	
	public void takeScreenShot(ITestResult result) throws IOException
	{
		TakesScreenshot takesScreenShot = (TakesScreenshot) driver;
		File screenShot = takesScreenShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShot, new File("./ScreenShots/"+result.getName()+".png"));
	}
}
