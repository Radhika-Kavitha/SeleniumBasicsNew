package org.selenium.utilities;

import java.util.List;

import org.openqa.selenium.WebElement;

public class AppUtility 
{
	public static boolean selectValueFromRadioButton(List<WebElement> values, String valueToSelect )
	{
		boolean status = false;
		for(WebElement value : values)
		{
			String text = value.getText();
				if(text.equals(valueToSelect))
				{
					value.click();
					status = WebElementUtility.isElementSelected(value);
					break;
				}
		}
		return status;
	}
}
