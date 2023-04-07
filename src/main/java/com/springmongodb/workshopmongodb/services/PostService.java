package com.springmongodb.workshopmongodb.services;

import com.springmongodb.workshopmongodb.domain.Post;
import com.springmongodb.workshopmongodb.repositories.PostRepository;
import com.springmongodb.workshopmongodb.services.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post findById(String id){
        return postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
    }
}