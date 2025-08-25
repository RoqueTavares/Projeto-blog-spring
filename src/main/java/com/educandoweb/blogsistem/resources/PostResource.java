package com.educandoweb.blogsistem.resources;

import com.educandoweb.blogsistem.entities.Post;
import com.educandoweb.blogsistem.entities.User;
import com.educandoweb.blogsistem.services.PostService;
import com.educandoweb.blogsistem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/post")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping
    public ResponseEntity<List<Post>> findAll(){
        List<Post> post = service.findAll();
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable Long id){
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Post> insert(@RequestBody Post post){
        Post obj = service.insert(post);
        return ResponseEntity.ok().body(obj);
    }
}
