package com.pageFactory.com;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.generic.com.BaseTest;

public class TableFilterDemoPage {

	private BaseTest objBaseTest;
	
	public TableFilterDemoPage(BaseTest baseTest)
	{
		this.objBaseTest=baseTest;
	}
	
	By loc_HEaderOfTableFilterPage=By.xpath("//h2[text()='Table Filter Demo']");
	
	
	public void verifyHeaderOfPageIsDisplayed()
	{
		boolean blnFlag=false;
		blnFlag=objBaseTest.getObjWrapperFunctions().checkElementIsDisplayed(loc_HEaderOfTableFilterPage);
		Assert.assertTrue(blnFlag);
	}
	
	public void clickButtonToFilterDetails(String strButtonName)
	{
		By loc_FilterButton=By.xpath("//button[text()='"+strButtonName+"']");
		objBaseTest.getDriver().findElement(loc_FilterButton).click();
	}
}
