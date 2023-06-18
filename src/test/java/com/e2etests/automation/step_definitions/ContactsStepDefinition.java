package com.e2etests.automation.step_definitions;

import java.time.Duration;


import com.e2etests.automation.page_objects.ContactsPage;
import com.e2etests.automation.page_objects.LoginPage;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.RandomValue;
import com.e2etests.automation.utils.SelectFromListUtils;
import com.e2etests.automation.utils.SeleniumUtils;
import com.e2etests.automation.utils.Setup;
import com.e2etests.automation.utils.Validations;
import com.e2etests.automation.utils.Wait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactsStepDefinition {

	public ConfigFileReader configFileReader;
	public SeleniumUtils utils;
	public SelectFromListUtils select;
	public Validations validation;
	public ContactsPage contactsPage;
	public SelectFromListUtils selectUtils;
	public Wait wait;
	public RandomValue randomValue;
	public LoginPage loginPage;

	public ContactsStepDefinition() {

		configFileReader = new ConfigFileReader();
		utils = new SeleniumUtils();
		select = new SelectFromListUtils();
		validation = new Validations();
		contactsPage = new ContactsPage();
		selectUtils = new SelectFromListUtils();
		wait = new Wait(Setup.getDriver());
		randomValue = new RandomValue();
		loginPage = new LoginPage();

	}

	@When("User is on Contacts page")
	public void userIsOnContactsPage() {
		wait.forPresenceOfElement(Duration.ofSeconds(20), contactsPage.contactLink, "Contacts");
		utils.click(contactsPage.contactLink);
	}

	@When("User Click on New Contacts button")
	public void userClickOnNewContactsButton() {
		utils.click(contactsPage.newContactButton);

	}

	@When("enters {string}, {string}, {string} and {string}")
	public void entersAnd(String FirstName, String LastName, String Position, String Department) {
		utils.writeText(contactsPage.firstName, RandomValue.getSaltString() + FirstName);
		utils.writeText(contactsPage.lastName, RandomValue.getSaltString() + LastName);
		utils.writeText(contactsPage.position, Position);
		utils.writeText(contactsPage.department, Department);

	}

	@When("User clicks on Save button")
	public void userClicksOnSaveButton() throws InterruptedException {
		utils.click(contactsPage.contactSaveButton);
		Thread.sleep(2000);
	}

	@Then("Contacts should be saved successfully")
	public void contactsShouldBeSavedSuccessfully() {
		validation.isElementDisplayed(contactsPage.contactSaveCheck);
		System.out.println("yes");
	}

	@When("Contacts exists in CRM application")
	public void contactsExistsInCRMApplication() throws InterruptedException {
		Thread.sleep(3000);
		utils.click(contactsPage.contact);
		// validation.isElementDisplayed(contactsPage.NoRecord);
		Thread.sleep(3000);

		selectUtils.findElementByElementInTable(contactsPage.emailLoc, "@");
		//System.out.println("yes");
	}

	@When("User edits the contacts")
	public void userEditsTheContacts() {
	 Wait.waitUntilClickable(Setup.getDriver(), contactsPage.contactEditButton);

		utils.click(contactsPage.contactEditButton);
	}
	

	@And("Saves the Contact")
	public void savesTheContact() {
		// Thread.sleep(3000);
		wait.forPresenceOfElement(Duration.ofSeconds(20), contactsPage.contactSaveButton, "ui linkedin button");

		utils.click(contactsPage.contactSaveButton);
	}

	@Then("Contact should be edited successfully")
	public void contactShouldBeEditedSuccessfully() {

		validation.isElementDisplayed(contactsPage.selectable);
		System.out.println("yes");

	}

	@When("User selects Contacts to  delete")
	public void userSelectsContactsToDelete()  {
		wait.forPresenceOfElement(Duration.ofSeconds(20), contactsPage.contactLink, "Contacts");
		utils.click(contactsPage.contactLink);		
		Wait.waitUntilClickable(Setup.getDriver(), contactsPage.checkedBtn);
	
       utils.click(contactsPage.checkedBtn);

		wait.forPresenceOfElement(Duration.ofSeconds(20), contactsPage.contactDeleteDropdown, "dropdown icon");
		utils.click(contactsPage.contactDeleteDropdown);
		wait.forPresenceOfElement(Duration.ofSeconds(20), contactsPage.contactDeleteDropdownOption, "Delete");
		utils.click(contactsPage.contactDeleteDropdownOption);
		wait.forPresenceOfElement(Duration.ofSeconds(20), contactsPage.contactDeleteButton, "checkmark icon");
		utils.click(contactsPage.contactDeleteButton);

	}

	@Then("selected contact should be deleted successfully")
	public void selectedContactShouldBeDeletedSuccessfully() throws InterruptedException {
		Thread.sleep(3000);
		validation.assertTrue(contactsPage.confirmMsg, configFileReader.getProperties("confirmation"));
		// System.out.println("yes");
		wait.forPresenceOfElement(Duration.ofSeconds(20), contactsPage.contactDeleteConfirmButton, "Delete");
		utils.click(contactsPage.contactDeleteConfirmButton);

	}

	@When("User search the contact using {string}")
	public void userSearchTheContactUsing(String string) throws InterruptedException {
		wait.forPresenceOfElement(Duration.ofSeconds(20), contactsPage.contactLink, "Contacts");
		utils.click(contactsPage.contactLink);
		utils.click(contactsPage.contactShowFilterButton);
		utils.click(contactsPage.contactSearchField);
		utils.click(contactsPage.contactSearchAllOptions);
		wait.forElementToBeDisplayed(Duration.ofSeconds(20), contactsPage.adressOption, "Address");
		utils.click(contactsPage.adressOption);
		utils.click(contactsPage.contactSearchOperator);
		utils.click(contactsPage.containsOperator);

		utils.click(contactsPage.contactSearchValue);
		utils.writeText(contactsPage.contactSearchValue, configFileReader.getProperties("Adresse"));

		utils.click(contactsPage.contactSearchFilter);
		Thread.sleep(3000);

	}

	@Then("User should see only contacts having matching address")
	public void userShouldSeeOnlyContactsHavingMatchingAddress() throws InterruptedException {
		//wait.forElementToBeDisplayed(Duration.ofSeconds(20), contactsPage.AddressFind, "Address");
Thread.sleep(3000);
		validation.assertTrue(contactsPage.AddressFind,"Ariana, ennasr, Tunisia");
		System.out.println("yes found");
		

	}

	
	@When("User add a column to be displayed in result grid")
	public void userAddAColumnToBeDisplayedInResultGrid() {
		
		wait.forPresenceOfElement(Duration.ofSeconds(20), contactsPage.contactLink, "Contacts");
		utils.click(contactsPage.contactLink);
		wait.forPresenceOfElement(Duration.ofSeconds(20), contactsPage.contactShowFilterButton, "contactShowFilterButton");

		utils.click(contactsPage.contactShowFilterButton);
		wait.forPresenceOfElement(Duration.ofSeconds(20), contactsPage.contactSearchColumnButton, "contactSearchColumnButton");

		utils.click(contactsPage.contactSearchColumnButton);
		wait.forPresenceOfElement(Duration.ofSeconds(20), contactsPage.contactSearchColumnDescr, "contactSearchColumnDescr");

		utils.click(contactsPage.contactSearchColumnDescr);
		wait.forPresenceOfElement(Duration.ofSeconds(20), contactsPage.contactSearchColumnSetButton, "contactSearchColumnSetButton");

		utils.click(contactsPage.contactSearchColumnSetButton);
		 
	}
	
	@Then("Column should be added in result grid")
	public void columnShouldBeAddedInResultGrid() {
		validation.assertTrue(contactsPage.contactSearchColumnsCheck,"Description");	   
	}



}
