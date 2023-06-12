Feature: JIRA Apis Validation
  I want to use this template for my feature file

  Scenario: Validate the Create Issue in Jira api
    Given User calls Issue api with POST request
    When the API call got success with status code 201
    Then status in create response body is "HTTP/1.1 201 Created"
    And Validate Content-Type is application/json and time consume

  Scenario: Validate the Get issue deatails
    Given User calls the Get api request
    When the api call got success with get Issue status code 200
    Then Validate the content type is application/json

  Scenario: Validate the update issue deatails
    Given User calls the Update the existing issue
    When the update api call got success with status code 204
    Then status in response body is "HTTP/1.1 204 No Content"
    And Validate Content-Type is application/json

  Scenario: Validate the delete issue in existing issue
    Given User calls delete api request
    When the the api call got success with delete Issue status code 204

 