@SMOKE
Feature: Testing different request on the student application


  Scenario: Check if the User can get list of all users
    When I use get method to send request to the application
    Then I must get back a valid status code 200


  Scenario: Check if the User can create a new User
    When I use post method and send payload to create a new user
    Then I must get back a valid status code 201 as response

  Scenario: Updating the newly created user
    When I send a patch request using payload
    Then I should get a valid status code 200  as response

  Scenario: Deleting the newly created user
    When I send a delete request to perform on the application
    Then I should get a valid status code 204  as response





