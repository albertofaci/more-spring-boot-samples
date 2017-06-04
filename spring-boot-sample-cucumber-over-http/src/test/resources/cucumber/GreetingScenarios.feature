Feature: The application can greet the user

  Scenario: Greet a user given their name over HTTP

    Given a user with name "John"
    When a greeting is requested
    Then the greeting is successful
    Then the message is "Hello John. How's it going?"