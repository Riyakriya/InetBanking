package com.inetbanking.testCases;


	
	import java.io.IOException;

	import org.testng.Assert;
	import org.testng.annotations.Test;
	import com.inetbanking.pageObjects.AddCustomerPage;
	import com.inetbanking.pageObjects.LoginPage;

	public class TC_AddCustomerTest_003 extends BaseClass {
		
		
		@Test
		public void addNewCustomer() throws InterruptedException, IOException
		{
			logger.info("url opened");
			LoginPage lp=new LoginPage(driver);
			lp.setUserName(username);
			logger.info("Entered username");
			lp.setPassword(password);
			logger.info("Entered password");
			lp.clickSubmit();
			Thread.sleep(3000);
			
			AddCustomerPage addcust=new AddCustomerPage(driver);
			addcust.clickAddNewCustomer(); 
			logger.info("providing customer details....");
			addcust.custName("Greg");
			addcust.custgender("male");
			addcust.custdob("11","10","1986");
			Thread.sleep(5000);
			addcust.custaddress("INDIA");
			addcust.custcity("VIZ");
			addcust.custstate("AP");
			addcust.custpinno("5000074");
			addcust.custtelephoneno("976890011");
			
			
				
			String email = randomestring() + "@gmail.com";
			addcust.custemailid(email);
			addcust.custpassword("abcdef");
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
				captureScreen(driver,"addNewCustomer");
				Assert.assertTrue(false);
			}
				
		}

		
			
	}


