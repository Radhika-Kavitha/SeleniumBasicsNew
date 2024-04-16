package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.utilities.WebElementUtility;

public class RegistrationConfirmationPage 
{
	WebDriver driver;
	public RegistrationConfirmationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//a[@class='account'])[1]")
	WebElement homeEmail;
	
	public String userGetText()
	{
		String text = WebElementUtility.getText(homeEmail);
		return text;
	}
}
