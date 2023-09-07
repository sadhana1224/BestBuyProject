package com.bestbuy.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.bestbuy.utils.BestWrappers;
import com.bestbuy.utils.Reports;
import com.bestbuy.utils.SelWrappers;

public class BestBuyAddItemsTest extends SelWrappers {
	SelWrappers se=new SelWrappers();
	BestWrappers bw=new BestWrappers();
	@Test
	public void add_Items_toCart()
	{
		try
		{
			Reports.setTCDesc("Search product and add item to the cart");
			bw.launchBrowser();
			//bw.brokenLinkBestbuy();
			se.chooseCountry();
			bw.bestBuyAddItemsToCart("macbook air 13.6 laptop","99504","sadhana","sadhu","1200 N Muldoon Rd","Albuquerque","99504","sadhanasuba24@test.com","9688741481");
			//bw.dummyPaymentAndPlaceOrder("6543 6454 3854 5454", "123", "One+two=3");
			//Reports.reportStep("PASS", "item added in the cart");

			screenshot("additem1_valid");
		}
		catch(Exception ex)
		{
			Reports.reportStep("FAIL", "item not  added in the cart");
			ex.printStackTrace();
		}	
	}
	@AfterMethod
	public void clossBrowser()
	{
		closeAllBrowsers();
	}
}
