package com.example.web.model.comment;
import java.time.LocalDateTime;





public class CommentResponse {

    private Long id;
    private String text;
    private String userName;
    private String postText;
    private Long postId;
    private LocalDateTime createdAt;

    public CommentResponse() {}

    public CommentResponse(Long id, String text, String userName, String postText, Long postId, LocalDateTime createdAt) {
        this.id = id;
        this.text = text;
        this.userName = userName;
        this.postText = postText;
        this.postId = postId;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getUserName() {
        return userName;
    }

    public String getPostText() {
        return postText;
    }

    public Long getPostId() {
        return postId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

