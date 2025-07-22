package com.example.web.model.comment;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;





public class CommentRequest {
    @NotBlank(message = "Text can not be blank!;")
    @Size(min = 2, max = 128, message = "Text must be between 2-128!;")
    private String text;

    @NotNull(message = "Post ID must not be null!;")
    private Long postId;

    public CommentRequest() {}

    public CommentRequest(String text, Long postId) {
        this.text = text;
        this.postId = postId;
    }

    public String getText() {
        return text;
    }

    public Long getPostId() {
        return postId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}

