package com.springmongodb.workshopmongodb.resources;

import com.springmongodb.workshopmongodb.domain.User;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User user1 = new User("1", "Maria", "Maria@mail.com");
        User user2 = new User("2", "Joao", "Joao@mail.com");
        List<User> list =new ArrayList<>();
        list.addAll(Arrays.asList(user1,user2));
        return ResponseEntity.ok().body(list);

    }
}
