package testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.base.Utf8;

import base.TestBase;
import utility.Utility;


public class HomePage extends TestBase {


	@Test
	public void HomePageTest () throws IOException {
		//Cancel the login pop up
		driver.findElement(By.xpath(Utility.fetchLocator("CancelButton_XPATH"))).click();
		//Click career tab
		driver.findElement(By.xpath(Utility.fetchLocator("CareerPage_XPATH"))).click();
		//T  category dropdown and select full time
		Select category = new Select(driver.findElement(By.name(Utility.fetchLocator("Category_NAME"))));
		category.selectByVisibleText("Full Time");	
		//Locatin drpdown and select Lagos
		Select location = new Select(	driver.findElement(By.name(Utility.fetchLocator("Category_LOCATION"))));
		location.selectByVisibleText("Lagos");
		System.out.println("clicked");
		driver.findElement(By.xpath(Utility.fetchLocator("SubmitBtn_XPATH"))).click();
		//T validate the actual search result corresponds to the anticipated result
		String expecTedResult = "Automation QA Engineer";
		String searchResult = driver.findElement(By.xpath(Utility.fetchLocator("searchResult_XPATH"))).getText();
		Assert.assertEquals(searchResult,expecTedResult);
		
		
		System.out.println("career page clicked successfully");
	}
}


