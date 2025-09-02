package com.educandoweb.blogsistem.services;

import com.educandoweb.blogsistem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    @Transactional(readOnly = true) // Boa prática para métodos de apenas leitura
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 1. Usa o método com JOIN FETCH para evitar o LazyInitializationException
        return repository.findByEmailWithRoles(username)

                // 2. Trata o Optional, retornando o usuário ou lançando a exceção
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com o email: " + username));
    }
}