package com.w2a.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.w2a.base.TestBase;

public class TestUtil extends TestBase {

	public static String ScreenshotPath;
	public static String ScreenShotName = "error.jpg";

	public static void captureScreenshot() throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + ScreenShotName));
	}

	@DataProvider(name = "dp")
	public Object[][] getData(Method m) {
		String sheetName = m.getName();
		System.out.println("SheetName" + sheetName);
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		System.out.println("columns" + cols);
		System.out.println("rows" + rows);

		Object[][] data = new Object[rows - 1][cols];

		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			for (int colNum = 0; colNum < cols; colNum++) {
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}

		}
		;

		return data;

	}

	public static boolean isTestRunnable(String testName, ExcelReader excel) {

		String sheetName = "test_suite";
		int rows = excel.getRowCount(sheetName);

		for (int rNum = 2; rNum <= rows; rNum++) {

			String testCase = excel.getCellData(sheetName, "TCID", rNum);

			if (testCase.equalsIgnoreCase(testName)) {

				String runmode = excel.getCellData(sheetName, "Runmode", rNum);

				if (runmode.equalsIgnoreCase("Y"))
					return true;
				else
					return false;
			}

		}
		return false;
	}
}
