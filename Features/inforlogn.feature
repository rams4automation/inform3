Feature: Infor M3 Application
  
  

  @Smoke
  Scenario: Create order in infor M3 Application
  
    Given Launch infor Application
    When Enter valid UaserName and Password
    And Verify user is able to login to the application
    And Enter order details
    And Enter towarehouse and frmwarehouse Details
    And Enter itemNumber and OrderType Number Details
    And Enter Planned and Distribtion Details
    Then Verify order is created
