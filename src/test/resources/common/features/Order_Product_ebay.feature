@Application:ebayApplication
@version:5.17.0.18
@Coverage:Regression
@CreatedBy:Krishnamoorthy
@CreatedDate:3/08/2018
@ModifiedBy:Krishnamoorthy
@ModifiedDate:3/09/2018
@Functionality:EndToEndFlowShopping
Feature: To validate end to end functionality of shopping in an ebay native application

@ebay_ShoppingEndtoEndFlowValidation
Scenario Outline: Validate the end to end functionality of shopping in an ebay native application
Given ebay home page should be displayed
When user logs in to appliction using "<UserName>" and "<Password>" with "<UserID>"
Then ebay home page should be displayed
When user searches for desired category "<CategoryName>"
Then list of available items should be displayed
When user selects the desired item "<ItemName>"
Then buy it now page should be displayed
When user taps on 'BUY IT NOW'
Then delivery address page should be displayed
When user taps on 'Proceed to Pay' button
Then 'Choose your payment method' should be displayed
Examples:
|UserName                     |Password  |UserID                  |CategoryName    |ItemName                                                   |     
|krishnamoorthy.vedi@gmail.com|**********|krishnamoorthvediyappa_0|management books|Lan Traffic Management (Hewlett-Packard Professional Books)| 
