package com.educandoweb.blogsistem.services;

import com.educandoweb.blogsistem.entities.Category;
import com.educandoweb.blogsistem.entities.Post;
import com.educandoweb.blogsistem.repositories.CategoryRepository;
import com.educandoweb.blogsistem.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;
    @Autowired
    private PostRepository postRepository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> category = repository.findById(id);
        return category.orElse(null);
    }

   public Category create(Long postId,Category category){
        Post post = postRepository.findById(postId).get();
        post.getCategories().add(category);

        return repository.save(category);

   }
}
