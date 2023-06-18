@Deals
Feature: CRM deals module functionality

  Background: Common Steps
    Given I am on the login page
    When I enter the email and password
    And I click the login button
    Then Page Title should be Cogemento

  Scenario Outline: Verify User is able to create a new Deal
    Given User is present on Deals Page
    When User clicks on New Deal button
    And enters "<Title>", "<Description>", "<Probability>" and "<Amount>" and Saves the deal
    Then deal should be created successfully

    Examples: 
      | Title | Description | Probability | Amount |
      | TD    | Test Deal   |          60 |    950 |

  Scenario Outline: Verify User is able to edit the deal
    Given User is present on Deals Page
    When User selects the Deal to edit and clicks on Edit button
    And User updates "<Commission>" and saves the deal
    Then Deal should be editted successfully

    Examples: 
      | Commission |
      |        150 |

  Scenario: Verify delete functionality of Deals
    Given Deals exists in CRM application
    When User selects Deal and deletes the selected Deal
   # Then selected Deal should be deleted successfully
