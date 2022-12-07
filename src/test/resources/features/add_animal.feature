Feature: Add animal
  As a user
  I want to add an animal
  So that I can keep track of the details of the animal

  # Personas
  # Brecht - user

  @UI
  Rule: Food must be greater than 0
      Scenario: The animal is added with a food equal to 1
        Given Brecht is at the add animal page
        When Brecht adds animal with food equal to 1
        Then The animal should be added to the overview of animals

      Scenario: The animal is added with a food equal to 0
        Given Brecht is at the add animal page
        When Brecht adds animal with food equal to 0
        Then The animal should not be added to the overview of animals