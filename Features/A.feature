Feature: Login to Infor M3 Application
  
  
  
  @InforM3
  Scenario: Login into InforM3 Application and Verify the Hmoe
  
    Given Launch infor Application
    When Enter valid UaserName and Password
    Then Verify user is able to login to the application