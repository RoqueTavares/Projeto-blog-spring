package com.educandoweb.blogsistem.repositories;

import com.educandoweb.blogsistem.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
