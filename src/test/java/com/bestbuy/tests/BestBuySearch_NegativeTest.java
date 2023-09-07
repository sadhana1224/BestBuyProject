package com.bestbuy.tests;

import org.testng.annotations.Test;

import com.bestbuy.utils.BestWrappers;
import com.bestbuy.utils.Reports;
import com.bestbuy.utils.SelWrappers;

public class BestBuySearch_NegativeTest extends SelWrappers {
	SelWrappers se=new SelWrappers();
	BestWrappers bw=new BestWrappers();
	
	@Test
	
	public void signIn_invalidCredentials()
	{
		try
		{
		Reports.setTCDesc("Search with  invalid Credentials");
		bw.launchBrowser();
	//	bw.brokenLinkBestbuy();
		se.chooseCountry();
		bw.negativeTc_Search("fhgjhdfjgdf");
		screenshot("invalidSearch");
		Reports.setTCDesc("Search with  Empty ");
       bw.negativeTc_Search1("");
       screenshot("emptySearch");
		}
		catch(Exception ex)
		{
			
			ex.printStackTrace();
		}	
		finally
		{
			 closeAllBrowsers();
		}
	}
}