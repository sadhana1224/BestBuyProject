package com.bestbuy.tests;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bestbuy.utils.BestWrappers;
import com.bestbuy.utils.SelWrappers;
import com.bestbuy.utils.Reports;

public class BestBuySignupTest extends SelWrappers {
	SelWrappers se=new SelWrappers();
	BestWrappers bw=new BestWrappers();

	@DataProvider(name="signIn_validCredentials")
	public Object[][] readDataExcel() throws IOException
	{
		Object[][] data=null;
		XSSFWorkbook workbook=null;
		try
		{
			workbook= new XSSFWorkbook(System.getProperty("user.dir")+"/bestbuypos.xlsx");	
			XSSFSheet sheet= workbook.getSheet("testdata");
			XSSFRow row= sheet.getRow(0);
			
			int noOfRows=sheet.getPhysicalNumberOfRows();
			
			int noOfCells= row.getPhysicalNumberOfCells();
			
			data= new Object[noOfRows-1][noOfCells]; //data[5][2]
			
			for(int i=1; i<noOfRows;i++)
			{
				for(int j=0; j<noOfCells;j++)
				{
					String cellValue=sheet.getRow(i).getCell(j).getStringCellValue();
					data[i-1][j]=cellValue; 
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			workbook.close();
		}
		
		return data;
	}
	@Test(dataProvider="signIn_validCredentials")
	public void signUpPage(String mailId,String pwd)
	{
		try
		{
			Reports.setTCDesc("Validating the Browser Launch");
			bw.launchBrowser();
			Reports.setTCDesc("Validating SignUp functionality with valid credentials");
		   bw.brokenLinkBestbuy();
			bw.bestSignUp("sadhu","logesh","sadhanasuba24@test.com","One+two=3","One+two=3","8532498732",mailId,pwd);
			screenshot("signup_valid");
		}
		catch(Exception ex)
		{
			Reports.reportStep("FAIL", "SignUp failed");
			ex.printStackTrace();
		}	
	}
	@AfterMethod
	public void closeBrowsers()
	{
		closeAllBrowsers();
	}
	

}
