Feature: User Login Functionality

  As a valid user
  I want to log in to the application
  So that I can access the home page successfully

  @smoke @login
  Scenario: Successful login with valid credentials
    Given user navigates to the login page "https://rahulshettyacademy.com/loginpagePractise/"
    When user enters username "rahulshettyacademy"
    And user enters password "learning"
    And user selects the user checkbox
    And user accepts the alert popup
    And user selects "Student" from the role dropdown
    And user selects the terms and conditions checkbox
    And user clicks on the sign in button
    Then user should be logged in successfully
