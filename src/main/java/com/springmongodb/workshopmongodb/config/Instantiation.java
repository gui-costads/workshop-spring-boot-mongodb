package com.springmongodb.workshopmongodb.config;

import com.springmongodb.workshopmongodb.domain.Post;
import com.springmongodb.workshopmongodb.domain.User;
import com.springmongodb.workshopmongodb.dto.AuthorDTO;
import com.springmongodb.workshopmongodb.dto.CommentDTO;
import com.springmongodb.workshopmongodb.repositories.PostRepository;
import com.springmongodb.workshopmongodb.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    private UserRepository userRepository;
    private PostRepository postRepository;

    public Instantiation(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria,alex,bob));

        AuthorDTO author1 = new AuthorDTO(maria);

        Post post1 = new Post(null, df.parse("01/02/2023"), "Partiu Viagem", "Vou viajar", author1);
        Post post2 = new Post(null, df.parse("01/02/2023"), "Bom dia", "acordei!", author1);

        CommentDTO comment1 = new CommentDTO("Boa viagem!", df.parse("01/02/2023"),new AuthorDTO(alex));
        CommentDTO comment2 = new CommentDTO("Aproveite!", df.parse("02/02/2023"),new AuthorDTO(bob));
        CommentDTO comment3 = new CommentDTO("Tenha um otímo dia!", df.parse("03/02/2023"),new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(comment1,comment2));
        post1.getComments().addAll(Arrays.asList(comment3));

        postRepository.saveAll(Arrays.asList(post1,post2));

        maria.getPosts().addAll(Arrays.asList(post1,post2));
        userRepository.save(maria);




    }
}
