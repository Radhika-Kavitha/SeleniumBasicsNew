package org.selenium.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementCommand 
{
	public void verifySwapLapsUserName()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		WebElement userNameField = driver.findElement(By.id("user-name"));  //username
		userNameField.sendKeys("standard_user");
		WebElement passwordField = driver.findElement(By.id("password"));  //password
		passwordField.sendKeys("secret_sauce");
		WebElement loginButton = driver.findElement(By.id("login-button"));  //loginbutton
		loginButton.click();
		//String tagName =loginButton.getTagName();
		//System.out.println(tagName);
		driver.close();
	}
	public static void main(String[] args) 
	{
		WebElementCommand obj =new WebElementCommand ();
		obj.verifySwapLapsUserName();

	}

}
 