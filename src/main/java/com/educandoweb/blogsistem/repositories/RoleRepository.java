package com.educandoweb.blogsistem.repositories;

import com.educandoweb.blogsistem.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
