package com.w2a.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class AddCustomerTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void addCustomer(String firstName, String lastName, String postCode) {
		System.out.println("firstname is " + firstName);

		driver.findElement(By.cssSelector(OR.getProperty("AddCustBtn"))).click();
		driver.findElement(By.cssSelector(OR.getProperty("firstname"))).sendKeys(firstName);
		driver.findElement(By.cssSelector(OR.getProperty("lastname"))).sendKeys(lastName);
		driver.findElement(By.cssSelector(OR.getProperty("postcode"))).sendKeys(postCode);
		driver.findElement(By.cssSelector(OR.getProperty("addbtn"))).click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	
		//driver.findElement(By.)
		alert.accept();
	}

}
