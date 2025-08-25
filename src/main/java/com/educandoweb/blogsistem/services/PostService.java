package com.educandoweb.blogsistem.services;

import com.educandoweb.blogsistem.entities.Post;
import com.educandoweb.blogsistem.entities.User;
import com.educandoweb.blogsistem.repositories.PostRepository;
import com.educandoweb.blogsistem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<Post> findAll(){
        return repository.findAll();
    }

    public Post findById(Long id){
        Optional<Post> user = repository.findById(id);
        return user.orElse(null);
    }

    public Post insert(Post post){
        return repository.save(post);
    }


}
