package com.bestbuy.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.bestbuy.utils.BestWrappers;
import com.bestbuy.utils.Reports;
import com.bestbuy.utils.SelWrappers;

public class BestBuyMenuTest extends SelWrappers {
	SelWrappers se=new SelWrappers();
	BestWrappers bw=new BestWrappers();
	@Test( groups = {"Positive"})
	public void menuNavigation()
	{
		try
		{
			Reports.setTCDesc("Validating the title page of Menu");
			bw.launchBrowser();
			//bw.brokenLinkBestbuy();
			se.chooseCountry();
		    bw.bestBuyMenuPage();
			Reports.reportStep("PASS", "Title page of Menu passed");

			screenshot("Menu_valid");
		}
		catch(Exception ex)
		{
			Reports.reportStep("FAIL", "Title page of Menu failed");
			ex.printStackTrace();
		}	
	}
	@AfterMethod
	public void closeBrowser()
	{
		
		closeAllBrowsers();
	}
}
