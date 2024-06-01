import io.restassured.response.Response;
import org.isotnik.jira.ApiResources;
import org.isotnik.jira.JiraBaseTest;
import org.isotnik.jira.pojo.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.util.List;
import static io.restassured.RestAssured.given;

public class JiraSmokeE2ETest extends JiraBaseTest {
    File toAttach = new File("Illia Sotnyk CV.pdf");
    String summary = "Rest created task";
    String description = "Rest created description";
    String comment = "Rest added comment";
    String issueKey;
    String commentId;
    String attachmentId;

    @Test
    public void createIssue() {
        CreateIssueResponse responseCreate = given().spec(requestSpec).when()
                .body(new CreateIssueRequest(projectKey, summary, description, issueType))
                .post(ApiResources.CREATE_ISSUE.toString())
                .then().assertThat().statusCode(201).extract().response().as(CreateIssueResponse.class);
        issueKey = responseCreate.getKey();
        Assert.assertNotNull(issueKey);
    }

    @Test (dependsOnMethods = {"createIssue"})
    public void addComment() {
        CreateCommentResponse responseCreate = given().spec(requestSpec).when()
                .pathParam("key", issueKey)
                .body(new CreateCommentRequest(comment))
                .post("rest/api/2/issue/{key}/comment")
                .then().assertThat().statusCode(201).extract().response().as(CreateCommentResponse.class);
        commentId = responseCreate.getId();
        Assert.assertNotNull(commentId);
    }

    @Test (dependsOnMethods = {"createIssue"})
    public void addAttachment() {
        Response responseCreate = given().spec(requestSpecAttachment).when()
                .pathParam("issueKey", issueKey)
                .multiPart("file", toAttach)
                .post(ApiResources.CREATE_ATTACHMENT.toString())
                .then().assertThat().statusCode(200).extract().response();
        List<Attachment> attachments = responseCreate.jsonPath().getList("", Attachment.class);
        attachmentId = attachments.get(0).getId();
        Assert.assertNotNull(attachmentId);
    }

    @Test (dependsOnMethods = {"createIssue", "addComment", "addAttachment"})
    public void getIssue() {
        GetIssueResponse getIssueResponse = given().spec(requestSpec).when()
                .pathParam("issueKey", issueKey)
                .queryParam("fields", "summary, description, comment, attachment")
                .get(ApiResources.GET_ISSUE.toString())
                .then().log().all().assertThat().statusCode(200).extract().response().as(GetIssueResponse.class);
        Assert.assertEquals(getIssueResponse.getFields().getSummary(), summary);
        Assert.assertEquals(getIssueResponse.getDescriptionText(), description);
        Assert.assertEquals(getIssueResponse.getFirstAttachmentFileName(), toAttach.getName());
        Assert.assertEquals(getIssueResponse.getFirstAttachmentFileSize(), toAttach.length());
        Assert.assertEquals(getIssueResponse.getFirstCommentText(), comment);
    }

    @Test (dependsOnMethods = {"getIssue"})
    public void deleteIssue() {
        given().spec(requestSpec).when()
                .pathParam("issueKey", issueKey)
                .delete(ApiResources.DELETE_ISSUE.toString())
                .then().assertThat().statusCode(204);
        given().spec(requestSpec).when()
                .pathParam("issueKey", issueKey)
                .get(ApiResources.GET_ISSUE.toString())
                .then().assertThat().statusCode(404);
    }
}
