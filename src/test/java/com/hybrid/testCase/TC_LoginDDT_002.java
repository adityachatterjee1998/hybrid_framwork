package com.hybrid.testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hybrid.pageObject.LoginPage;
import com.hybrid.utilities.XLUtils;


public class TC_LoginDDT_002 extends BaseClass{
	@Test(dataProvider="LoginData")
	public void loginDDT(String user , String pwd) throws InterruptedException{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("password provided");

		lp.clickSubmit();
		logger.info("click on submit button");
		Thread.sleep(4000);

		if(isAlertPresent()==true) { 
			driver.switchTo().alert().accept();//close alart
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failded");
			Thread.sleep(4000);
		}
		else {
			Assert.assertTrue(true);
			logger.info("login passed");
			Thread.sleep(4000);

			lp.clicklogout();
			driver.switchTo().alert().accept(); //log out alart
			driver.switchTo().defaultContent();
		}
		}
	
	public boolean isAlertPresent()   // user define method create to check alart is present //
	{   
		try {
			driver.switchTo().alert();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		
		String path ="C:\\Users\\adity\\eclipse-workspace\\Hybrid_Framwork\\src\\test\\java\\com\\hybrid\\testData\\New Microsoft Excel Worksheet1.xlsx";
	     int rownum=XLUtils.getRowCount(path,"Sheet1");
	     int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
	     
	     String loginData[][]=new String [rownum][colcount];
		
	     for(int i=1 ;i<=rownum;i++ ) 
	     {
	    	 for(int j=0;j<colcount;j++)
	    	 {
	    		loginData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i,j); 
	    	 }
	     }
	     return loginData;
	}

}
