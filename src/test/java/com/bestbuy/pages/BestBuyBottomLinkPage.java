package com.bestbuy.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bestbuy.utils.Reports;
import com.bestbuy.utils.SelWrappers;

public class BestBuyBottomLinkPage extends SelWrappers {
	//scroll down to the bottom of the page
	@FindBy(xpath="//a[@class='body-copy-sm mr-200']")
	List<WebElement> bottomlink;
	
	public void bottomLinks()
	{
		jsscrollDownBottom();
		for(WebElement link:bottomlink)
		{
			String url=link.getAttribute("href");
			  try {
		            URL bottomurl = new URL(url);
		            HttpURLConnection connection = (HttpURLConnection) bottomurl.openConnection();
		            connection.setRequestMethod("HEAD");
		            int responseCode=connection.getResponseCode();

		            if (responseCode != HttpURLConnection.HTTP_OK) {
		                System.out.println("The URL '" + url + "' is not validated.");

		            } else {
		                System.out.println("The URL '" + url + "' is validated.");

		            }
		        } catch (IOException e) {
		            System.out.println(e);
		        }
			
		}

		
	}
	

}


