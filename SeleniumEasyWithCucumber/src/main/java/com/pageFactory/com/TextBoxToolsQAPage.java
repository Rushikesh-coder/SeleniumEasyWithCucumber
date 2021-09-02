package com.pageFactory.com;

import org.openqa.selenium.By;

import com.generic.com.BaseTest;

public class TextBoxToolsQAPage {

	private BaseTest objBasTest;

	public TextBoxToolsQAPage(BaseTest baseTest) {
		this.objBasTest = baseTest;
	}

	public void setUserName(String strUserName) {
		objBasTest.getDriver().findElement(By.xpath("//input[@id='userName']")).clear();
		objBasTest.getDriver().findElement(By.xpath("//input[@id='userName']")).sendKeys(strUserName);
	}

	public void setUserEmailID(String strEmail) {
		objBasTest.getDriver().findElement(By.xpath("//input[@id='userEmail']")).clear();
		objBasTest.getObjWrapperFunctions().setImplicitlyWait(20);
		objBasTest.getDriver().findElement(By.xpath("//input[@id='userEmail']")).sendKeys(strEmail);
	}

	public void selectAddress(String strAddress) {
		objBasTest.getDriver().findElement(By.xpath("//textarea[@id='currentAddress']")).clear();
		objBasTest.getObjWrapperFunctions().setImplicitlyWait(20);
		objBasTest.getDriver().findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys(strAddress);

	}

	public void selectPerAddress(String strPerAddress) {
		objBasTest.getDriver().findElement(By.xpath("//textarea[@id='permanentAddress']")).clear();
		objBasTest.getObjWrapperFunctions().setImplicitlyWait(20);
		objBasTest.getDriver().findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys(strPerAddress);

	}
	
	public void clickOnSubmitButton()
	{
		objBasTest.getObjWrapperFunctions().scrollPage(200);
		objBasTest.getObjWrapperFunctions().setImplicitlyWait(20);
		objBasTest.getDriver().findElement(By.xpath("//button[@id='submit']")).click();
	}

}
