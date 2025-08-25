package com.educandoweb.blogsistem.repositories;

import com.educandoweb.blogsistem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
