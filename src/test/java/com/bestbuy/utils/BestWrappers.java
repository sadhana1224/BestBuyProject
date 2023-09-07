package com.bestbuy.utils;

import org.openqa.selenium.support.PageFactory;

import com.bestbuy.pages.BBInvalidsearch_NeagtivePage;
import com.bestbuy.pages.BestBuyAddItemsPage;
import com.bestbuy.pages.BestBuyBottomLinkPage;
import com.bestbuy.pages.BestBuyMenuPage;
import com.bestbuy.pages.BestBuySignUpPage;
import com.bestbuy.pages.SignIn_NegativePage;


public class BestWrappers extends SelWrappers {
	SelWrappers se= new SelWrappers();
	
	public void bestSignUp(String fname,String lname,String email,String pwd,String repwd,String phnum,String SigninMail,String siPwd) throws InterruptedException
	{
		
		BestBuySignUpPage bbPage=PageFactory.initElements(driver, BestBuySignUpPage.class);
		bbPage.bestBuySignup(fname, lname, email, pwd, repwd, phnum,SigninMail, siPwd);
			
	}
	public void bestBuyMenuPage()
	{
		
		BestBuyMenuPage bmPage=PageFactory.initElements(driver, BestBuyMenuPage.class);
		bmPage.menunavigation();
	}
	public void bestBuyHomepageBottomLink()
	{
		
		BestBuyBottomLinkPage bmlPage=PageFactory.initElements(driver, BestBuyBottomLinkPage.class);
		bmlPage.bottomLinks();
	}
	public void bestBuyAddItemsToCart(String item1,String codeh,String name,String lname,String city,String street,String code,String email,String num) throws InterruptedException
	{
		
		BestBuyAddItemsPage baPage=PageFactory.initElements(driver, BestBuyAddItemsPage.class);
		baPage.searchAndAddItems(item1,codeh,name,lname,city,street,code,email,num);

	}
	public void dummyPaymentAndPlaceOrder(String cno,String cvvno,String pwdc)
	{
		BestBuyAddItemsPage baPage1=PageFactory.initElements(driver, BestBuyAddItemsPage.class);
		baPage1.dummyPayment(cno,cvvno,pwdc);
	}
	
	//negative test cases
	//1
	public void negativeTc_signIn(String mail,String pwd)
	{
		SignIn_NegativePage naPage=PageFactory.initElements(driver, SignIn_NegativePage.class);
		naPage.SignInWithInvalid(mail, pwd);
	
	}
	public void negativeTc_signIn1(String mail1,String pwd1)
	{
		SignIn_NegativePage naPage1=PageFactory.initElements(driver, SignIn_NegativePage.class);
		naPage1.signinWithOneemptyField(mail1, pwd1);
	
	}
//2
	public void negativeTc_Search(String input)
	{
	BBInvalidsearch_NeagtivePage snaPage=PageFactory.initElements(driver, BBInvalidsearch_NeagtivePage.class);
	snaPage.search_invalidInput(input);
	}
	public void negativeTc_Search1(String input1)
	{
	BBInvalidsearch_NeagtivePage snaPage1=PageFactory.initElements(driver, BBInvalidsearch_NeagtivePage.class);
	snaPage1.search_emptySearch(input1);
	}
}
