package org.selenium.core;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
public class EdgeBrowserLaunch 
{
	public static void main(String[] args) 
	{
		WebDriver driver = new EdgeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
		driver.close();
		//driver.quit();
	}
}
