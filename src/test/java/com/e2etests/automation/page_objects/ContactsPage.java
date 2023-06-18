package com.e2etests.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.Setup;

public class ContactsPage {
	
	public ConfigFileReader configFileReader;
	public ContactsPage contactsPage;

	/* Retrieve Element */

	

	
	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Contacts']")
	public  WebElement contactLink;
	@FindBy(how = How.XPATH, using = "//a[@href='/contacts/new']")
	public  WebElement newContactButton;
	@FindBy(how = How.XPATH, using = "//input[@name='first_name']")
	public  WebElement firstName;
	@FindBy(how = How.XPATH, using = "//input[@name='last_name']")
	public  WebElement lastName;
	@FindBy(how = How.XPATH, using = "//input[@name='position']")
	public  WebElement position;
	@FindBy(how = How.XPATH, using = "//input[@name='department']")
	public  WebElement department;
	
	
	@FindBy(how = How.XPATH, using = "//button[@class='ui linkedin button']")
	public  WebElement contactSaveButton;
	@FindBy(how = How.XPATH, using = "//*[@id='dashboard-toolbar']/div[1]")
	public  WebElement contactSaveCheck;
	@FindBy(how = How.XPATH, using = "//p[normalize-space()='No records found']")
	public  WebElement NoRecord;
	@FindBy(how = How.XPATH, using = "//i[@class='users icon']")
	public  WebElement contact;
	@FindBy(how = How.XPATH, using = "//tbody/tr[1]/td[2]")
	public  WebElement emailLoc;
	


	@FindBy(how = How.XPATH, using = "//i[@class='edit icon']")
	public  WebElement contactEditButton;
	@FindBy(how = How.XPATH, using = "//span[@class='selectable ']")
	public  WebElement selectable;
	
	@FindBy(how = How.XPATH, using = "\"//textarea[@name='description']")
	public  WebElement contactDescription;
	@FindBy(how = How.XPATH, using = "//input[@name='city']")
	public  WebElement contactCity;
	@FindBy(how = How.XPATH, using = "//*[@id='ui']/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div/div[6]/div[2]/div/span/p")
	public  WebElement contactDescriptionCheck;
	
	@FindBy(how = How.XPATH, using = "//div[@name='action']")
	public  WebElement contactDeleteDropdown;
	@FindBy(how = How.XPATH, using = "//div[@class='active selected item']")
	public  WebElement contactDeleteDropdownOption;
	@FindBy(how = How.XPATH, using = "//i[@class='checkmark icon']")
	public  WebElement contactDeleteButton;
	@FindBy(how = How.XPATH, using = "//div[@class='actions']//button[contains(text(),'Delete')]")
	public  WebElement contactDeleteConfirmButton;
	@FindBy(how = How.XPATH, using = "//div[@class='content']")
	public  WebElement contactDeleteConfirmationMsg;
	@FindBy(how = How.XPATH, using = "//div[@id='main-content']")
	public  WebElement checkedBtn;
	@FindBy(how = How.XPATH, using = "//div[@class='header']")
	public  WebElement confirmMsg;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Show Filters')]")
	public  WebElement contactShowFilterButton;
	@FindBy(how = How.XPATH, using = "//input[@class='search']")
	public  WebElement contactSearchField;
	@FindBy(how = How.XPATH, using = "//input[@class='search']")
	public  WebElement contactSearchAllOptions;
	@FindBy(how = How.XPATH, using = "//*[@id='ui']/div/div[2]/div[2]/div/div[2]/form/div[1]/div[2]/div/button[5]/i")
	public  WebElement contactSearchFilter;
	@FindBy(how = How.XPATH, using = "//input[@name='value']")
	public  WebElement contactSearchValue;
	@FindBy(how = How.XPATH, using = "//div[@name='operator']")
	public  WebElement contactSearchOperator;
	@FindBy(how = How.XPATH, using = "//tbody/tr/td[3]")
	public  WebElement contactSearchCheck;

	@FindBy(how = How.XPATH, using = "(//span[normalize-space()='Address'])[1]")
	public  WebElement adressOption;
	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Contains']")
	public  WebElement containsOperator;
	@FindBy(how = How.XPATH, using = "//tr[3]/td[3]")
	public  WebElement AddressFind;
	
	@FindBy(how = How.XPATH, using = "//th[normalize-space()='Description']")
	public  WebElement contactSearchColumnsCheck;
	
	@FindBy(how = How.XPATH, using = "//i[@class='columns small icon']")
	public  WebElement contactSearchColumnButton;
	@FindBy(how = How.XPATH, using = "//label[normalize-space()='Description']")
	public  WebElement contactSearchColumnDescr;
	
	//@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/div[2]/div/div[1]/div/div[2]/div[2]/div/label")
	//public  WebElement contactSearchColumnAccess;

	@FindBy(how = How.XPATH, using = "//button[@class='ui button']")
	public  WebElement contactSearchColumnSetButton;
     
     
   
	public ContactsPage() {
		PageFactory.initElements(Setup.getDriver(), this);
	}
	

}



