package com.pageFactory.com;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;


import com.generic.com.BaseTest;

public class SeleniumEasyHomePage {

	private BaseTest objBaseTest;

	public boolean blnFlag = false;

	public SeleniumEasyHomePage(BaseTest baseTest) {
		this.objBaseTest = baseTest;
	}
	
	
	
	By loc_Popup=By.xpath("//a[@id='at-cv-lightbox-close']");

	/**
	 * @Description :Verifying PopUp is Displayed or Not
	 * @Developer : Rushikesh Thakare
	 * @return true/False
	 */
	public boolean isPopUPVisible() {
		
		objBaseTest.getObjWrapperFunctions().setExplicitlyWait(loc_Popup);
		try {
			blnFlag = objBaseTest.driver.findElement(loc_Popup).isDisplayed();
			System.out.println("Pop up is Displayed");
			
			return blnFlag;
		} catch (Exception exception) {
			System.out.println("Not Getting Pop Up" + exception.getMessage());
			return blnFlag;
		}
	}

	/**
	 * @Description :Close PopUp if Displayed
	 * @Developer : Rushikesh Thakare
	 */
	public void closePopUp() {
		objBaseTest.getObjWrapperFunctions().setFluentWait(loc_Popup);
//		objBaseTest.getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		if (this.isPopUPVisible()) {
			System.out.println(" Handling Popup");
			objBaseTest.getObjWrapperFunctions().setFluentWait(loc_Popup);
			objBaseTest.getDriver().findElement(loc_Popup).click();
			System.out.println("Popup got handled");
		} else {
			System.out.println("No popup");
			
		}

	}

	/**
	 * @Description : Click on DropDown
	 * @Developer : Rushikesh Thakare
	 * @param strExpectedWebElement
	 */
	public void getAllDropDownsFields(String strExpectedWebElement) {
//		objBaseTest.getObjWrapperFunctions().setImplicitlyWait(10);
		By locators = By.xpath(
				"//div[@id='navbar-brand-centered']//li[@class='dropdown']/a[@data-toggle='dropdown'][contains(.,'"
						+ strExpectedWebElement + "')]");

		objBaseTest.getObjWrapperFunctions().setFluentWait(locators);
		objBaseTest.getObjWrapperFunctions().checkElementpresenceInDom(locators);
		objBaseTest.getDriver().findElement(locators).click();

	}

	/**
	 * @Description : Select value from DropDown 
	 * @Developer : Rushikesh Thakare
	 * @param strValueOfDropDown
	 */
	public void getvaluesOfDropDown(String strValueOfDropDown) {

		By locaterOFValue = By
				.xpath("//div[@id='navbar-brand-centered']//ul/li/a[text()='" + strValueOfDropDown + "']");


		objBaseTest.getDriver().findElement(locaterOFValue).click();

	}

	/**
	 * @Description : calling Select DropDown And Select value Method using this
	 * @Developer : Rushikesh Thakare
	 * @param strSelectDropDown
	 * @param strSelectValue
	 */
	public void getDropdownAndValues(String strSelectDropDown, String strSelectValue) {

		this.getAllDropDownsFields(strSelectDropDown);
		this.getvaluesOfDropDown(strSelectValue);
	}


}
