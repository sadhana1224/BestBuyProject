package com.bestbuy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bestbuy.utils.Reports;
import com.bestbuy.utils.SelWrappers;

public class BBInvalidsearch_NeagtivePage extends SelWrappers {
	@FindBy(xpath="//input[@id='gh-search-input']")
	WebElement search;
	
	@FindBy(xpath="//span[@class='header-search-icon']")
	WebElement sicon;
	
	@FindBy(xpath="//p[contains(text(),'Try a different search term or check out some of our suggestions below.')]")
	WebElement msg;
	
	//empty search
	@FindBy(xpath="//input[@id='gh-search-input']")
	WebElement search1;
	
	@FindBy(xpath="//span[@class='header-search-icon']")
	WebElement sicon1;
	public void search_invalidInput(String input)
	{
		typeText(search,input);
		click(sicon);
		
		if (msg.isDisplayed()) 
            Reports.reportStep("PASS", "Search with invalid input ");
        else 
            Reports.reportStep("FAIL", "Search succesfull");
	}
	
	public void search_emptySearch(String input1)
	{
		navigateBack();
		typeText(search1,input1);
		click(sicon1);
	}

}
