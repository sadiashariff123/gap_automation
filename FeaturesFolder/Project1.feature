
Feature: Customer places Order at Gap.com
  Steps to place order at Gap.com

 
  Scenario Outline: Customer place an order at Gap.com
		Given User is on Home Page
		When User search for "womens dress"
		And Choose to buy the second item
		And Selects the colour and size
		And Adds item to the cart
		And clicks guest checkout
		And enters the email address continues as guest
		And select Priority 1 business day shipping
		Then enter personal details and shipping address on checkout page
		And select payment method and review order


 
