package com.springmongodb.workshopmongodb.resources;

import com.springmongodb.workshopmongodb.domain.User;
import com.springmongodb.workshopmongodb.dto.UserDTO;
import com.springmongodb.workshopmongodb.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
