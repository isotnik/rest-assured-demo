package org.isotnik.jira.pojo;

import java.util.ArrayList;
import java.util.List;

public class CreateIssueRequest {
    public CreateIssueRequest() {

    }

    public CreateIssueRequest(String projectKey, String summary, String description, String issueType) {
        fields = new Fields();
        fields.project = new Project();
        fields.project.setKey(projectKey);
        fields.summary = summary;
        fields.description = new Description();
        fields.description.setType("doc");
        fields.description.setVersion(1);
        fields.description.content = new ArrayList<Description.Content>();
        Description.Content descriptionContent = new Description.Content();
        descriptionContent.type = "paragraph";
        descriptionContent.content = new ArrayList<Description.Content.TextContent>();
        Description.Content.TextContent textContent = new Description.Content.TextContent();
        textContent.type = "text";
        textContent.text = description;
        descriptionContent.content.add(textContent);
        fields.description.content.add(descriptionContent);
        fields.issuetype = new IssueType();
        fields.issuetype.name = issueType;
    }


    private Fields fields;

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }

    public static class Fields {
        private Project project;
        private String summary;
        private Description description;
        private IssueType issuetype;

        public Project getProject() {
            return project;
        }

        public void setProject(Project project) {
            this.project = project;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public Description getDescription() {
            return description;
        }

        public void setDescription(Description description) {
            this.description = description;
        }

        public IssueType getIssuetype() {
            return issuetype;
        }

        public void setIssuetype(IssueType issuetype) {
            this.issuetype = issuetype;
        }
    }

    public static class Project {
        private String key;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }

    public static class Description {
        private String type;
        private int version;
        private List<Content> content;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public List<Content> getContent() {
            return content;
        }

        public void setContent(List<Content> content) {
            this.content = content;
        }

        public static class Content {
            private String type;
            private List<TextContent> content;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<TextContent> getContent() {
                return content;
            }

            public void setContent(List<TextContent> content) {
                this.content = content;
            }

            public static class TextContent {
                private String type;
                private String text;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }
        }
    }

    public static class IssueType {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
