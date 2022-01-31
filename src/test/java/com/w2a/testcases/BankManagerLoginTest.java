package com.w2a.testcases;

import org.testng.Reporter; 
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;



public class BankManagerLoginTest extends TestBase {
	@Test
	public void LoginAsBankManager() throws InterruptedException {
		
		
		driver.findElement(By.cssSelector(OR.getProperty("bmlBtn_CSS"))).click();
		Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("AddCustBtn"))),"condition failed");
		//Assert.fail();
		
	}

}
