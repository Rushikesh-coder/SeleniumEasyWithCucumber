package com.stepDefinnition;

import java.util.List;
import java.util.Map;

import com.generic.com.BaseTest;
import com.pageFactory.com.TextBoxToolsQAPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinetionToolsQA extends BaseTest {

	public TextBoxToolsQAPage objTextBoxToolsQAPage;

	private String testData = "";

	public StepDefinetionToolsQA() {
		objTextBoxToolsQAPage = new TextBoxToolsQAPage(this);
	}

	@Given("go to {string} website")
	public void go_to_website(String string) {
		this.initilizeWebEnvirnment();
	}

	@When("user see Tex Box demo page")
	public void user_see_tex_box_demo_page() {
		System.out.println("TextBox is viible");
	}

	@Then("Enter complet details of the user")
	public void enter_complet_details_of_the_user(DataTable testDataInput) {

		List<Map<String, String>> inputText = testDataInput.asMaps(String.class, String.class);

		for (int intIndex = 0; intIndex < inputText.size(); intIndex++) {

			testData = inputText.get(intIndex).get("UserName");

			if (!testData.equals("")) {
				objTextBoxToolsQAPage.setUserName(testData);
			}

			testData = inputText.get(intIndex).get("EmailID");
			if (!testData.equals("")) {
				objTextBoxToolsQAPage.setUserEmailID(testData);
			}

			testData = inputText.get(intIndex).get("CurrentAddress");
			if (!testData.equals("")) {
				objTextBoxToolsQAPage.selectAddress(testData);
			}

			testData = inputText.get(intIndex).get("PermAddress");
			if (!testData.equals("")) {
				objTextBoxToolsQAPage.selectPerAddress(testData);
			}

			objTextBoxToolsQAPage.clickOnSubmitButton();
		}
	}
}
