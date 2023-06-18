package com.e2etests.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.Setup;

public class DealsPage {
	public ConfigFileReader configFileReader;
	public DealsPage dealsPage;

	/* Retrieve Element */

	

	
	@FindBy(how = How.XPATH, using = "//i[@class='money icon']")
	public  WebElement deals;
	@FindBy(how = How.XPATH, using = "//button[normalize-space()='Create']")
	public  WebElement createDeal;
	@FindBy(how = How.XPATH, using = "//input[@name='title']")
	public  WebElement dealTitle;
	@FindBy(how = How.XPATH, using = "//textarea[@name='description']")
	public  WebElement dealDescription;
	@FindBy(how = How.XPATH, using = "//input[@name='probability']")
	public  WebElement dealProb;
	@FindBy(how = How.XPATH, using = "//input[@name='amount']")
	public  WebElement dealAmount;
	@FindBy(how = How.XPATH, using = "//button[@class='ui linkedin button']")
	public  WebElement saveBtn;
	@FindBy(how = How.XPATH, using = "//i[@class='large money red icon']")
	public  WebElement dealcreated;
	@FindBy(how = How.XPATH, using = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[2]/td[8]/a[2]/button[1]/i[1]")
	public  WebElement editBtn;
	@FindBy(how = How.XPATH, using = "//input[@name='commission']")
	public  WebElement comission;
	@FindBy(how = How.XPATH, using = "//tbody/tr[2]/td[8]/button[1]/i[1]")
	public  WebElement deleteBtn;
	
	@FindBy(how = How.XPATH, using = "//div[@name='action']//i[@class='dropdown icon']")
	public  WebElement dealsDeleteDropdown;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Delete')]")
	public  WebElement dealsDeleteDropdownOption;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Delete')]")
	public  WebElement dealsDeleteButton;
	@FindBy(how = How.XPATH, using = "//button[normalize-space()='Delete']")
	public  WebElement DealsDeleteBtn;
	@FindBy(how = How.XPATH, using = "//div[@class='header']")
	public  WebElement confirmMsg;
	
	
	

	public DealsPage() {
		PageFactory.initElements(Setup.getDriver(), this);
	}
	
	
	
	
	
	
	
	
	
	
	
}
