package com.bestbuy.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.bestbuy.pages.BestBuyBottomLinkPage;
import com.bestbuy.utils.BestWrappers;
import com.bestbuy.utils.Reports;
import com.bestbuy.utils.SelWrappers;

public class BestBuyBottomPageTest extends SelWrappers {
	SelWrappers se=new SelWrappers();
	BestWrappers bw=new BestWrappers();
	BestBuyBottomLinkPage bl=new BestBuyBottomLinkPage();
	@Test
	public void bottomLinkValidation()
	{
		try
		{
			Reports.setTCDesc("Validating the Home Page Bottom Links");
			bw.launchBrowser();
			se.chooseCountry();
			//bl.bottomLinks();
		   bw.bestBuyHomepageBottomLink();
			screenshot("BottomLink_valid");
		}
		catch(Exception ex)
		{
			Reports.reportStep("FAIL", "Home Page Bottom Links not Validated");
			ex.printStackTrace();
		}	
	}
	@AfterMethod
	public void closeBrowser()
	{
		
		closeAllBrowsers();
	}
}
