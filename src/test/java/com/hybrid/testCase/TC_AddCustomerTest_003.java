package com.hybrid.testCase;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hybrid.pageObject.AddCustomerPage;
import com.hybrid.pageObject.LoginPage;

//import com.inetbanking.pageObjects.AddCustomerPage;
//import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("providing customer details....");
		
		
		addcust.custName("Pavan");
		Thread.sleep(1000);
		addcust.custgender("male");
		Thread.sleep(1000);

		addcust.custdob("10","15","1985");
		Thread.sleep(1000);

		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		Thread.sleep(1000);

		addcust.custcity("HYD");
		Thread.sleep(1000);

		addcust.custstate("AP");
		Thread.sleep(1000);

		addcust.custpinno("5000074");
		Thread.sleep(1000);

		addcust.custtelephoneno("987890091");
		Thread.sleep(1000);

		
		String email=randomestring()+"@gmail.com";
		Thread.sleep(1000);

		addcust.custemailid(email);
		Thread.sleep(1000);

		addcust.custpassword("abcdef");
		Thread.sleep(1000);

		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
		
			
	}
	public String randomestring() {
		String  gen =RandomStringUtils.randomAlphabetic(9);
		return gen;
		
	}
	
	
}
