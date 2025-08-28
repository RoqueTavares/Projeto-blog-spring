package com.educandoweb.blogsistem.resources;

import com.educandoweb.blogsistem.entities.Category;
import com.educandoweb.blogsistem.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category category = service.findById(id);
        return ResponseEntity.ok().body(category);
    }

    @PostMapping(value = "/{postId}")
    public ResponseEntity<Category> create(@PathVariable Long postId, @RequestBody Category category) {
        Category obj = service.create(postId,category);
        return ResponseEntity.ok().body(obj);
    }
}
