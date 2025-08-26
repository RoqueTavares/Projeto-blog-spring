package com.educandoweb.blogsistem.services;

import com.educandoweb.blogsistem.entities.Comment;
import com.educandoweb.blogsistem.entities.Post;
import com.educandoweb.blogsistem.entities.User;
import com.educandoweb.blogsistem.repositories.CommentRepository;
import com.educandoweb.blogsistem.repositories.PostRepository;
import com.educandoweb.blogsistem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository repository;

    @Autowired
    private UserRepository useRepository;

    @Autowired
    private PostRepository postRepository;

    public List<Comment> findAll(){
        return repository.findAll();
    }

    public Comment findById(Long id){
        Optional<Comment> user = repository.findById(id);
        return user.orElse(null);
    }

    public Comment createComment(Long userId,Long postId,Comment comment){
        Optional<User> user = useRepository.findById(userId);
        Optional<Post> post = postRepository.findById(postId);
        comment.setUser(user.get());
        comment.setPost(post.get());
        return repository.save(comment);
    }


}
