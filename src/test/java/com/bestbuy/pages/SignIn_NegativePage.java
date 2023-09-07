package com.bestbuy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bestbuy.utils.Reports;
import com.bestbuy.utils.SelWrappers;

public class SignIn_NegativePage  extends SelWrappers {
	//in valid username and pwd
	@FindBy(xpath="//span[text()='Account']")
	WebElement accClick;
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
	@FindBy(xpath="//div[text()='Oops! The email or password did not match our records. Please try again.']")
	WebElement errormsg;
	@FindBy(xpath="//div[text()='Sorry, something went wrong. Please try again.']")
			WebElement errormsg2;
	
	//valid username and empty field
	@FindBy(xpath="//a[contains(text(),'Return to previous page')]")
	WebElement prevpage;
	@FindBy(xpath="//span[text()='Account']")
	WebElement accClick1;
	@FindBy(xpath="//a[text()='Sign In']")
	WebElement signInclick1;
	@FindBy(xpath="//input[@id='fld-e']")
	WebElement signInmailid1;
	@FindBy(xpath="//span[@class='c-toggle-slider c-toggle-round']")
	WebElement togglebutton1;
	@FindBy(xpath="//input[@id='fld-p1']")
	WebElement signInPwd1;
	@FindBy(xpath="//button[normalize-space()='Sign In']")
	WebElement signIn1;
	@FindBy(xpath="//p[contains(text(),'Please enter your password.')]")
	WebElement eMsg;
	public void SignInWithInvalid(String mailSi,String pwdsi)
	{
		jsClick(accClick);
		click(signInclick);
		typeText(signInmailid,mailSi);
		click(togglebutton);
		typeText(signInPwd,pwdsi);
		if(click(signIn))
			Reports.reportStep("PASS","Signin button clicked");
		else 
			
			Reports.reportStep("FAIL","Problem in sign in button");

		if (errormsg2.isDisplayed()) 
            Reports.reportStep("PASS", "Sign-in with invalid userName and Password passed");
        else 
            Reports.reportStep("FAIL", "Sign-in was successful, but it was expected to fail");

	}
	
	public void signinWithOneemptyField(String mailSi1,String pwdsi1)
	{
		if(click(prevpage))
			Reports.reportStep("PASS","click on the previous page");
		else 
			
			Reports.reportStep("FAIL","Problem in click on the previous page");
		
		
		jsClick(accClick1);
		click(signInclick1);
		typeText(signInmailid1,mailSi1);
		click(togglebutton1);
		typeText(signInPwd,pwdsi1);
		if(click(signIn1))
			Reports.reportStep("PASS","Signin button clicked");
		else 
			
			Reports.reportStep("FAIL","Problem in sign in button");
		
		if (eMsg.isDisplayed()) 
            Reports.reportStep("PASS", "Sign-in with valid userName and empty field Password passed");
        else 
            Reports.reportStep("FAIL", "Sign-in was successful, but it was expected to fail");

	}

}
