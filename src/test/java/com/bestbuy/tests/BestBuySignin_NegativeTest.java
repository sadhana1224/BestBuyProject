package com.bestbuy.tests;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

import com.bestbuy.utils.BestWrappers;
import com.bestbuy.utils.Reports;
import com.bestbuy.utils.SelWrappers;

public class BestBuySignin_NegativeTest extends SelWrappers {
	SelWrappers se=new SelWrappers();
	BestWrappers bw=new BestWrappers();

	@DataProvider(name="signIn_invalidCredentials")
	public Object[][] readDataExcel() throws IOException
	{
		Object[][] data=null;
		XSSFWorkbook workbook=null;
		try
		{
			workbook= new XSSFWorkbook(System.getProperty("user.dir")+"/bestbuy.xlsx");	
			//workbook= new XSSFWorkbook(new FileInputStream("C:\\Users\\Guest User\\OneDrive\\Desktop\\bestbuy.xlsx"));
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
	@Test(dataProvider="signIn_invalidCredentials")
	public void signIn_invalidCredentials(String mailId,String pwd) throws InterruptedException
	{
		try
		{
		Reports.setTCDesc("Sign in with invalid Credentials");
		bw.launchBrowser();
		//bw.brokenLinkBestbuy();
		se.chooseCountry();
		bw.negativeTc_signIn(mailId,pwd);
		screenshot("invalidSignin");
		Reports.setTCDesc("Sign in with valid username and empty field Password");
		//bw.negativeTc_signIn1("sadhanasuba24@test.com","");
		screenshot("emptypwd");
		}
		catch(Exception ex)
		{
			
			ex.printStackTrace();
		}	
		finally
		{
			Thread.sleep(2000);
		 closeAllBrowsers();
		}
	}
}
