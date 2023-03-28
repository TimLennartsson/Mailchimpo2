Feature: Mailchimp signup

  Scenario Outline: create user - successfully
    Given user start a "<browser>"
    And user navigate to "<website>"
    When user have entered a vaild email, username and password
    Then user can sign up

    Examples:
      | browser | website                            |  |
      | Chrome  | http://login.mailchimp.com/signup/ |  |
      | Edge    | http://login.mailchimp.com/signup/ |  |