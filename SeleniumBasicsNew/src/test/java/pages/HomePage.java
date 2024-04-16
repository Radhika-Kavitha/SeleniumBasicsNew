package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.utilities.WebElementUtility;

public class HomePage 
{
	WebDriver driver;
	public HomePage(WebDriver driver)
		{
			this.driver=driver;		
			PageFactory.initElements(driver, this); 
		}
	@FindBy(xpath= "//a[text()='Log in']") 
	WebElement loginLink;
	@FindBy(xpath= "//a[text()='Register']") 
	WebElement registerLink;
	public LoginPage clickOnLoginMenu()
	{
		WebElementUtility.clickOnElement(loginLink);
		return new LoginPage(driver);
	}
	public RegistrationPage clickOnRegisterMenu()
	{
		WebElementUtility.clickOnElement(registerLink);
		return new RegistrationPage(driver);
	}
}
