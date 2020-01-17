@Synovussignin

Feature: Synovus Sign in

  Scenario: Verify user is able to login to the applicatuion from Personalpage --1	
  											
     Given Launch Synovus Browser
     And Click on Personal option in primary menu
     And Click on Login link at top right of the screen
     When Enter Valid UserName and Password
     Then Verify user is able to login to the application from Personal page 
   