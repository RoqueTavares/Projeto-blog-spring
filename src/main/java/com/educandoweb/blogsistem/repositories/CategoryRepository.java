package com.educandoweb.blogsistem.repositories;

import com.educandoweb.blogsistem.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
