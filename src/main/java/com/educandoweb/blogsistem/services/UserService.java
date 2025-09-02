package com.educandoweb.blogsistem.services;

import com.educandoweb.blogsistem.entities.User;
import com.educandoweb.blogsistem.repositories.PostRepository;
import com.educandoweb.blogsistem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PostRepository postRepository;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> user = repository.findById(id);
        return user.orElse(null);
    }

    @PreAuthorize("hasAuthority('CREATE_ACCOUT')")
    public User insert(User user){
        return repository.save(user);
    }




}
