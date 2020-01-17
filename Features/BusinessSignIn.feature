
Feature: Synovus Business Sign in
  
  
  Scenario: Verify Business user is able to login to the applicatuion from Personalpage --1	
  											
     Given Launch Synovus Browser
     And Click on Buiness option in primary menu
     And Click on Login link at top right of the screen
     When Enter Valid Business UserName and Password
     Then Verify user is able to login to the application from Business page 