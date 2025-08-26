package com.educandoweb.blogsistem.resources;

import com.educandoweb.blogsistem.entities.Comment;
import com.educandoweb.blogsistem.entities.Post;
import com.educandoweb.blogsistem.services.CommentService;
import com.educandoweb.blogsistem.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Comment")
public class CommentResource {

    @Autowired
    private CommentService service;

    @GetMapping
    public ResponseEntity<List<Comment>> findAll(){
        List<Comment> post = service.findAll();
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Comment> findById(@PathVariable Long id){
        Comment obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping(value = "/{userId}/{postId}")
    public ResponseEntity<Comment> create(@PathVariable Long userId,@PathVariable Long postId, @RequestBody Comment comment){
        Comment obj = service.createComment(userId,postId,comment);
        return ResponseEntity.ok().body(obj);
    }
}
