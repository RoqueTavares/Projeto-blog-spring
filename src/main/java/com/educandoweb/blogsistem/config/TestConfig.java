package com.educandoweb.blogsistem.config;

import com.educandoweb.blogsistem.entities.*;
import com.educandoweb.blogsistem.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private PermissaoRepository permissaoRepository;


    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Permissao pAccount = new Permissao(null, "CREATE_ACCOUT");
        Permissao pListAccount = new Permissao(null, "LIST_ACCOUNT");
        Permissao pDeleteAccount = new Permissao(null, "DELETE_ACCOUNT");

        permissaoRepository.saveAll(Arrays.asList(pAccount, pListAccount, pDeleteAccount));

        Role roleNormal = new Role(null, "ROLE_NORMAl");
        Role roleAdmin = new Role(null, "ROLE_ADMIN");

        roleNormal.getPermissoes().add(pAccount);
        roleAdmin.getPermissoes().addAll(Arrays.asList(pAccount, pListAccount, pDeleteAccount));

        roleRepository.saveAll(Arrays.asList(roleNormal, roleAdmin));

        User user_1 = new User(null,"Roque","Roque@gmail.com", passwordEncoder.encode("123456"), LocalDateTime.now());
        User user_2 = new User(null,"Teste","Teste@gmail.com", passwordEncoder.encode("123456"), LocalDateTime.now());

        Post post_1 = new Post(null,"Minha primeira viagem","minha viagem",LocalDateTime.now(),LocalDateTime.now(),user_1,false);
        Comment comment_1 = new Comment(null,"Linda paísagem",LocalDateTime.now(),false,post_1,user_2);

        Category category_1 = new Category(null,"Viagem","post sobre viagens","viagem");


        user_1.getRoles().add(roleAdmin);
        user_2.getRoles().add(roleNormal);

        userRepository.saveAll(Arrays.asList(user_1, user_2));

        postRepository.save(post_1);
        commentRepository.save(comment_1);
        categoryRepository.save(category_1);

        post_1.getCategories().add(category_1);
        postRepository.save(post_1);

    }
}
