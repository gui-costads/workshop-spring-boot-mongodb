package com.springmongodb.workshopmongodb.resources;

import com.springmongodb.workshopmongodb.domain.Post;
import com.springmongodb.workshopmongodb.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    private PostService postService;

    public PostResource(PostService postService) {
        this.postService = postService;
    }
    @GetMapping(value =  "/{id}")
    public ResponseEntity<Post>  findById(@PathVariable String id){
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }
}
