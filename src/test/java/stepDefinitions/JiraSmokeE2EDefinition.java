package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.isotnik.jira.ApiResources;
import org.isotnik.jira.JiraBaseTest;
import org.isotnik.jira.pojo.*;
import org.testng.Assert;

import java.io.File;
import java.util.List;

import static io.restassured.RestAssured.given;

public class JiraSmokeE2EDefinition extends JiraBaseTest {
    static String issueKey;
    static String attachmentId;
    File toAttach;
    RequestSpecification createSpec;
    Response response;

    @Given("Issue payload with summary {string} and description {string}")
    public void issue_payload_with_summary_and_description(String summary, String description) {
        createSpec = given().spec(requestSpec).when().body(new CreateIssueRequest(projectKey, summary, description, issueType));
    }
    @When("User calls {string} API resource with {string} http method")
    public void user_calls_api_resource_with_http_method(String resource, String method) {
        if (method.equals("POST"))
            response = createSpec.post(ApiResources.valueOf(resource).toString());
        else if (method.equals("DELETE"))
            response = createSpec.delete(ApiResources.valueOf(resource).toString());
    }
    @Then("API call is successful with status code {int}")
    public void api_call_is_successful_with_status_code(Integer expectedStatusCode) {
         Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
    }
    @And("Issue key is present in response")
    public void issue_key_is_present_in_response() {
        CreateIssueResponse createIssueResponseDeserialized = response.as(CreateIssueResponse.class);
        issueKey = createIssueResponseDeserialized.getKey();
        Assert.assertNotNull(issueKey);
    }
    @And("Issue summary and description match given summary {string} and description {string}")
    public void issueSummaryAndDescriptionMatchGivenSummaryAndDescription(String summary, String description) {
        GetIssueResponse getIssueResponse = getIssue(issueKey);
        Assert.assertEquals(getIssueResponse.getFields().getSummary(), summary);
        Assert.assertEquals(getIssueResponse.getDescriptionText(), description);
    }

    @Given("File with name {string} for uploading")
    public void fileWithNameForUploading(String fileName) {
        toAttach = new File(fileName);
        createSpec = given().spec(requestSpecAttachment).when()
                .pathParam("issueKey", issueKey)
                .multiPart("file", toAttach);
    }

    @And("File name and size match original file")
    public void fileNameAndSizeMatchOriginalFile() {
        List<Attachment> attachments = response.jsonPath().getList("", Attachment.class);
        attachmentId = attachments.get(0).getId();
        Assert.assertNotNull(attachmentId);
        GetIssueResponse getIssueResponse = getIssue(issueKey);
        Assert.assertEquals(getIssueResponse.getFirstAttachmentFileName(), toAttach.getName());
        Assert.assertEquals(getIssueResponse.getFirstAttachmentFileSize(), toAttach.length());
    }

    @Given("Comment payload with body text {string}")
    public void commentPayloadWithBodyText(String bodyText) {
        createSpec = given().spec(requestSpec).when()
                .pathParam("issueKey", issueKey)
                .body(new CreateCommentRequest(bodyText));
    }

    @And("Comment appears in getIssue response and its body text matches provided {string}")
    public void commentAppearsInGetIssueResponseAndItsBodyTextMatchesProvided(String bodyText) {
        GetIssueResponse getIssueResponse = getIssue(issueKey);
        Assert.assertEquals(getIssueResponse.getFirstCommentText(), bodyText);
    }

    @Given("Issue is already existing")
    public void issueIsAlreadyExisting() {
        createSpec = given().spec(requestSpec).pathParam("issueKey", issueKey);
    }

    @And("getIssue response is unsuccessful with status code {int}")
    public void getIssueResponseIsUnsuccessfulWithStatusCode(int expectedStatusCode) {
        given().spec(requestSpec).when()
                .pathParam("issueKey", issueKey)
                .get(ApiResources.GET_ISSUE.toString())
                .then().assertThat().statusCode(expectedStatusCode);
    }

    private GetIssueResponse getIssue(String issueKey) {
        return given().spec(requestSpec).when()
                .pathParam("issueKey", issueKey)
                .queryParam("fields", "summary, description, comment, attachment")
                .get(ApiResources.GET_ISSUE.toString())
                .then().assertThat().statusCode(200).extract().response().as(GetIssueResponse.class);
    }
}
