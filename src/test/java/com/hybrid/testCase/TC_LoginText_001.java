package com.hybrid.testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hybrid.pageObject.LoginPage;

public class TC_LoginText_001 extends BaseClass {
	@Test
	public void loginTest() throws InterruptedException, IOException 
	{
		

		 logger.info("Url is open");
		

		driver.manage().window().maximize();
		
		LoginPage lp = new LoginPage(driver);
		
		
		lp.setUserName(username);
		logger.info("Enter user name ");
		
		lp.setPassword(password);
		logger.info("Enter Password ");
		
		Thread.sleep(5000);
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			//captureScreen(driver,"loginTest");
			Assert.assertTrue(true);
			
			logger.info("Login test passed");
			Thread.sleep(2000);
		}
		else
		{ 
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
			Thread.sleep(2000);
		}
	}
	

}
