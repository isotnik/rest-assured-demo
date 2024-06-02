Feature: Smoke E2E for Jira
  Scenario Outline: Issue can be created using API
    Given Issue payload with summary "<summary>" and description "<description>"
    When User calls "CREATE_ISSUE" API resource with "POST" http method
    Then API call is successful with status code 201
    And Issue key is present in response
    And Issue summary and description match given summary "<summary>" and description "<description>"
    Examples:
      | summary               | description                |
      |Rest created summary   | Rest created description   |

  Scenario: Attachment can be added to issue
    Given File with name "Illia Sotnyk CV.pdf" for uploading
    When User calls "CREATE_ATTACHMENT" API resource with "POST" http method
    Then API call is successful with status code 200
    And File name and size match original file

  Scenario Outline: Comment can added to issue
    Given Comment payload with body text "<Body text>"
    When User calls "CREATE_COMMENT" API resource with "POST" http method
    Then API call is successful with status code 201
    And Comment appears in getIssue response and its body text matches provided "<Body text>"
    Examples:
      |Body text   |
      |Rest created comment|
  
  Scenario: Issue with comment and attachment can be deleted
    Given Issue is already existing
    When User calls "DELETE_ISSUE" API resource with "DELETE" http method
    Then API call is successful with status code 204
    And getIssue response is unsuccessful with status code 404