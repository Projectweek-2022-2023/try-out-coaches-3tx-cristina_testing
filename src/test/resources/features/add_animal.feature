Feature: Add Animal

  As a user
  I want to register the data of a new animal
  So that I may get an update on it's name, kind and behaviour

  # Personas
  # Brecht - user

  @UI
  Rule: Food must be greater than zero units

  Scenario: The animal is added when the food it consumes is greater than zero
    Given Brecht has chosen to add a new animal
    When Brecht registers 9 as the amount of food
    Then the animal should be added to the overview of animals

  Scenario Outline: An error messages is shown if the food the animal consumes is equal to or less than zero
    Given Brecht has chosen to add a new animal
    When Brecht registers <food> as the amount of food
    Then an error message should be shown

    Examples:
      | food |
      | 0    |
      | -5   |

