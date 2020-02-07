Feature: Create plledn oredr in Infor M3 Application
  
  
  
  @InforM3
   Scenario: Order creaion
   
    Given Enter order details
    When Enter towarehouse and frmwarehouse Details
    And Enter itemNumber and OrderType Number Details
    And Enter Planned and Distribtion Details
    Then Verify order is created