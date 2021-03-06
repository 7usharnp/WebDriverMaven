package com.w2a.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class OpenAccountTest extends TestBase {

	@Test(dataProviderClass=TestUtil.class,dataProvider = "dp")
	public void openAccount(String customer, String currency) throws InterruptedException {

		click("openaccount_CSS");
		select("customer_CSS",customer);
		select("currency_CSS",currency);
		click("process_CSS");
		Thread.sleep(3000);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
	}

	
	
}
