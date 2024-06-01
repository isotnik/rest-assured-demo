package org.isotnik.jira.pojo;

import java.util.List;

public class GetIssueResponse {
    private String expand;
    private String id;
    private String self;
    private String key;
    private Fields fields;

    public String getFirstAttachmentFileName() {
        return this.getFields().getAttachment().get(0).getFilename();
    }

    public int getFirstAttachmentFileSize() {
        return this.getFields().getAttachment().get(0).getSize();
    }

    public String getDescriptionText() {
        return this.getFields().getDescription().getContent().get(0).getContent().get(0).getText();
    }

    public String getFirstCommentText() {
        return this.getFields().getComment().getComments().get(0).getBody().getContent().get(0).getContent().get(0).getText();
    }

    public String getExpand() {
        return expand;
    }

    public void setExpand(String expand) {
        this.expand = expand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }

    public static class Fields {
        private String statuscategorychangedate;
        private IssueType issuetype;
        private Project project;
        private int workratio;
        private Watches watches;
        private String lastViewed;
        private IssueRestriction issuerestriction;
        private String created;
        private Priority priority;
        private String updated;
        private Status status;
        private Description description;
        private List<Attachment> attachment;
        private String summary;
        private User creator;
        private User reporter;
        private Progress aggregateprogress;
        private Progress progress;
        private Votes votes;
        private Comments comment;
        private Worklog worklog;

        public Worklog getWorklog() {
            return worklog;
        }

        public void setWorklog(Worklog worklog) {
            this.worklog = worklog;
        }

        public Comments getComment() {
            return comment;
        }

        public void setComment(Comments comment) {
            this.comment = comment;
        }

        public Votes getVotes() {
            return votes;
        }

        public void setVotes(Votes votes) {
            this.votes = votes;
        }

        public Progress getProgress() {
            return progress;
        }

        public void setProgress(Progress progress) {
            this.progress = progress;
        }

        public Progress getAggregateprogress() {
            return aggregateprogress;
        }

        public void setAggregateprogress(Progress aggregateprogress) {
            this.aggregateprogress = aggregateprogress;
        }

        public User getReporter() {
            return reporter;
        }

        public void setReporter(User reporter) {
            this.reporter = reporter;
        }

        public User getCreator() {
            return creator;
        }

        public void setCreator(User creator) {
            this.creator = creator;
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

        public List<Attachment> getAttachment() {
            return attachment;
        }

        public void setAttachment(List<Attachment> attachment) {
            this.attachment = attachment;
        }

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }

        public String getUpdated() {
            return updated;
        }

        public void setUpdated(String updated) {
            this.updated = updated;
        }

        public Priority getPriority() {
            return priority;
        }

        public void setPriority(Priority priority) {
            this.priority = priority;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public IssueRestriction getIssuerestriction() {
            return issuerestriction;
        }

        public void setIssuerestriction(IssueRestriction issuerestriction) {
            this.issuerestriction = issuerestriction;
        }

        public String getLastViewed() {
            return lastViewed;
        }

        public void setLastViewed(String lastViewed) {
            this.lastViewed = lastViewed;
        }

        public Watches getWatches() {
            return watches;
        }

        public void setWatches(Watches watches) {
            this.watches = watches;
        }

        public int getWorkratio() {
            return workratio;
        }

        public void setWorkratio(int workratio) {
            this.workratio = workratio;
        }

        public Project getProject() {
            return project;
        }

        public void setProject(Project project) {
            this.project = project;
        }

        public IssueType getIssuetype() {
            return issuetype;
        }

        public void setIssuetype(IssueType issuetype) {
            this.issuetype = issuetype;
        }

        public String getStatuscategorychangedate() {
            return statuscategorychangedate;
        }

        public void setStatuscategorychangedate(String statuscategorychangedate) {
            this.statuscategorychangedate = statuscategorychangedate;
        }

        public static class IssueType {
            private String self;
            private String id;
            private String description;
            private String iconUrl;
            private String name;
            private boolean subtask;
            private int avatarId;
            private String entityId;
            private int hierarchyLevel;

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

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getIconUrl() {
                return iconUrl;
            }

            public void setIconUrl(String iconUrl) {
                this.iconUrl = iconUrl;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public boolean isSubtask() {
                return subtask;
            }

            public void setSubtask(boolean subtask) {
                this.subtask = subtask;
            }

            public int getAvatarId() {
                return avatarId;
            }

            public void setAvatarId(int avatarId) {
                this.avatarId = avatarId;
            }

            public String getEntityId() {
                return entityId;
            }

            public void setEntityId(String entityId) {
                this.entityId = entityId;
            }

            public int getHierarchyLevel() {
                return hierarchyLevel;
            }

            public void setHierarchyLevel(int hierarchyLevel) {
                this.hierarchyLevel = hierarchyLevel;
            }
        }

        public static class Project {
            private String self;
            private String id;
            private String key;
            private String name;
            private String projectTypeKey;
            private boolean simplified;
            private AvatarUrls avatarUrls;

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

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getProjectTypeKey() {
                return projectTypeKey;
            }

            public void setProjectTypeKey(String projectTypeKey) {
                this.projectTypeKey = projectTypeKey;
            }

            public boolean isSimplified() {
                return simplified;
            }

            public void setSimplified(boolean simplified) {
                this.simplified = simplified;
            }

            public AvatarUrls getAvatarUrls() {
                return avatarUrls;
            }

            public void setAvatarUrls(AvatarUrls avatarUrls) {
                this.avatarUrls = avatarUrls;
            }

        }

        public static class IssueRestriction {
            private boolean shouldDisplay;

            public boolean isShouldDisplay() {
                return shouldDisplay;
            }

            public void setShouldDisplay(boolean shouldDisplay) {
                this.shouldDisplay = shouldDisplay;
            }
        }

        public static class Watches {
            private String self;
            private int watchCount;
            private boolean isWatching;

            public String getSelf() {
                return self;
            }

            public void setSelf(String self) {
                this.self = self;
            }

            public int getWatchCount() {
                return watchCount;
            }

            public void setWatchCount(int watchCount) {
                this.watchCount = watchCount;
            }

            public boolean isWatching() {
                return isWatching;
            }

            public void setWatching(boolean watching) {
                isWatching = watching;
            }
        }

        public static class Priority {
            private String self;
            private String iconUrl;
            private String name;
            private String id;

            public String getSelf() {
                return self;
            }

            public void setSelf(String self) {
                this.self = self;
            }

            public String getIconUrl() {
                return iconUrl;
            }

            public void setIconUrl(String iconUrl) {
                this.iconUrl = iconUrl;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }

        public static class Status {
            private String self;
            private String description;
            private String iconUrl;
            private String name;
            private String id;
            private StatusCategory statusCategory;

            public String getSelf() {
                return self;
            }

            public void setSelf(String self) {
                this.self = self;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getIconUrl() {
                return iconUrl;
            }

            public void setIconUrl(String iconUrl) {
                this.iconUrl = iconUrl;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public StatusCategory getStatusCategory() {
                return statusCategory;
            }

            public void setStatusCategory(StatusCategory statusCategory) {
                this.statusCategory = statusCategory;
            }

            public static class StatusCategory {
                private String self;
                private int id;
                private String key;
                private String colorName;
                private String name;

                public String getSelf() {
                    return self;
                }

                public void setSelf(String self) {
                    this.self = self;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getKey() {
                    return key;
                }

                public void setKey(String key) {
                    this.key = key;
                }

                public String getColorName() {
                    return colorName;
                }

                public void setColorName(String colorName) {
                    this.colorName = colorName;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
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
                private List<ContentDetail> content;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public List<ContentDetail> getContent() {
                    return content;
                }

                public void setContent(List<ContentDetail> content) {
                    this.content = content;
                }

                public static class ContentDetail {
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

        public static class Progress {
            private int progress;
            private int total;

            public int getProgress() {
                return progress;
            }

            public void setProgress(int progress) {
                this.progress = progress;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }
        }

        public static class Votes {
            private String self;
            private int votes;
            private boolean hasVoted;

            public String getSelf() {
                return self;
            }

            public void setSelf(String self) {
                this.self = self;
            }

            public int getVotes() {
                return votes;
            }

            public void setVotes(int votes) {
                this.votes = votes;
            }

            public boolean isHasVoted() {
                return hasVoted;
            }

            public void setHasVoted(boolean hasVoted) {
                this.hasVoted = hasVoted;
            }
        }

        public static class Comments {
            private List<Comment> comments;
            private String self;
            private int maxResults;
            private int total;
            private int startAt;

            public List<Comment> getComments() {
                return comments;
            }

            public void setComments(List<Comment> comments) {
                this.comments = comments;
            }

            public String getSelf() {
                return self;
            }

            public void setSelf(String self) {
                this.self = self;
            }

            public int getMaxResults() {
                return maxResults;
            }

            public void setMaxResults(int maxResults) {
                this.maxResults = maxResults;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getStartAt() {
                return startAt;
            }

            public void setStartAt(int startAt) {
                this.startAt = startAt;
            }
        }
        public static class Worklog {
            private int startAt;
            private int maxResults;
            private int total;

            public int getStartAt() {
                return startAt;
            }

            public void setStartAt(int startAt) {
                this.startAt = startAt;
            }

            public int getMaxResults() {
                return maxResults;
            }

            public void setMaxResults(int maxResults) {
                this.maxResults = maxResults;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }
        }
    }

}
