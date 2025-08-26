package com.educandoweb.blogsistem.services;

import com.educandoweb.blogsistem.entities.Comment;
import com.educandoweb.blogsistem.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository repository;

    public List<Comment> findAll(){
        return repository.findAll();
    }

    public Comment findById(Long id){
        Optional<Comment> user = repository.findById(id);
        return user.orElse(null);
    }

    public Comment insert(Comment post){
        return repository.save(post);
    }


}
