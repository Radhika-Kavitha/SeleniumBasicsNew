package org.selenium.core;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WebElementCommandsHW
{
	public void verifyDemoTourRegistration()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		WebElement register = driver.findElement(By.partialLinkText("REGISTER"));  
		register.click();
			//Actions at = new Actions(driver);
			//at.sendKeys(Keys.PAGE_DOWN).build().perform();
		WebElement firstNameField = driver.findElement(By.name("firstName"));  
		firstNameField.sendKeys("Name");
		WebElement lastNameField = driver.findElement(By.name("lastName"));  
		lastNameField.sendKeys("Name");
		WebElement phoneField = driver.findElement(By.name("phone"));  
		phoneField.sendKeys("1234567890");
		WebElement emailField = driver.findElement(By.id("userName"));  
		emailField.sendKeys("name123@gmail.com");
		WebElement addressField = driver.findElement(By.name("address1"));  
		addressField.sendKeys("XYZ Street1");
		WebElement cityField = driver.findElement(By.name("city"));  
		cityField.sendKeys("Citygh");
		WebElement stateField = driver.findElement(By.name("state"));  
		stateField.sendKeys("Stateio");
		WebElement postCodeField = driver.findElement(By.name("postalCode"));  
		postCodeField.sendKeys("690456");
		WebElement userNameField = driver.findElement(By.id("email"));  
		userNameField.sendKeys("Shop");
		WebElement passwordField = driver.findElement(By.name("password"));  
		passwordField.sendKeys("ship123");
		WebElement cnpasswordField = driver.findElement(By.name("confirmPassword"));  
		cnpasswordField.sendKeys("ship123");
		//WebElement submitButton = driver.findElement(By.name("submit"));  
		//submitButton.click();
		//driver.close();
	}
	
	public void validateDemoWebShopUserLogin()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		WebElement loginLink = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
		loginLink.click();
		WebElement emailField = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
		emailField.sendKeys("radhikaanilkumar1997@gmail.com");
		WebElement passwdField = driver.findElement(By.xpath("//*[@id=\"Password\"]"));
		passwdField.sendKeys("Ship@123");
		WebElement loginButton = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input"));
		loginButton.click();
		driver.close();
	}
	public void validateYourDestination()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		WebElement yourDestinationLink = driver.findElement(By.linkText("your destination"));
		yourDestinationLink.click();
	}
	public void validateYourDestinationPartialLink()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		WebElement yourDestinationPartialLink = driver.findElement(By.partialLinkText("destination"));
		yourDestinationPartialLink.click();
		//driver.close();
	}
	public void validateTotalNumberOfTagsInTheApplcation()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		List<WebElement> inputName = driver.findElements(By.tagName("input"));
		int numberOfTags = inputName.size();
		System.out.println(numberOfTags);
		driver.close();
	}
	public void validateDemoWebShopUserLoginByCSS()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		WebElement loginLink = driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.header > div.header-links-wrapper > div.header-links > ul > li:nth-child(2) > a"));
		loginLink.click();
		WebElement emailField = driver.findElement(By.cssSelector("#Email"));
		emailField.sendKeys("radhikaanilkumar1997@gmail.com");
		WebElement passwdField = driver.findElement(By.cssSelector("#Password"));
		passwdField.sendKeys("Ship@123");
		WebElement loginButton = driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.center-2 > div > div.page-body > div.customer-blocks > div.returning-wrapper > div.form-fields > form > div.buttons > input"));
		loginButton.click();
		//driver.close();
	}
	public void verifyIsSelected()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/register");
		driver.manage().window().maximize();
		WebElement radioButtonFemale =	driver.findElement(By.xpath("//input[@id='gender-female']"));
		boolean isFemaleSelected= radioButtonFemale.isSelected();
		System.out.println("female element before click: "+isFemaleSelected);
		radioButtonFemale.click();
		boolean isFemaleAfterClickSelected= radioButtonFemale.isSelected();
		System.out.println("female element after click: "+isFemaleAfterClickSelected);
		driver.close();
	}
	public void verifyIsEnabled()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		WebElement subscribeButton =	driver.findElement(By.xpath("//input[@id='newsletter-subscribe-button']"));
		boolean isSubscribeEnabled= subscribeButton.isEnabled();
		System.out.println("Subscribe element before click: "+isSubscribeEnabled);
		subscribeButton.click();
		boolean isSubscribeEnabledAfterClick= subscribeButton.isEnabled();
		System.out.println("female element after click: "+isSubscribeEnabledAfterClick);
		//driver.close();
	}
	public void verifyIsDisplayed()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		WebElement voteButton =	driver.findElement(By.xpath("//input[@id='vote-poll-1']"));
		boolean isVoteDisplayed= voteButton.isDisplayed();
		System.out.println("Vote element before click: "+isVoteDisplayed);
		voteButton.click();
		boolean isVoteDisplayedAfterClick= voteButton.isDisplayed();
		System.out.println("Vote element after click: "+isVoteDisplayedAfterClick);
		driver.close();
	}
	public static void main(String[] args) 
	{
		WebElementCommandsHW dtr = new WebElementCommandsHW();
		//dtr.verifyDemoTourRegistration();
		//dtr.validateDemoWebShopUserLogin();
		//dtr.validateYourDestination();
		//dtr.validateYourDestinationPartialLink();
		//dtr.validateTotalNumberOfTagsInTheApplcation();
		//dtr.validateDemoWebShopUserLoginByCSS();
		//dtr.verifyIsSelected();
		//dtr.verifyIsEnabled();
		dtr.verifyIsDisplayed();
	}
}
