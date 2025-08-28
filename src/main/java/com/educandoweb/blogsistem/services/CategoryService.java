package com.educandoweb.blogsistem.services;

import com.educandoweb.blogsistem.entities.Category;
import com.educandoweb.blogsistem.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> category = repository.findById(id);
        return category.orElse(null);
    }

    public Category insert(Category category){
        return repository.save(category);
    }
}
