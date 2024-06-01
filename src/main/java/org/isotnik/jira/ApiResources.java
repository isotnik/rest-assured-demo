package org.isotnik.jira;

public enum ApiResources {
    CREATE_ISSUE("rest/api/3/issue/"),
    GET_ISSUE("rest/api/3/issue/{issueKey}"),
    UPDATE_ISSUE("rest/api/3/issue/{issueKey}"),
    DELETE_ISSUE("rest/api/3/issue/{issueKey}"),
    SEARCH_ISSUES("rest/api/3/search"),
    CREATE_COMMENT("rest/api/2/issue/{issueKey}/comment/"),
    CREATE_ATTACHMENT("rest/api/3/issue/{issueKey}/attachments");

    private final String resource;

    ApiResources(String resource) {
        this.resource = resource;
    }

    @Override
    public String toString() {
        return resource;
    }
}
