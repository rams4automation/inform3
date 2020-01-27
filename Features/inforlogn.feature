Feature: Infor m3 Application
  I want to use this template for my feature file
  

  @Smoke
  Scenario: Create order in infor m3 Application
  
    Given Launch infor Application
    When Enter valid UaserName and Password
    And Verify user is able to login to the application
    Then Enter order details
