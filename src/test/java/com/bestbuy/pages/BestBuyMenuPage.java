package com.bestbuy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bestbuy.utils.Reports;
import com.bestbuy.utils.SelWrappers;

public class BestBuyMenuPage extends SelWrappers {
	
	
	//top deal title
	@FindBy(xpath="//a[text()='Top Deals']")
	WebElement topdeal;
	@FindBy(xpath="//a[text()='Deal of the Day']")
	WebElement dealOD;
	
	
	public void menunavigation()
	{
	
	
				
		click(topdeal);
		String expectedTitle="Top Deals";
		//Assert.assertTrue(driver.getTitle().equals(expectedTitle));
		//Assert.assertEquals(driver.getTitle(),expectedTitle);
		if(driver.getTitle().startsWith(expectedTitle))
		{
			System.out.println("title is validated");
			Reports.reportStep("PASS","Top Deal title is validated successfully");
		}
		else
		{
			System.out.println("title is not validated");
			Reports.reportStep("FAIL","Problem in validating the Top Deal title");
		}

		driver.navigate().back();
		
		click(dealOD);
		expectedTitle="Deal";
		if(driver.getTitle().startsWith(expectedTitle))
		{
			System.out.println("title is validated");
			Reports.reportStep("PASS","Deal of the day  title is validated successfully");
		}
		else
		{
			System.out.println("title is not validated");
			Reports.reportStep("FAIL","Deal of the day  title is not validated successfully");
		}

		
	}

}

