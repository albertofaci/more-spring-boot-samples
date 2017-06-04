Feature: The application can greet the user


  Scenario: Greet a user given their name

    Given a user with name "John"
    When a greeting is requested
    Then the message is "Hello John. How's it going?"


  Scenario Outline: Greet a user given their name (parametrized)

    Given a user with name "<name>"
    When a greeting is requested
    Then the message is "Hello <name>. How's it going?"

  Examples:
    | name  |
    | Becky |
    | Daisy |