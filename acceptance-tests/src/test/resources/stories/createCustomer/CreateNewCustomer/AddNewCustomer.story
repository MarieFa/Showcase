Narrative:
  In order to proceed shipments for a new customer
  As a transport specialist
  I want to add a new customer

Scenario: Abort adding new customer
Given I start to create a new customer
When I abort the adding of a new customer
Then There arent new customer data in the system

Scenario: Add a new Customer with all required informations
Given I start to create a new customer
When I add a new customer with Samsung as customer name, Beispielstrasse as street, 1 as house number, 1234 as zip code and Seoul as city
Then There are new customer data in the system