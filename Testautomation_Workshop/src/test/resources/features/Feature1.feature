Feature: Get Text and Price
  get the text and price of the products on our website.

  Scenario: Get Text and Price
    Given you are in the create Document
    When  you click on required product
    Then you can assert the price to be free and assert the text
