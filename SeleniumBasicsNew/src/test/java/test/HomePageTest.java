package test;

import java.io.IOException;

import org.selenium.constants.Constants;
import org.selenium.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;

public class HomePageTest extends Base
 {
	@Test
  	public void verifyHomePageTitle() throws IOException 
		{
			String actualTitle = driver.getTitle();
			String data = ExcelUtility.stringDataRead(0, 0, Constants.HOME_PAGE_DATA);
			Assert.assertEquals(actualTitle, data, "Title is invalid");
			
		}
	
	@Test
	public void verifyCommunityPollSelection()
		{
		
		}
 }
