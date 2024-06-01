package org.isotnik.jira.pojo;

public class CreateCommentRequest {
    public CreateCommentRequest() {

    }
    public CreateCommentRequest(String body) {
        this.body = body;
    }

    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
