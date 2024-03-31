package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver driver;
	public HomePage(WebDriver driver)
		{
			this.driver=driver;		
			PageFactory.initElements(driver, this); 
		}
	@FindBy(xpath = "//input[@id='vote-poll-1']")WebElement vote;
    @FindBy(partialLinkText = "REGISTER")WebElement register;
	@FindBy(xpath = "/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")WebElement login;
	@FindBy(xpath = "//label[starts-with(@for,'pollanswe')]//parent::li")WebElement pool;
	@FindBy(xpath = "//input[@id='newsletter-subscribe-button']")WebElement subscribe;
}
