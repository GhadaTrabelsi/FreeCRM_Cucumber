package com.e2etests.automation.step_definitions;

import java.time.Duration;

import com.e2etests.automation.page_objects.DealsPage;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.RandomValue;
import com.e2etests.automation.utils.SelectFromListUtils;
import com.e2etests.automation.utils.SeleniumUtils;
import com.e2etests.automation.utils.Setup;
import com.e2etests.automation.utils.Validations;
import com.e2etests.automation.utils.Wait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DealsStepDefinition {
	public ConfigFileReader configFileReader;
	public SeleniumUtils utils;
	public SelectFromListUtils select;
	public Validations validation;
	public DealsPage dealsPage;
	public SelectFromListUtils selectUtils;
	public Wait wait;

	public DealsStepDefinition() {

		configFileReader = new ConfigFileReader();
		utils = new SeleniumUtils();
		select = new SelectFromListUtils();
		validation = new Validations();
		dealsPage = new DealsPage();
		selectUtils = new SelectFromListUtils();
		wait = new Wait(Setup.getDriver());
	}

	@Given("User is present on Deals Page")
	public void userIsPresentOnDealsPage() {
		wait.forPresenceOfElement(Duration.ofSeconds(20), dealsPage.deals, "deal");
		dealsPage.deals.click();

	}

	@When("User clicks on New Deal button")
	public void userClicksOnNewDealButton() {
		utils.click(dealsPage.createDeal);

	}

	@When("enters {string}, {string}, {string} and {string} and Saves the deal")
	public void entersAndAndSavesTheDeal(String Title, String Description, String Probability, String Amount) {
		utils.writeText(dealsPage.dealTitle, Title + RandomValue.getSaltString());
		utils.writeText(dealsPage.dealDescription, Description);
		utils.writeText(dealsPage.dealProb, Probability);
		utils.writeText(dealsPage.dealAmount, Amount);
		utils.click(dealsPage.saveBtn);

	}

	@Then("deal should be created successfully")
	public void dealShouldBeCreatedSuccessfully() {
		wait.forPresenceOfElement(Duration.ofSeconds(20), dealsPage.dealcreated, "dealcreated");
		validation.isElementDisplayed(dealsPage.dealcreated);
//System.out.println("yes");
	}
	
	
	@When("User selects the Deal to edit and clicks on Edit button")
	public void userSelectsTheDealToEditAndClicksOnEditButton() {
		wait.forPresenceOfElement(Duration.ofSeconds(20),dealsPage.editBtn, "editBtn");

	  utils.click(dealsPage.editBtn); 
	}
	@When("User updates {string} and saves the deal")
	public void userUpdatesAndSavesTheDeal(String commission) {
		utils.clearField(dealsPage.comission);
		utils.writeText(dealsPage.comission, commission);
		Wait.waitUntilClickable(Setup.getDriver(), dealsPage.saveBtn);
	utils.click(dealsPage.saveBtn);
	}
	@Then("Deal should be editted successfully")
	public void dealShouldBeEdittedSuccessfully() {
		wait.forPresenceOfElement(Duration.ofSeconds(20), dealsPage.dealcreated, "dealedited");

		validation.isElementDisplayed(dealsPage.dealcreated);
		//System.out.println("yes");
	   
	}

	

	@Given("Deals exists in CRM application")
	public void dealsExistsInCRMApplication() {
		
		Wait.waitUntilClickable(Setup.getDriver(),dealsPage.deals);
	
       utils.click(dealsPage.deals);	
}
	@When("User selects Deal and deletes the selected Deal")
	public void userSelectsDealAndDeletesTheSelectedDeal() throws InterruptedException {

Thread.sleep(3000);	 
utils.click(dealsPage.deleteBtn);
	 
	
	}
	
	@Then("selected Deal should be deleted successfully")
	public void selectedDealShouldBeDeletedSuccessfully() {
	  validation.assertEquals(dealsPage.confirmMsg,configFileReader.getProperties("confirmMsg"));
		utils.click(dealsPage.DealsDeleteBtn);

	  
	}





}
