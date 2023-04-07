package com.springmongodb.workshopmongodb.config;

import com.springmongodb.workshopmongodb.domain.Post;
import com.springmongodb.workshopmongodb.domain.User;
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

        Post post1 = new Post(null, df.parse("01/02/2023"), "Partiu Viagem", "Vou vajar", maria);
        Post post2 = new Post(null, df.parse("01/02/2023"), "Bom dia", "acordei!", maria);

        postRepository.saveAll(Arrays.asList(post1,post2));
    }
}
