Feature: Persistence for a User
  A User entities persistence should work

  Scenario: Create Student persistence request
    When I ask to create a new Student
    Then A new Student should be created in the Database

  Scenario: Create TeachingStaff persistence request
    When I ask to create a new TeachingStaff
    Then A new TeachingStaff should be created in the Database

  Scenario: Create NonTeachingStaff persistence request
    When I ask to create a new NonTeachingStaff
    Then A new NonTeachingStaff should be created in the Database

  Scenario: Read TeachingStaff persistence request
    When I ask to read an existing TeachingStaff
    Given That a TeachingStaff of requested ID exists
    Then The specified TeachingStaff should be returned from the Database

  Scenario: Read NonTeachingStaff persistence request
    When I ask to read an existing NonTeachingStaff
    Given That a NonTeachingStaff of requested ID exists
    Then The specified NonTeachingStaff should be returned from the Database

  Scenario: Read Student persistence request
    When I ask to read an existing Student
    Given That a Student of requested ID exists
    Then The specified Student should be returned from the Database

  Scenario: Update Student persistence request
    When I ask to update an existing Student
    Given That a Student of the same ID exists
    Then The specified Student should be updated in the Database

  Scenario: Update TeachingStaff persistence request
    When I ask to update an existing TeachingStaff
    Given That a TeachingStaff of the same ID exists
    Then The specified TeachingStaff should be updated in the Database

  Scenario: Update NonTeachingStaff persistence request
    When I ask to update an existing NonTeachingStaff
    Given That a NonTeachingStaff of the same ID exists
    Then The specified NonTeachingStaff should be updated in the Database

  Scenario: Delete Student persistence request
    When I ask to delete an existing Student
    Given That a Student of the specified ID exists
    Then The specified Student should be deleted from Database

  Scenario: Delete TeachingStaff persistence request
    When I ask to delete an existing TeachingStaff
    Given That a TeachingStaff of the specified ID exists
    Then The specified TeachingStaff should be deleted from Database

  Scenario: Delete NonTeachingStaff persistence request
    When I ask to delete an existing NonTeachingStaff
    Given That a NonTeachingStaff of the specified ID exists
    Then The specified NonTeachingStaff should be deleted from Database