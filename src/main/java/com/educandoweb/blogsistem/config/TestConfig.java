package com.educandoweb.blogsistem.config;

import com.educandoweb.blogsistem.entities.Comment;
import com.educandoweb.blogsistem.entities.Post;
import com.educandoweb.blogsistem.entities.User;
import com.educandoweb.blogsistem.repositories.CommentRepository;
import com.educandoweb.blogsistem.repositories.PostRepository;
import com.educandoweb.blogsistem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

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


    @Override
    public void run(String... args) throws Exception {

        User user_1 = new User(null,"Roque","Roque@gmail.com","123456","ROLE_ADMIN", LocalDateTime.now());
        User user_2 = new User(null,"Teste","Teste@gmail.com","123456","ROLE_USER", LocalDateTime.now());

        Post post_1 = new Post(null,"Minha primeira viagem","viagem",LocalDateTime.now(),LocalDateTime.now(),user_1,false);
        Comment comment_1 = new Comment(null,"Linda paísagem",LocalDateTime.now(),false,post_1,user_2);


        userRepository.saveAll(Arrays.asList(user_1,user_2));
        postRepository.save(post_1);
        commentRepository.save(comment_1);

    }
}
