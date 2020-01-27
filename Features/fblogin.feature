
@FBModule
Feature: Facebook functionality
  I want to use this template for my feature file

  Scenario: Login to Facebook and verify page
    Given Navigate to facebook url
    When Enter UserName and Password
    Then Verify the Home Page

  Scenario: Invalid login details and verify the page
    Given Navigate to facebook url
    When  Enter invalid UserName and Password
    Then Verify the Error Message

    