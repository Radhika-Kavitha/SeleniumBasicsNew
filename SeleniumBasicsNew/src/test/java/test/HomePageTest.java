package test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.constants.Constants;
import org.selenium.constants.Messages;
import org.selenium.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import listeners.RetryAnalyzer;

public class HomePageTest extends Base
 {
	@Test(priority=1,groups= {"Regression","Smoke"}, retryAnalyzer = RetryAnalyzer.class)
  	public void verifyHomePageTitle() throws IOException 
		{
			String actualTitle = driver.getTitle();
			String data = ExcelUtility.stringDataRead(0, 0, Constants.HOME_PAGE_DATA)+"123";
			Assert.assertEquals(actualTitle, data, Messages.TITLE_MESSAGES);
		}
	
	@Test(priority=2,groups="Sanity")
	public void verifyCommunityPollSelection() throws IOException
		{
			List<WebElement> communityPoll = driver.findElements(By.xpath("//label[starts-with(@for,'pollans')]//parent::li"));
			for(int i=0;i<communityPoll.size();i++)
				{
					//System.out.println(communityPoll.get(i).getText());
					String pollOptionsText = communityPoll.get(i).getText();
					String data = ExcelUtility.stringDataRead(0, 2, Constants.HOME_PAGE_DATA);
					if(pollOptionsText.equals(data))
						{
							communityPoll.get(i).click();
							String actualPoll = pollOptionsText;
							Assert.assertEquals(actualPoll, data, Messages.OPTION_MESSAGES);
						}
				}
		}
 }
