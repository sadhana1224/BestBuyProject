package com.bestbuy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bestbuy.utils.Reports;
import com.bestbuy.utils.SelWrappers;

public class BestBuySignUpPage extends SelWrappers {

	//choose country
	@FindBy(xpath="//div[@class='country-selection']//h4[contains(text(),'United States')]")
	WebElement country;
	//create an account
	@FindBy(xpath="//button[@id='account-menu-account-button']//*[name()='svg']")
	WebElement accountbutton;
	@FindBy(xpath="//a[text()='Create Account']")
	WebElement createacc;
	@FindBy(xpath="//input[@id='firstName']")
	WebElement fristname;
	@FindBy(xpath="//input[@id='lastName']")
	WebElement lastname;
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	@FindBy(xpath="//span[@class='c-toggle-slider c-toggle-round']")
	WebElement toggle;
	@FindBy(xpath="//input[@id='fld-p1']")
	WebElement pwd;
	@FindBy(xpath="//input[@id='reenterPassword']")
	WebElement repwd;
	@FindBy(xpath="//input[@id='phone']")
	WebElement phnum;
	@FindBy(xpath="//button[text()='Create an Account']")
	WebElement clickcreateacc;
	
	//sign in page
	@FindBy(xpath="//button[@id='account-menu-account-button']//*[name()='svg']")
	WebElement accountbutton1;

	@FindBy(xpath="//a[text()='Sign In']")
	WebElement signInclick;
	@FindBy(xpath="//input[@id='fld-e']")
	WebElement signInmailid;
	@FindBy(xpath="//span[@class='c-toggle-slider c-toggle-round']")
	WebElement togglebutton;
	@FindBy(xpath="//input[@id='fld-p1']")
	WebElement signInPwd;
	@FindBy(xpath="//button[normalize-space()='Sign In']")
	WebElement signIn;
	
	
	
		
	public void  bestBuySignup(String fname,String lname,String emailid,String cpwd,String rcpwd,String pNum,String mailSi,String pwdsi) throws InterruptedException
	{
		
		waitForMe(country,5);
		click(country);
		
		waitForMe(accountbutton,20);
		click(accountbutton);
		
		click(createacc);
		typeText(fristname,fname);
		typeText(lastname,lname);
		typeText(email,emailid);
		click(toggle);
		typeText(pwd,cpwd);
		typeText(repwd,rcpwd);
		typeText(phnum,pNum);
		if(click(clickcreateacc))
			Reports.reportStep("PASS","Account Created Successfully, if already exist please signin");
		else 
			
			Reports.reportStep("FAIL","Problem in account creation");
	
		Thread.sleep(2000);
		navigateBack();
		
		click(accountbutton1);
		click(signInclick);
		typeText(signInmailid,mailSi);
		click(togglebutton);
		typeText(signInPwd,pwdsi);
		if(click(signIn))
			Reports.reportStep("PASS","Signin Successfully");
		else 
			
			Reports.reportStep("FAIL","Problem in Sign in");

				
		
		
	        
		
		
	}
}
