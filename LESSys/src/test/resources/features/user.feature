Feature: Persistence for a User
  A User entities persistence should work

  Scenario: Create persistence request
    When I ask to create a new User
    Then A new User should be created in the Database

  Scenario: Read persistence request
    When I ask to read an existing User
    Given That a user of requested ID exists
    Then The specified User should be returned from the Database

  Scenario: Update persistence request
    When I ask to update an existing User
    Given That a user of the same ID exists
    Then The specified User should be updated in the Database

  Scenario: Delete persistence request
    When I ask to delete an existing User
    Given That a user of the specified ID exists
    Then The specified User should be deleted from Database