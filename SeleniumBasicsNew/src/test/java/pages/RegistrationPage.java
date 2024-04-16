package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.utilities.WebElementUtility;

public class RegistrationPage 
{
	WebDriver driver;
	public RegistrationPage(WebDriver driver)
		{
			this.driver=driver;		
			PageFactory.initElements(driver, this); 
		}
	
	
	@FindBy(xpath = "//input[@id='register-button']")
	WebElement RegisterButton;
	

	public RegistrationConfirmationPage clickOnRegisterButton()
	{
		WebElementUtility.clickOnElement(RegisterButton);
		return new RegistrationConfirmationPage(driver);
	}
}
