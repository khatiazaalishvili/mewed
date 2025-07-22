package com.example.web.model.comment;
import com.example.web.model.post.PostEntity;
import com.example.web.model.user.UserEntity;
import jakarta.persistence.*;
import java.time.LocalDateTime;




@Entity
@Table(name = "comments")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text", nullable = false, length = 128)
    private String text;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private PostEntity post;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public CommentEntity() {
        this.createdAt = LocalDateTime.now();
    }

    public CommentEntity(String text, PostEntity post, UserEntity user) {
        this.text = text;
        this.post = post;
        this.user = user;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public PostEntity getPost() {
        return post;
    }

    public UserEntity getUser() {
        return user;
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

    public void setPost(PostEntity post) {
        this.post = post;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

