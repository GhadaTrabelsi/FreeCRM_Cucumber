@Contacts
Feature: Manage Contacts

  Background: Common Steps
    Given I am on the login page
    When I enter the email and password
    And I click the login button
    Then Page Title should be Cogemento

  Scenario Outline: Verify User is able to create a new Contact successfully
    When User is on Contacts page
    When User Click on New Contacts button
    When enters "<FirstName>", "<LastName>", "<Position>" and "<Department>"
    When User clicks on Save button
    Then Contacts should be saved successfully

    Examples: 
      | FirstName | LastName | Position    | Department |
      | Ghada     | Mestiri  | Team Member | QA         |

  Scenario: Verify edit functionality of Contacts
    When Contacts exists in CRM application
   When User edits the contacts
      And Saves the Contact
    Then Contact should be edited successfully

  Scenario: Verify delete functionality of Contacts
    Given Contacts exists in CRM application
    When User selects Contacts to  delete 
    Then selected contact should be deleted successfully
    
    Scenario Outline: Verify User is able to search contact based upon address
    Given User is on Contacts page
    When User search the contact using "<Address>"
    Then User should see only contacts having matching address

    Examples:
      | Address |
      | Ariana  |
    
    Scenario: Verify User is able to add column in result grid
    Given User is on Contacts page
    When User add a column to be displayed in result grid
    Then Column should be added in result grid    
    
      