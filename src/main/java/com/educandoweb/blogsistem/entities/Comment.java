package com.educandoweb.blogsistem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="tb_comment")
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String content;
    private LocalDateTime createdAt;
    private Boolean edited;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Comment(){

    }

    public Comment(Long id, String content, LocalDateTime createdAt, Boolean edited, Post post, User user) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.edited = edited;
        this.post = post;
        this.user = user;
    }

    public Comment(Long id, String content, LocalDateTime createdAt, Boolean edited) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.edited = edited;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getEdited() {
        return edited;
    }

    public void setEdited(Boolean edited) {
        this.edited = edited;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
