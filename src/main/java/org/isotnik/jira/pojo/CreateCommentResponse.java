package org.isotnik.jira.pojo;

public class CreateCommentResponse  {
    private String self;
    private String id;
    private User author;
    private String body;
    private User updateAuthor;
    private String created;
    private String updated;
    private boolean jsdPublic;

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUpdateAuthor() {
        return updateAuthor;
    }

    public void setUpdateAuthor(User updateAuthor) {
        this.updateAuthor = updateAuthor;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public boolean isJsdPublic() {
        return jsdPublic;
    }

    public void setJsdPublic(boolean jsdPublic) {
        this.jsdPublic = jsdPublic;
    }
}
