package com.springmongodb.workshopmongodb.resources;

import com.springmongodb.workshopmongodb.domain.User;
import com.springmongodb.workshopmongodb.dto.UserDTO;
import com.springmongodb.workshopmongodb.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    private  UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = userService.findAll();
        List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value =  "/{id}")
    public ResponseEntity<UserDTO>  findById(@PathVariable String id){
        User user = userService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(user));
    }

    @PostMapping
    public ResponseEntity<Void>  createUser (@RequestBody UserDTO userDTO){
        User user = userService.fromDTO(userDTO);
        userService.createUser(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void>  updateUser (@PathVariable String id, @RequestBody UserDTO userDTO){
        User user = userService.fromDTO(userDTO);
        user.setId(id);
        userService.updateUser(user);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value =  "/{id}")
    public ResponseEntity<Void>  deleteById(@PathVariable String id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
