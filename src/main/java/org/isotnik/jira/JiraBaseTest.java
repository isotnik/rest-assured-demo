package org.isotnik.jira;

import io.restassured.specification.RequestSpecification;
import utils.ConfigLoader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;


public class JiraBaseTest {
    private final ConfigLoader config = new ConfigLoader("jira.properties");
    protected String baseUrl = config.getProperty("baseUrl");
    protected String auth = config.getProperty("auth");
    protected String projectKey = config.getProperty("projectKey");
    protected String issueType = config.getProperty("issueType");
    protected RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(baseUrl)
            .addHeader("Authorization", auth)
            .setContentType(ContentType.JSON)
            .build();
    protected RequestSpecification requestSpecAttachment = new RequestSpecBuilder()
            .setBaseUri(baseUrl)
            .addHeader("Authorization", auth)
            .addHeader("X-Atlassian-Token", "no-check")
            .setContentType(ContentType.MULTIPART)
            .build();
}
