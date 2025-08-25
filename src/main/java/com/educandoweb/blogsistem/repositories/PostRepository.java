package com.educandoweb.blogsistem.repositories;

import com.educandoweb.blogsistem.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>{
}
