package com.springmongodb.workshopmongodb.resources;

import com.springmongodb.workshopmongodb.domain.Post;
import com.springmongodb.workshopmongodb.resources.util.URL;
import com.springmongodb.workshopmongodb.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post> posts = postService.findByTitle(text);
        return ResponseEntity.ok().body(posts);
    }
    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(@RequestParam(value = "text", defaultValue = "") String text,
                                                 @RequestParam(value = "minDate", defaultValue = "") String minDate,
                                                 @RequestParam(value = "maxDate", defaultValue = "") String maxDate){

        text = URL.decodeParam(text);
        Date minD = URL.convertDate(minDate, new Date(0L));
        Date maxD = URL.convertDate(maxDate,new Date());

        List<Post> posts = postService.fullSearch(text, minD, maxD);
        return ResponseEntity.ok().body(posts);
    }
}
